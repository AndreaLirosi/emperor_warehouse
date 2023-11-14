package org.example;

import carrello.Carrello;
import user.PrivatoBuilder;
import user.Utente;

public class Main {

    public static void main(String[] args) {


<<<<<<< HEAD
        PrivatoBuilder builder = new PrivatoBuilder();

        builder.setName("Luca");
        builder.setSurname("Savini");
        builder.setEmail("SaviniLucaredeRomaplusultra@gmail.ermejo");
        builder.setPassword("iosoioevoinonsieteuncazzo");
        builder.setSpesa(new Carrello());

        Utente utenteLuca2 = builder.build();


        System.out.println(utenteLuca2);
=======

>>>>>>> fe09a708102eec864b634e57f02628fb2376af08
    }
}