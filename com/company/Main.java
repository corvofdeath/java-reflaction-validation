package com.company;

import api.Validator;
import api.ValidatorPropertyResult;
import api.ValidatorResult;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Teste meuTeste = new Teste();
        ValidatorResult result = Validator.validate(Teste.class, meuTeste);

        System.out.println("Errors: " + result.getErrors().size());
        System.out.println("ModelState: " + result.isModelState());

        for (ValidatorPropertyResult property : result.getErrors()) {
            System.out.println("Property: " + property.getProperty());
            System.out.println("Error: " + property.getError());
        }
    }
}
