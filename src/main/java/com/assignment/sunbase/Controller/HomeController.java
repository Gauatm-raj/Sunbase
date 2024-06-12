package com.assignment.sunbase.Controller;

import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class HomeController
{

    public String show(){
        return "index";
    }
}
