package com.company;

import attributes.Required;

public class Teste {

    private String name;

    @Required
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teste(String name) {
        this.name = name;
    }

    public Teste() {}
}
