package com.jsfdemo.app;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("helloworld")
@ViewScoped
public class HelloWorldBean implements Serializable {

    public String getMessage() {
        return "Hello World from Java";
    }

}