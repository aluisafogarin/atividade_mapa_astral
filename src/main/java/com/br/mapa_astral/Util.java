package com.br.mapa_astral;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;

public class Util {
    public static boolean isWithinRange(MonthDay dataNascimento, MonthDay startDate, MonthDay endDate) {
        return !(dataNascimento.isBefore(startDate) || dataNascimento.isAfter(endDate));
    }

    public static boolean isWithinRange(LocalTime birthHour, LocalTime startHour, LocalTime endHour) {
        return !(birthHour.isBefore(startHour) || birthHour.isAfter(endHour));
    }

    public static boolean isWithinRange(LocalDate dataNascimento, MonthDay startDate, MonthDay endDate) {
        LocalDate start;
        LocalDate end;

        if (dataNascimento.getMonth().equals(Month.JANUARY) && startDate.getMonth().equals(Month.DECEMBER) && endDate.getMonth().equals(Month.JANUARY)) {
            start = LocalDate.of((dataNascimento.getYear() - 1), startDate.getMonth(), startDate.getDayOfMonth());
            end = LocalDate.of((dataNascimento.getYear()), endDate.getMonth(), endDate.getDayOfMonth());
        } else if (dataNascimento.getMonth().equals(Month.DECEMBER) && startDate.getMonth().equals(Month.DECEMBER) && endDate.getMonth().equals(Month.JANUARY)) {
            start = LocalDate.of((dataNascimento.getYear()), startDate.getMonth(), startDate.getDayOfMonth());
            end = LocalDate.of((dataNascimento.getYear() + 1), endDate.getMonth(), endDate.getDayOfMonth());
        } else {
            start = LocalDate.of((dataNascimento.getYear()), startDate.getMonth(), startDate.getDayOfMonth());
            end = LocalDate.of((dataNascimento.getYear()), endDate.getMonth(), endDate.getDayOfMonth());
        }

        return !(dataNascimento.isBefore(start) || dataNascimento.isAfter(end));
    }
}
