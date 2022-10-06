package com.br.mapa_astral;

import java.util.ArrayList;
import java.util.List;

/*
 * De acordo com o site https://segredosdomundo.r7.com/signos-de-cada-mes-datas-ascendente/, os ascendentes seguem a seguinte regra:
 * Com base no Signo Solar, a cada duas horas há um ascendente definido.
 * Por exemplo, para o Signo de Áries, os ascedentes para os nascidos entre:
 *   - 6h31 e 8h30: Touro
 *   - 8h31 e 10h30: Gêmeos
 *   - 10h31 e 12h30: Câncer
 *   - etc
 *
 *
 * */
public enum Rising {

    AQUÁRIO(1),
    PEIXES(2),
    ÁRIES(3),
    TOURO(4),
    GÊMEOS(5),
    CÂNCER(6),
    LEÃO(7),
    VIRGEM(8),
    LIBRA(9),
    ESCORPIÃO(10),
    SAGITÁRIO(11),
    CAPRICÓRNIO(12);

    private final int value;

    Rising(int value) {
        this.value = value;
    }

    public static List<String> sortSignsAccordingToRising(Rising rising) {
        List<String> risingList = new ArrayList<>();
        String[] signList = Signs.getAllSignNames(Signs.class);
        int index = rising.value;

        for (int i = 0; i < 12; i++) {
            if (index == 12)
                index = 0;
            risingList.add(signList[index]);
            index++;
        }

        return risingList;
    }

}

