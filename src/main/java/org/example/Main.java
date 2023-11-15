package org.example;

import carrello.Carrello;
import magazzino.Magazzino;
import user.Azienda;
import user.Privato;
import user.PrivatoBuilder;
import user.Utente;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Utente> dbUtenti = new ArrayList<>();
        dbUtenti.add(new Utente("g", "h", "j", "kl"));
        Magazzino azienda_preimpostata_perOperazioni_utente= new Magazzino();
        boolean loginFlag = true;
        Utente utenteLog = Menu.selezioneMenu();


        do {
            if (utenteLog instanceof Privato) {
                Menu.menuPrivato();
                loginFlag = false;
            } else if (utenteLog instanceof Azienda) {
                Menu.menuAzienda();
                loginFlag = false;
            } else {
                try {
                    utenteLog = cercaUtente(utenteLog, dbUtenti);
                    loginFlag = false;
                } catch (NullPointerException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Ritenta il login o passa alla registrazione");
                }
                System.out.println(utenteLog);
            }
        } while (!loginFlag);

        boolean flagOperazioni = true;
        do {
            if (utenteLog instanceof Privato){

            }
            if (utenteLog instanceof Azienda){

            }


        }while (!flagOperazioni);










       /* PrivatoBuilder builder = new PrivatoBuilder();
        Privato userP = new Privato("name","surname","email", "password", new Carrello());
        Azienda userA = new Azienda("name","surname","email", "password", "nameSociety");
        builder.setName("Luca");
        builder.setSurname("Savini");
        builder.setEmail("SaviniLucaredeRomaplusultra@diomail.ermejo");
        builder.setPassword("iosoioevoinonsieteuncazzo");
        builder.setSpesa(new Carrello());*/


        /**
         *          COLLECTION DI UTENTI COME DATABASE
         * */
        /**
         *                  INIZIO PROCEDURE
         *          1.Login
         *          2.Inserimento tramite login/creazione dell'utente che sta usando il programma
         *          3.Inizio del loop
         *          4.Utilizzo del menù di spesa / Utilizzo del menù di magazzino
         *          5. Chiusura del programma
         * */


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
