package com.br.mapa_astral;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import static com.br.mapa_astral.Util.isWithinRange;


public class Main {
    public static void main(String[] args) {
        LocalDateTime dateAna = LocalDateTime.of(2000, Month.MAY, 12, 0, 32); // Touro
        LocalDateTime dateLucas = LocalDateTime.of(1993, 12, 16, 12, 30); // Sagitário
        LocalDateTime dateArtur = LocalDateTime.of(1987, Month.MARCH, 25, 19, 30); // Áries
        LocalDateTime dateTomas = LocalDateTime.of(1999, Month.AUGUST, 30, 11, 30); // Virgem

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Ana");
        System.out.println("Idade: " + Period.between(dateAna.toLocalDate(), LocalDate.now()).getYears());
        System.out.println("Ano de nascimento " + dateAna.getYear() + " foi bissexto? " + dateAna.toLocalDate().isLeapYear());
        System.out.println("Data e hora de nascimento: " + formatter.format(dateAna));
        System.out.println("Signo: " + getSigno(dateAna.toLocalDate()));
        System.out.println("Ascendente: " + getRising(getSigno(dateAna.toLocalDate()), dateAna.toLocalTime()));
        System.out.println("Lua: " + getLunarSign(dateAna.toLocalTime(), "Mococa"));
        System.out.println("############################");

        System.out.println("Lucas");
        System.out.println("Idade: " + Period.between(dateLucas.toLocalDate(), LocalDate.now()).getYears());
        System.out.println("Ano de nascimento " + dateLucas.getYear() + " foi bissexto? " + dateLucas.toLocalDate().isLeapYear());
        System.out.println("Data e hora de nascimento: " + formatter.format(dateLucas));
        System.out.println("Signo: " + getSigno(dateLucas.toLocalDate()));
        System.out.println("Ascendente: " + getRising(getSigno(dateLucas.toLocalDate()), dateLucas.toLocalTime()));
        System.out.println("Lua: " + getLunarSign(dateLucas.toLocalTime(), "Recife"));
        System.out.println("############################");

        System.out.println("Artur");
        System.out.println("Idade: " + Period.between(dateArtur.toLocalDate(), LocalDate.now()).getYears());
        System.out.println("Ano de nascimento " + dateArtur.getYear() + " foi bissexto? " + dateArtur.toLocalDate().isLeapYear());
        System.out.println("Data e hora de nascimento: " + formatter.format(dateArtur));
        System.out.println("Signo: " + getSigno(dateArtur.toLocalDate()));
        System.out.println("Ascendente: " + getRising(getSigno(dateArtur.toLocalDate()), dateArtur.toLocalTime()));
        System.out.println("Lua: " + getLunarSign(dateArtur.toLocalTime(), "Sao_Paulo"));
        System.out.println("############################");

        System.out.println("Tomas");
        System.out.println("Idade: " + Period.between(dateTomas.toLocalDate(), LocalDate.now()).getYears());
        System.out.println("Ano de nascimento " + dateTomas.getYear() + " foi bissexto? " + dateTomas.toLocalDate().isLeapYear());
        System.out.println("Data e hora de nascimento: " + formatter.format(dateTomas));
        System.out.println("Signo: " + getSigno(dateTomas.toLocalDate()));
        System.out.println("Ascendente: " + getRising(getSigno(dateTomas.toLocalDate()), dateTomas.toLocalTime()));
        System.out.println("Lua: " + getLunarSign(dateTomas.toLocalTime(), "Cuiaba"));
        System.out.println("############################");
    }

    private static String getLunarSign(LocalTime birthHour, String birthPlace) {
        Set<String> zones = ZoneId.getAvailableZoneIds();
        ZoneId zoneId = null;

        for (String zone : zones) {
            if (zone.contains(birthPlace)) {
                zoneId = ZoneId.of(zone);
                System.out.println("Local de nascimento: " + zoneId);

                if (zoneId.toString().equals("America/Recife") && birthHour.isAfter(LocalTime.NOON))
                    return "Casimiro";
                else if (zoneId.toString().equals("America/Cuiaba") && birthHour.isBefore(LocalTime.NOON))
                    return "Odin";
                else if (zoneId.toString().equals("America/Sao_Paulo"))
                    return "Gandalf";
            }
        }
        return "Dinossauro";
    }

    private static String getSigno(LocalDate birthDate) {
        List<MonthDay> startDates = Signs.getStartDates();
        List<MonthDay> endDates = Signs.getEndDates();

        for (MonthDay startDate : startDates) {
            if (isWithinRange(birthDate, startDate, endDates.get(startDates.indexOf(startDate)))) {
                return Signs.getSign(startDate, endDates.get(startDates.indexOf(startDate))).name();
            }
        }
        return "Erro!";
    }

    public static String getRising(String sign, LocalTime birthHour) {
        Rising risingSign = Rising.valueOf(sign);

        List<String> risingList = Rising.sortSignsAccordingToRising(risingSign);

        LocalTime start = LocalTime.of(6, 31);
        LocalTime end = start.plusMinutes(119);

        for (int index = 0; index < 12; index++) {
            if (birthHour.isAfter(LocalTime.MIDNIGHT) && start.equals(LocalTime.of(22, 31)) && end.equals(LocalTime.of(0, 30)) && birthHour.isBefore(end)) {
                return risingList.get(index);
            } else {
                if (isWithinRange(birthHour, start, end)) {
                    return risingList.get(index);
                }
            }
            start = end.plusMinutes(1);
            end = start.plusMinutes(119);
        }
        return "Ascendente não encontrado";
    }
}
