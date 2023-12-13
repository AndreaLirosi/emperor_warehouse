package org.example;

import Database.DbUtils;
import magazzino.Magazzino;
import magazzino.MagazzinoUtil;
import user.*;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {


    public static int selezioneMenuStamp() {
        System.out.println("clicca 1 se sei un Privato\nclicca 2 se sei un venditore\n3 se sei già registrato e vuoi loggare");
        Scanner inputMenu = new Scanner(System.in);
        if (!inputMenu.hasNextInt()) {
            throw new RuntimeException("Mi inserisci uno dei numeri richiesti? GRAZIE");
        }
        int scelta = inputMenu.nextInt();
        if (scelta < 0 || scelta > 3) {
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


    public static void ricerca_statica_o_attiva(Utente utente, Scanner scanner)  {
        System.out.println("Seleziona\n1 per ricercare passando un valore\n2 per cercare tramite ricerche preimpostate");
        int scelta = scanner.nextInt();
        try {
            if (utente instanceof Azienda) {
                System.out.println("Sei una azienda");
                switch (scelta) {
                    case 1 -> menuAzienda();
                    case 2 -> MainUtil.ricercaStaticaAzienda();
                    default -> throw new RuntimeException("Scelta non disponibile");
                }
            }else
            if (utente instanceof Privato) {
                System.out.println("Sei un privato");
                switch (scelta) {
                    case 1 -> menuPrivato((Privato) utente);
                    case 2 -> MainUtil.ricercaStatica_Privato();
                    default -> throw new RuntimeException("Scelta non disponibile");
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


    public static void menuPrivato(Privato utente) {


        Scanner inputMenu = new Scanner(System.in);
        int scelta;

        System.out.println("Selezionare operazione \n1 per aggiunta elemento nel carrello  \n2 per eliminare elemento dal carrello " +
                "\n3 per effettuare ricerca nel magazzino  \n4 calcolo totale spesa " + "\n5 acquista" +
                "\n0 per uscire dal menù");

        scelta = inputMenu.nextInt();
        menuScelta(scelta, inputMenu,utente);
    }

    public static void menuScelta(int scelta, Scanner inputMenu,Privato utente) {
        Magazzino magazzino = new Magazzino(DbUtils.mapMagazzino());

        switch (scelta) {
            case 0:
                System.out.println("Uscita dal Programma");
                inputMenu.close();
                System.exit(0);
                break;
            case 1:
                System.out.println("aggiunta elemento nel carrello");
                MainUtil.aggiungi_nella_spesa(utente);
                break;
            case 2:
                System.out.println("eliminare elemento dal carrello");
                    MainUtil.rimuovi_prodotto_nella_spesa(utente);
                break;
            case 3:
                System.out.println("effettuare ricerca nel magazzino");
                MainUtil.ricercaNelMagazzino();
                break;
            case 4:
                System.out.print("calcolo totale spesa: ");
                MainUtil.calcoloSpesa(utente);
                break;
            case 5:
                System.out.println("acquista");
                MainUtil.fine_spesa(utente);
                break;
            default:
                System.out.println("");
        }
    }

    public static void menuAzienda() {

        Scanner inputMenu = new Scanner(System.in);
        int scelta;

        System.out.println("Selezionare operazione \n1 per aggiungere un prodotto al magazzino \n2 per rimuovere un prodotto " +
                "\n3 per stampare i prodotti \n4 per effettuare ricerca nel magazzino " + "\n0 per uscire dal programma");

        scelta = inputMenu.nextInt();
        menuSceltaAzienda(scelta, inputMenu);
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


