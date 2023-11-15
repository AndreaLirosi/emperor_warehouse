package org.example;

import carrello.Carrello;
import user.Azienda;
import user.Privato;
import user.PrivatoBuilder;
import user.Utente;

public class Main {

    public static void main(String[] args) {

       /* PrivatoBuilder builder = new PrivatoBuilder();
        Privato userP = new Privato("name","surname","email", "password", new Carrello());
        Azienda userA = new Azienda("name","surname","email", "password", "nameSociety");
        builder.setName("Luca");
        builder.setSurname("Savini");
        builder.setEmail("SaviniLucaredeRomaplusultra@diomail.ermejo");
        builder.setPassword("iosoioevoinonsieteuncazzo");
        builder.setSpesa(new Carrello());

        Utente utenteLuca2 = builder.build();
        System.out.println(utenteLuca2);*/

        Menu.selezioneMenu();



    }
}
