package com.company;

import java.util.ArrayList;
import java.util.List;

public class Formated {
    public static List<String> format(List<String> personnummer) {
        List<String> formated = new ArrayList<String>();
        for (int i = 0; i < personnummer.size(); i++) {
            String formated_ = personnummer.get(i).trim().replace("-", "").replace("+", "");
            if (formated_.length() == 10) {
                formated.add("19" + formated_);
            } else {
                formated.add(formated_);
            }
        }
        return formated;
    }
}
