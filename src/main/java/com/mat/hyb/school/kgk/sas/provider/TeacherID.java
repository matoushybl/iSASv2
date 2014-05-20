package com.mat.hyb.school.kgk.sas.provider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matous on 20.5.14 for iSAS.
 */
public enum TeacherID {
    CVR("Mgr. Cvrkal", 143),
    CECH("Mgr. Čechová", 5),
    DOS("PhDr. Dostálová", 53),
    HAL("Mgr. Hálová", 6),
    HAN("Mgr. Handlířová", 173),
    HNI("Mgr. Hnilica", 135),
    HRAZ("Mgr. Hrazdílková", 174),
    HUB("Mgr. Hübschtová", 142),
    JARJAR("Mgr. Jarma", 60),
    JAR("PhDr. Jarmová", 30),
    KLIM("Mgr. Klimešová", 12),
    KOP("Mgr. Kopecký", 14),
    KOR("Mgr. Korvasová", 95),
    KOT("RnDr. Kotík", 15),
    KOU("Mgr. Koudelová", 180),
    KRO("Mgr. Krojzl", 17),
    LUN("Mgr. Lungová", 22),
    MAC("Mgr. Machain", 160),
    MAS("Mgr. Masaříková", 25),
    MAZ("Mgr. Mazalová", 182),
    MIK("Mgr. Mikslová", 28),
    MIN("Mgr. Minaříková", 29),
    ON("Mgr. Ondráček", 31),
    PES("PhDr. Pešková", 33),
    POL("Mgr. Polášková", 166),
    RUZ("Mgr. Růžičková", 149),
    SEL("Mgr. Selucká", 87),
    SCH("Mgr. Schovanec", 159),
    SOU("Mgr. Soukalová", 114),
    STA("Mgr. Staněk", 37),
    STJ("Mgr. Stuchlíková J.", 47),
    STM("Mgr. Stuchlíková M.", 38),
    SVO("Mgr. Svobodová", 39),
    SYN("Mgr. Synková", 163),
    SPI("Mgr. Špičáková", 141),
    SUS("Mgr. Šušlíková", 41),
    TRU("Mgr. Truschingerová", 1),
    URU("Mgr. Urubková", 43),
    VIK("Mgr. Viktorín", 44),
    VOR("Mgr. Voráč", 45),
    VOT("Mgr. Votoupalová", 110),
    VYL("Mgr. Výletová", 161);


    private String name;
    private int number;

    TeacherID(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public static List<String> getNames() {
        List<String> names = new ArrayList<String>();
        for (TeacherID teacherID : TeacherID.values()) {
            names.add(teacherID.getName());
        }
        return names;
    }

    public static TeacherID getEnumByName(String name) {
        for (TeacherID teacherID : TeacherID.values()) {
            if (teacherID.getName().equals(name)) {
                return teacherID;
            }
        }
        return CVR;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
}