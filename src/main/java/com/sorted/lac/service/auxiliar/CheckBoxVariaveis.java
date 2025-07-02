package com.sorted.lac.service.auxiliar;

import java.util.List;
import java.util.Map;

public class CheckBoxVariaveis {
    public static void checkBoxVariaveis(Map<String, Boolean> checkBoxRegionaisList, List<Boolean> listaCheckBoxes) {
        String[] nomes = {"cbBlumenau", "cbCacador", "cbCanoinhas", "cbChapeco", "cbConcordia", "cbCriciuma",
                "cbFlorianopolis", "cbItajai", "cbJaraguadosul", "cbJoacaba", "cbJoinville", "cbLages", "cbMafra",
                "cbRiodosul", "cbSaomigueldooeste", "cbTubarao", "cbGRL"};

        for (int i = 0; i < nomes.length; i++) {
            checkBoxRegionaisList.put(nomes[i], listaCheckBoxes.get(i));
        }
    }
}
