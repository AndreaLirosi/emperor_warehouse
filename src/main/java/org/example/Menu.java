package org.example;
import carrello.Carrello;
import prodotto.Prodotto;
import user.Privato;
import user.Utente;

import java.util.ArrayList;
import java.util.Scanner;
public class Menu {

public static void selezioneMenu () {

    System.out.println("clicca 1 se sei Utente privato\nclicca 2 se sei azienda");
    Scanner inputMenu = new Scanner(System.in);
    int scelta = inputMenu.nextInt();
    switch (scelta) {
        case 1:
            menuPrivato();
            break;
        case 2:
            menuAzienda();
            break;
        default:
            throw new RuntimeException("Scelta non disponibile: " + scelta);
    }
}
    public static void menuPrivato() {


        Scanner inputMenu = new Scanner(System.in);
        int scelta;

        System.out.println("Selezionare operazione \n1 per creazione carrello \n2 per aggiunta elemento nel carrello " +
                "\n3 per eliminare elemento dal carrello \n4 per effettuare ricerca nel magazzino " + "\n5 calcolo totale spesa" +
                "\n6 acquista" + "\n0 per uscire dal menù");

        scelta = inputMenu.nextInt();
        menuScelta(scelta);
    }
    public static void menuScelta (int scelta) {
            // la scelta, poi, viene inserita in uno switch che gestirà le operazioni.

            switch (scelta) {
                case 0:
                    System.out.println("Uscita dal Programma");
                    break;
                case 1:
                    System.out.println("aggiungi prodotto al magazzino");
                    break;
                case 2:
                    System.out.println("aggiunta elemento nel carrello");
                    break;
                case 3:
                    System.out.println("eliminare elemento dal carrello");
                    break;
                case 4:
                    System.out.println("effettuare ricerca nel magazzino");
                    break;
                case 5:
                    System.out.println("calcolo totale spesa");
                    break;
                case 6:
                    System.out.println("acquista");
                    break;
                default:
                    System.out.println("");
            }
        }
    public static void menuAzienda() {


        Scanner inputMenu = new Scanner(System.in);
        int scelta;

        System.out.println("Selezionare operazione \n1 oaggiungi prodotto al magazzino \n2 per aggiunta elemento nel carrello " +
                "\n3 per eliminare elemento dal carrello \n4 per effettuare ricerca nel magazzino " + "\n0 per uscire dal menù");

        scelta = inputMenu.nextInt();
        menuSceltaAzienda(scelta);
    }
    public static void menuSceltaAzienda (int scelta) {
        // la scelta, poi, viene inserita in uno switch che gestirà le operazioni.

        switch (scelta) {
            case 0:
                System.out.println("Uscita dal Programma");
                break;
            case 1:
                System.out.println("aggiungi prodotto al magazzino");
                break;
            case 2:
                System.out.println();
                break;
            case 3:
                System.out.println();
                break;
            case 4:
                System.out.println("effettuare ricerca nel magazzino");
                break;
            default:
                System.out.println("");
        }
    }

    }


