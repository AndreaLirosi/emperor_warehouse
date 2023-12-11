package org.example;

import user.Azienda;
import user.Privato;
import user.Utente;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Utente> dbUtenti = new ArrayList<>();
        dbUtenti.add(new Privato("g", "h", "j", "kl"));
        //Magazzino azienda_preimpostata_perOperazioni_utente = new Magazzino();
        boolean loginFlag = true;
        Utente utenteLog = Menu.selezioneMenu(Menu.selezioneMenuStamp());


        do {

            if (utenteLog instanceof Privato || utenteLog instanceof Azienda) {
                loginFlag = false;

            } else {
                try {
                    utenteLog = cercaUtente(utenteLog, dbUtenti);
                } catch (NullPointerException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Ritenta il login o passa alla registrazione");
                    utenteLog = Menu.selezioneMenu(Menu.selezioneMenuStamp());
                }
            }

        } while (loginFlag);


        boolean flagOperazioni = true;


        do {
            Menu.ricerca_statica_o_attiva(utenteLog, new Scanner(System.in));

        } while (flagOperazioni);

    }

    public static Utente cercaUtente(Utente utente_da_login, ArrayList<Utente> db) {
        for (int i = 0; i < db.size(); i++) {
            if (db.get(i).getName().equals(utente_da_login.getName())
                    && db.get(i).getSurname().equals(utente_da_login.getSurname())
                    && db.get(i).getPassword().equals(utente_da_login.getPassword())) {
                return db.get(i);
            }

        }
        throw new NullPointerException("Non esiste questo utente");
    }
}