package org.example;

import Database.DbUtils;
import carrello.Carrello;
import carrello.CarrelloUtil;
import magazzino.Magazzino;
import magazzino.MagazzinoUtil;
import magazzino.ParametroRicerca;
import prodotto.Prodotto;
import prodotto.ProdottoBuilder;
import prodotto.Tipo;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainUtil {


    public static boolean addProdotto_Magazzino(Scanner scanner) {
        ProdottoBuilder prodottoBuilder = new ProdottoBuilder();

        System.out.print("inserire Produttore: ");
        scanner.nextLine();
        prodottoBuilder.setProduttore(scanner.nextLine());
        System.out.print("inserire Modello: ");
        prodottoBuilder.setModello(scanner.nextLine());
        System.out.print("inserire Descrizione: ");
        prodottoBuilder.setDescrizione(scanner.nextLine());
        System.out.print("inserire Dimensione: ");
        prodottoBuilder.setDimensione(scanner.nextDouble());
        scanner.nextLine();
        System.out.print("inserire Memoria: ");
        prodottoBuilder.setMemoria(scanner.nextLine());
        System.out.print("inserire Prezzo_acquisto: ");
        prodottoBuilder.setPrezzoAcquisto(scanner.nextBigDecimal());
        scanner.nextLine();
        System.out.print("inserire Prezzo_vendita: ");
        prodottoBuilder.setPrezzoVendita(scanner.nextBigDecimal());
        scanner.nextLine();
        System.out.print("inserire Tipo: ");
        prodottoBuilder.setTipo(Tipo.stringTipo(scanner.nextLine()));

        try {
            DbUtils.addProduct_to_db(prodottoBuilder.build());
            return true;
        } catch (SQLException e) {
            System.out.println("Oggetto non inserito");
            return false;
        }
    }


    public static void ricercaStatica_Privato() throws SQLException {
        Scanner inputMenu = new Scanner(System.in);
        System.out.print("seleziona parametro di ricerca: \n");
        System.out.println("premi\n" + "\n1)Produttore" + "\n2)Modello" + "\n3)Dimensione" + "\n4)Memoria" + "\n6)PrezzoVendita"  + "\n0)torna al menu");
        int parametro = inputMenu.nextInt();

        switch (parametro) {
            case 1:
                System.out.println(MagazzinoUtil.ricercaProdottiStatica_azienda(ParametroRicerca.PRODUTTORE));
                break;
            case 2:
                System.out.println(MagazzinoUtil.ricercaProdottiStatica_azienda(ParametroRicerca.MODELLO));
                break;
            case 3:
                System.out.println(MagazzinoUtil.ricercaProdottiStatica_azienda(ParametroRicerca.DIMENSIONE));
                break;
            case 4:
                System.out.println(MagazzinoUtil.ricercaProdottiStatica_azienda(ParametroRicerca.MEMORIA));
                break;
            case 5:
                break;
            case 6:
                System.out.println(MagazzinoUtil.ricercaProdottiStatica_azienda(ParametroRicerca.PREZZOVENDITA));
                break;
            default:
                System.out.println("Tornando al menu Privato...");
                break;
        }
    }
    public static void ricercaStaticaAzienda() throws SQLException {
        Scanner inputMenu = new Scanner(System.in);
        System.out.print("seleziona parametro di ricerca: \n");
        System.out.println("premi\n" + "\n1)Produttore" + "\n2)Modello" + "\n3)Dimensione" + "\n4)Memoria" + "\n6)PrezzoVendita"  + "\n0)torna al menu");
        int parametro = inputMenu.nextInt();

        switch (parametro) {
            case 1:
                System.out.println(MagazzinoUtil.ricercaProdottiStatica_azienda(ParametroRicerca.PRODUTTORE));
                break;
            case 2:
                System.out.println(MagazzinoUtil.ricercaProdottiStatica_azienda(ParametroRicerca.MODELLO));
                break;
            case 3:
                System.out.println(MagazzinoUtil.ricercaProdottiStatica_azienda(ParametroRicerca.DIMENSIONE));
                break;
            case 4:
                System.out.println(MagazzinoUtil.ricercaProdottiStatica_azienda(ParametroRicerca.MEMORIA));
                break;
            case 5:
                System.out.println(MagazzinoUtil.ricercaProdottiStatica_azienda(ParametroRicerca.PREZZOACQUISTO));
                break;
            case 6:
                System.out.println(MagazzinoUtil.ricercaProdottiStatica_azienda(ParametroRicerca.PREZZOVENDITA));
                break;
            case 0:
                System.out.println("Tornando al menu Azienda...");
                break;
        }
    }

    public static void ricercaNelMagazzino() {
        Scanner inputMenu = new Scanner(System.in);
        System.out.print("seleziona parametro di ricerca: \n");
        System.out.println("premi\n" + "\n1)Produttore" + "\n2)Modello" + "\n3)Dimensione" + "\n4)Memoria" + "\n5)PrezzoAcquisto" + "\n6)PrezzoVendita" + "\n7)Id" + "\n8)Range di Prezzo" + "\n0)torna al menu");
        int parametro = inputMenu.nextInt();

        switch (parametro) {
            case 1:
                System.out.println(MagazzinoUtil.ricercaPerProduttore());
                break;
            case 2:
                System.out.println(MagazzinoUtil.ricercaPerModello());
                break;
            case 3:
                System.out.println(MagazzinoUtil.ricercaPerDimensione());
                break;
            case 4:
                System.out.println(MagazzinoUtil.ricercaPerMemoria());
                break;
            case 5:
                System.out.println(MagazzinoUtil.ricercaPerPrezzoAcquisto());
                break;
            case 6:
                System.out.println(MagazzinoUtil.ricercaPerPrezzoVendita());
                break;
            case 7:
                System.out.println(MagazzinoUtil.ricercaPerId());
                break;
            case 8:
                System.out.println(MagazzinoUtil.ricercaPerRange());
                break;
            case 0:
                System.out.println("Tornando al menu Azienda...");
                break;
        }

    }

}


