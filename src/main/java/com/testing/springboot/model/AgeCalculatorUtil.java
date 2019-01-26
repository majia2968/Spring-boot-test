package com.testing.springboot.model;

import java.time.LocalDate;
import java.time.Period;

public class AgeCalculatorUtil {

    public static int calculateAge(String dob) {

        LocalDate birthDate = LocalDate.parse(dob);
        LocalDate currentDate = LocalDate.now();

        return Period.between(birthDate, currentDate).getYears();
    }
}
