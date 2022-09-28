package com.innoeye.hospitalmanagementsystem.model;

import com.innoeye.hospitalmanagementsystem.annotation.ColorValidation;

public class Color {

    @ColorValidation(message="My hero")
    private String colorName;

    private String code;

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
