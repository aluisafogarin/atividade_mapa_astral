package com.br.mapa_astral;

import java.time.MonthDay;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Signs {

    AQUÁRIO(MonthDay.of(1, 21), MonthDay.of(2, 18)),
    PEIXES(MonthDay.of(2, 19), MonthDay.of(3, 20)),
    ÁRIES(MonthDay.of(3, 21), MonthDay.of(4, 21)),
    TOURO(MonthDay.of(4, 22), MonthDay.of(5, 20)),
    GÊMEOS(MonthDay.of(5, 21), MonthDay.of(6, 20)),
    CÂNCER(MonthDay.of(6, 21), MonthDay.of(7, 22)),
    LEÃO(MonthDay.of(7, 23), MonthDay.of(8, 22)),
    VIRGEM(MonthDay.of(8, 23), MonthDay.of(9, 22)),
    LIBRA(MonthDay.of(9, 23), MonthDay.of(10, 22)),
    ESCORPIÃO(MonthDay.of(10, 23), MonthDay.of(11, 21)),
    SAGITÁRIO(MonthDay.of(11, 22), MonthDay.of(12, 21)),
    CAPRICÓRNIO(MonthDay.of(12, 22), MonthDay.of(1, 20));

    private final MonthDay signStartDate;
    private final MonthDay signEndDate;

    Signs(MonthDay signStartDate, MonthDay signEndDate) {
        this.signStartDate = signStartDate;
        this.signEndDate = signEndDate;
    }

    public static List<MonthDay> getStartDates() {
        List<MonthDay> startList = new ArrayList<MonthDay>();

        for (Signs sign : values()) {
            startList.add(sign.signStartDate);
        }
        return startList;
    }

    public static List<MonthDay> getEndDates() {
        List<MonthDay> endList = new ArrayList<MonthDay>();

        for (Signs sign : values()) {
            endList.add(sign.signEndDate);
        }
        return endList;
    }

    public static Signs getSign(MonthDay startDate, MonthDay endDate) {
        for (Signs sign : values()) {
            if (sign.signStartDate == startDate && sign.signEndDate == endDate) {
                return sign;
            }
        }
        return null;
    }

    public static String[] getAllSignNames(Class<? extends Enum<?>> e) {
        return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
    }

}

