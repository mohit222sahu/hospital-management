package com.innoeye.hospitalmanagementsystem.controller.Impl;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innoeye.hospitalmanagementsystem.model.Color;

@RestController("ColorController")
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/color")

public class ColorController {
	@PostMapping(path = "getColorCode")
    public Color getColorCode(@Valid @RequestBody Color color){

        Color colorObj = new Color();
        colorObj.setColorName(color.getColorName());
        if(color.getColorName().equals("RED")){
            colorObj.setCode("R100");
        }else if(color.getColorName().equals("GREEN")){
            colorObj.setCode("G200");
        }else{
            colorObj.setCode("B300");
        }
        return colorObj;
    }
}
