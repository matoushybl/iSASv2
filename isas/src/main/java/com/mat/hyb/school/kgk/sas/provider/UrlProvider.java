package com.mat.hyb.school.kgk.sas.provider;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.Calendar;

/**
 * @author <a href="mailto:hyblmatous@gmail.com">Matous Hybl</a>
 */
@EBean
public class UrlProvider {

    public static final String WEBSITE = "http://www.gymkyjov.cz/";
    private static final String MOODLE_URL = "http://www.gymkyjov.cz/moodle";
    private static final String CANTEEN_URL = "http://www.gymkyjov.cz:8082";
    private static final String SUBSTITUTION_URL =
            "http://www.gymkyjov.cz/isas/suplovani.php?zobraz=tridy-1&suplovani=";
    private static final String DATE = "&rezim=den&datum=";
    private static final String MARKS = "http://www.gymkyjov.cz/isas/prubezna-klasifikace.php";
    private static final String TIMETABLE =
            "http://www.gymkyjov.cz/isas/rozvrh-hodin.php?zobraz=tridy-1&rozvrh=";
    private static final String TEACHER_TIMETABLE
            = "http://www.gymkyjov.cz/isas/rozvrh-hodin.php?zobraz=ucitel&rozvrh=";

    private static final String TEACHER_SUBSTITUTION_URL
            = "http://www.gymkyjov.cz/isas/suplovani.php?zobraz=suplujici&suplovani=";
    @Bean
    PreferenceProvider preferencesProvider;

    public static String getMoodleUrl() {
        return MOODLE_URL;
    }

    public static String getCanteenUrl() {
        return CANTEEN_URL;
    }

    public String getSubstitutionTodayUrl() {
        String url = SUBSTITUTION_URL;
        if (preferencesProvider.isTeacher()) {
            url = TEACHER_SUBSTITUTION_URL;
        }
        return url + getSavedId();
    }

    public String getSubstitutionTomorrowUrl() {
        String url = SUBSTITUTION_URL;
        if (preferencesProvider.isTeacher()) {
            url = TEACHER_SUBSTITUTION_URL;
        }
        return url + getSavedId() + DATE + getTomorrowDate();
    }

    public String getMarksUrl() {
        return MARKS;
    }

    private String getTomorrowDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        if (day == 6 && calendar.get(Calendar.HOUR_OF_DAY) >= 16) {
            calendar.add(Calendar.DAY_OF_YEAR, 3);
        } else if (day == 7) {
            calendar.add(Calendar.DAY_OF_YEAR, 2);
        } else {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }
        return String.valueOf(calendar.get(Calendar.YEAR)) + "-"
                + String.valueOf(calendar.get(Calendar.MONTH) + 1) + "-"
                + String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
    }

    public String getSuggestedDateUrl() {
        Calendar calendar = Calendar.getInstance();
        if (calendar.get(Calendar.HOUR_OF_DAY) >= 16 || calendar.get(Calendar.DAY_OF_WEEK) >= 6
                || calendar.get(Calendar.DAY_OF_WEEK) == 1) {
            return getSubstitutionTomorrowUrl();
        } else {
            return getSubstitutionTodayUrl();
        }
    }

    private String getSavedId() {
        if (preferencesProvider.isTeacher()) {
            return String.valueOf(preferencesProvider.getTeacherId().getNumber());
        }
        return String.valueOf(preferencesProvider.getDefaultClass().getId());
    }

    private int getSavedClassId() {
        return preferencesProvider.getDefaultClass().getId();
    }

    public String getTimetableUrl(int id) {
        String url = TIMETABLE;
        if (preferencesProvider.isTeacher()) {
            url = TEACHER_TIMETABLE;
        }
        return url + Integer.valueOf(id);
    }

    public String getOurTimetableUrl() {
        if (preferencesProvider.isTeacher()) {
            return getTimetableUrl(preferencesProvider.getTeacherId().getNumber());
        }
        return getTimetableUrl(getSavedClassId());
    }

}