package by.etc.validator.impl;

import by.etc.validator.PlaneDataValidator;

import java.util.regex.Pattern;

public class PlaneDataValidatorImpl implements PlaneDataValidator {

    @Override
    public boolean isValid(String planeData) {
        String regex = "^(-{0,1}[\\d]{1,}\\.{0,1}[\\d]{0,}\\s){8}-{0,1}[\\d]{1,}\\.{0,1}[\\d]{0,}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(planeData).matches();
    }
}
