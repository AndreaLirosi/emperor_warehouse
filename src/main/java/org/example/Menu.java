package org.example;

import Database.DbUtils;
import carrello.Carrello;
import magazzino.Magazzino;
import magazzino.MagazzinoUtil;
import prodotto.Prodotto;
import user.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {


    public static int selezioneMenuStamp(){
        System.out.println("clicca 1 se sei un Privato\nclicca 2 se sei un venditore");
        Scanner inputMenu = new Scanner(System.in);
        if (!inputMenu.hasNextInt()){
            throw new RuntimeException("Mi inserisci uno dei numeri richiesti? GRAZIE");
        }
        int scelta = inputMenu.nextInt();
        if (scelta<0 || scelta>3){
            throw new RuntimeException("Mi inserisci uno dei numeri richiesti? GRAZIE");
        }
        return scelta;
    }

    public static Utente selezioneMenu(int scelta) {


        switch (scelta) {
            case 1:
                return creazionePrivato();
            case 2:
                return creazioneAzienda();
            case 3:
                return login();
            default:
                throw new RuntimeException("Scelta non disponibile: " + selezioneMenuStamp());
        }
    }

    private static Privato creazionePrivato() {
        System.out.println("crea nuovo account:");
        Scanner inputMenu = new Scanner(System.in);
        System.out.print("Inserisci Cognome: ");
        PrivatoBuilder builder = new PrivatoBuilder();
        builder.setSurname(inputMenu.nextLine());
        System.out.print("\nInserisci nome: ");
        builder.setName(inputMenu.nextLine());
        System.out.print("\nInserisci email: ");
        builder.setEmail(inputMenu.nextLine());
        System.out.print("\nInserisci password: ");
        builder.setPassword(inputMenu.nextLine());
        return builder.build();

    }

    private static Azienda creazioneAzienda() {
        System.out.println("inserire dati:");
        Scanner inputMenu = new Scanner(System.in);
        System.out.print("Inserisci Cognome: ");
        AziendaBuilder builder = new AziendaBuilder();
        builder.setSurname(inputMenu.nextLine());
        System.out.print("\nInserisci nome: ");
        builder.setName(inputMenu.nextLine());
        System.out.print("\nInserisci email: ");
        builder.setEmail(inputMenu.nextLine());
        System.out.print("\nInserisci password: ");
        builder.setPassword(inputMenu.nextLine());
        System.out.print("\nInserisci nome Azienda: ");
        builder.setSocietyName(inputMenu.nextLine());

        return builder.build();
    }

    private static Utente login() {
        UtenteBuilder builder = new UtenteBuilder();
        System.out.println("inserire dati:");
        Scanner inputMenu = new Scanner(System.in);
        System.out.print("Inserisci Cognome: ");
        builder.setSurname(inputMenu.nextLine());
        System.out.print("\nInserisci nome: ");
        builder.setName(inputMenu.nextLine());
        System.out.print("\nInserisci password: ");
        builder.setPassword(inputMenu.nextLine());
        return builder.build();
    }

    public static void menuPrivato(Privato privato) {


        Scanner inputMenu = new Scanner(System.in);
        int scelta;

        System.out.println("Selezionare operazione \n1 per aggiunta elemento nel carrello  \n2 per eliminare elemento dal carrello " +
                "\n3 per effettuare ricerca nel magazzino  \n4 calcolo totale spesa " + "\n5 acquista" +
                "\n0 per uscire dal menù");

        scelta = inputMenu.nextInt();
        menuScelta(scelta, inputMenu);
    }

    public static void menuScelta(int scelta, Scanner inputMenu) {
        Magazzino magazzino = new Magazzino(DbUtils.mapMagazzino());

        switch (scelta) {
            case 0:
                System.out.println("Uscita dal Programma");
                inputMenu.close();
                System.exit(0);
                break;
            case 1:
                System.out.println("aggiunta elemento nel carrello");
                /*MainUtil. addProdotto_Carrello */
                MainUtil.addProdotto_Carrello (new Carrello(),magazzino, inputMenu);
                break;
            case 2:
                System.out.println("eliminare elemento dal carrello");
                /*MainUtil. removeProdotto_Carrello */
                break;
            case 3:
                System.out.println("effettuare ricerca nel magazzino");
                MainUtil.ricercaNelMagazzino();
                break;
            case 4:
                System.out.println("calcolo totale spesa");
                break;
            case 5:
                System.out.println("acquista");
                /*MainUtil. soldCarrello */
                break;
            default:
                System.out.println("");
        }
    }

    public static void menuAzienda(Azienda azienda) {


        Scanner inputMenu = new Scanner(System.in);
        int scelta;

        System.out.println("Selezionare operazione \n1 per aggiungere un prodotto al magazzino \n2 per rimuovere un prodotto " +
                "\n3 per stampare i prodotti \n4 per effettuare ricerca nel magazzino " + "\n0 per uscire dal menù");

        scelta = inputMenu.nextInt();
        menuSceltaAzienda(scelta,inputMenu);
    }

    public static void menuSceltaAzienda(int scelta, Scanner inputMenu) {

        switch (scelta) {
            case 0:
                System.out.println("Uscita dal Programma");
                inputMenu.close();
                System.exit(0);
                break;
            case 1:
                System.out.println("aggiungi prodotto al magazzino");
                /*MainUtil.addProdotto_Magazzino */
                MainUtil.addProdotto_Magazzino(inputMenu);
                break;
            case 2:
                System.out.println("rimuovi prodotto");
                MagazzinoUtil.rimuoviProdotto();
                break;
            case 3:
                System.out.println("stampa prodotti");
                MagazzinoUtil.stampaProdotti();
                break;
            case 4:
                System.out.println("effettuare ricerca nel magazzino");
                /*MainUtil.findProdotto_Magazzino */
                MainUtil.ricercaNelMagazzino();
                break;
            default:
                System.out.println("");
        }
    }

}


