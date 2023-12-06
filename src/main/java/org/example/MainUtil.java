package org.example;

import carrello.Carrello;
import carrello.CarrelloUtil;
import magazzino.Magazzino;
import magazzino.MagazzinoUtil;
import magazzino.ParametroRicerca;
import prodotto.ProdottoBuilder;

import java.math.BigDecimal;
import java.util.Scanner;

public class MainUtil {


    public static boolean addProdotto_Magazzino(Magazzino magazzino, Scanner scanner) {
        System.out.println("aggiungi:\n1-> Tablet\n2-> Notebook\n3-> Smartphone");
        int scelta = scanner.nextInt();
        switch (scelta) {
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                return true;
            default:
                return false;
        }
    }

    public static boolean addProdotto_Carrello(Carrello carrello, Magazzino magazzino, Scanner scanner) {
        System.out.println("aggiungi:\n1-> Tablet\n2-> Notebook\n3-> Smartphone");
        int scelta = scanner.nextInt();
        switch (scelta) {
            case 1:

                return true;
            case 2:

                return true;
            case 3:

                return true;
            default:

                return false;
        }
    }

    public static void ricercaNelMagazzino(Magazzino magazzino) {
        Scanner inputMenu = new Scanner(System.in);
        System.out.print("seleziona parametro di ricerca: \n");


        System.out.println("premi\n" + "\n1)Produttore" + "\n2)Modello" + "\n3)Dimensione" + "\n4)Memoria" + "\n5)PrezzoAcquisto" + "\n6)PrezzoVendita" + "\n7)Id" + "\n8)Range di Prezzo" + "\n0)torna al menu");

        int parametro = inputMenu.nextInt();
        switch (parametro) {
            case 1:
                //MagazzinoUtil.ricercaPerProduttore(magazzino, );
                System.out.println(MagazzinoUtil.ricercaPerProduttore());

                break;
            case 2:
                //MagazzinoUtil.ricercaPerModello(magazzino, );
                System.out.println(MagazzinoUtil.ricercaPerModello());

                break;
            case 3:
                //MagazzinoUtil.ricercaPerDimensione(magazzino, );
                System.out.println(MagazzinoUtil.ricercaPerDimensione());

                break;
            case 4:
                //MagazzinoUtil.ricercaPerMemoria(magazzino, );
                System.out.println(MagazzinoUtil.ricercaPerMemoria());

                break;
            case 5:
                //MagazzinoUtil.ricercaPerPrezzoAcquisto(magazzino, );
                System.out.println(MagazzinoUtil.ricercaPerPrezzoAcquisto());

                break;
            case 6:
                //MagazzinoUtil.ricercaPerPrezzoVendita(magazzino, );
                System.out.println(MagazzinoUtil.ricercaPerPrezzoVendita());

                break;
            case 7:
                //MagazzinoUtil.ricercaPerId(magazzino, );
                System.out.println(MagazzinoUtil.ricercaPerId());

                break;
            case 8:
                //MagazzinoUtil.ricercaPerId(magazzino, );
                System.out.println(MagazzinoUtil.ricercaPerRange());

                break;

            case 0:
                System.out.println("Tornando al menu Azienda...");
                break;
        }

    }

    /*public static double calcoloSpesa() {
        double sum = 0;
      for (Prodotto prodotto : carrello) {
          sum += prodotto.getPrezzoAcquisto();
      }
      return sum;
    };*/
};


