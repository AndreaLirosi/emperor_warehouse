package org.example;

import carrello.Carrello;
import carrello.CarrelloUtil;
import magazzino.Magazzino;
import magazzino.MagazzinoUtil;
import magazzino.ParametroRicerca;
import prodotto.Notebook;
import prodotto.Prodotto;
import prodotto.Smartphone;
import prodotto.Tablet;
import user.Azienda;
import user.Utente;

import java.math.BigDecimal;
import java.util.Scanner;

public class MainUtil {
    public static boolean addProdotto_Magazzino(Magazzino magazzino, Scanner scanner) {
        System.out.println("aggiungi:\n1-> Tablet\n2-> Notebook\n3-> Smartphone");
        int scelta = scanner.nextInt();
        switch (scelta) {
            case 1:
                MagazzinoUtil.aggiungereProdotto(magazzino, new Tablet("Apple", "PinkLady", "la mela del supermercato", 1, "piu del normale", BigDecimal.valueOf(20), BigDecimal.valueOf(20000), "Giacomo"));
                return true;
            case 2:
                MagazzinoUtil.aggiungereProdotto(magazzino, new Notebook("Ma chi li compra?", "Ma pigliati un fisso", "che poi ti ritrovi copme paola", 0, "non ne ha", BigDecimal.valueOf(20), BigDecimal.valueOf(20000), "Paola2"));
                return true;
            case 3:
                MagazzinoUtil.aggiungereProdotto(magazzino, new Smartphone("Apple", "Smith", "la mela del supermercato", 1, "piu del normale", BigDecimal.valueOf(20), BigDecimal.valueOf(20000), "Giacomo"));
                return true;
            default:
                MagazzinoUtil.aggiungereProdotto(magazzino, new Tablet("Apple", "PinkLady", "la mela del supermercato", 1, "piu del normale", BigDecimal.valueOf(20), BigDecimal.valueOf(20000), "Giacomo"));
                return false;
        }
    }

    public static boolean addProdotto_Carrello(Carrello carrello, Magazzino magazzino, Scanner scanner) {
        System.out.println("aggiungi:\n1-> Tablet\n2-> Notebook\n3-> Smartphone");
        int scelta = scanner.nextInt();
        switch (scelta) {
            case 1:
                CarrelloUtil.addProdottoACarrello(carrello, new Tablet("Apple", "PinkLady", "la mela del supermercato", 1, "piu del normale", BigDecimal.valueOf(20), BigDecimal.valueOf(20000), "Giacomo"), magazzino);
                return true;
            case 2:
                CarrelloUtil.addProdottoACarrello(carrello, new Notebook("Ma chi li compra?", "Ma pigliati un fisso", "che poi ti ritrovi copme paola", 0, "non ne ha", BigDecimal.valueOf(20), BigDecimal.valueOf(20000), "Paola2"), magazzino);
                return true;
            case 3:
                CarrelloUtil.addProdottoACarrello(carrello, new Smartphone("Apple", "Smith", "la mela del supermercato", 1, "piu del normale", BigDecimal.valueOf(20), BigDecimal.valueOf(20000), "Giacomo"), magazzino);
                return true;
            default:
                CarrelloUtil.addProdottoACarrello(carrello, new Tablet("Apple", "PinkLady", "la mela del supermercato", 1, "piu del normale", BigDecimal.valueOf(20), BigDecimal.valueOf(20000), "Giacomo"), magazzino);
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
                System.out.println("ricercaPerProduttore");
                MagazzinoUtil.ricercaPerProduttore(magazzino,"Produttore");
                break;
            case 2:
                //MagazzinoUtil.ricercaPerModello(magazzino, );
                System.out.println("ricercaPerModello");
                MagazzinoUtil.ricercaPerProduttore(magazzino,"Produttore");
                break;
            case 3:
                //MagazzinoUtil.ricercaPerDimensione(magazzino, );
                System.out.println("ricercaPerDimensione");
                MagazzinoUtil.ricercaPerProduttore(magazzino,"Dimensione");
                break;
            case 4:
                //MagazzinoUtil.ricercaPerMemoria(magazzino, );
                System.out.println("ricercaPerMemoria");
                MagazzinoUtil.ricercaPerProduttore(magazzino,"Memoria");
                break;
            case 5:
                //MagazzinoUtil.ricercaPerPrezzoAcquisto(magazzino, );
                System.out.println("ricercaPerPrezzoAcquisto");
                MagazzinoUtil.ricercaPerProduttore(magazzino,"PrezzoAcquisto");
                break;
            case 6:
                //MagazzinoUtil.ricercaPerPrezzoVendita(magazzino, );
                System.out.println("ricercaPerPrezzoVendita");
                MagazzinoUtil.ricercaPerProduttore(magazzino,"PrezzoVendità");
                break;
            case 7:
                //MagazzinoUtil.ricercaPerId(magazzino, );
                System.out.println("ricercaPerId");
                MagazzinoUtil.ricercaPerProduttore(magazzino,"id");
                break;
            case 8:
                //MagazzinoUtil.ricercaPerId(magazzino, );
                System.out.println("cercaProdottiRangePrezzo");
                MagazzinoUtil.cercaProdottiRangePrezzo(magazzino);
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


