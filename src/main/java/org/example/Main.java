package org.example;
import magazzino.Magazzino;
import user.Azienda;
import user.Privato;
import user.Utente;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Utente> dbUtenti = new ArrayList<>();
        dbUtenti.add(new Utente("g", "h", "j", "kl"));
        Magazzino azienda_preimpostata_perOperazioni_utente = new Magazzino();
        boolean loginFlag = true;
        Utente utenteLog = Menu.selezioneMenu();


        do {

            if (utenteLog instanceof Privato) {
                Menu.menuPrivato((Privato) utenteLog);
                loginFlag = false;
            } else if (utenteLog instanceof Azienda) {
                Menu.menuAzienda((Azienda) utenteLog);
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

        }while (!loginFlag) ;

        boolean flagOperazioni = true;
        do {
            if (utenteLog instanceof Privato) {

            }
            if (utenteLog instanceof Azienda) {

            }


        } while (!flagOperazioni);
    }
    public static Utente cercaUtente (Utente utente_da_login, ArrayList < Utente > db){
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