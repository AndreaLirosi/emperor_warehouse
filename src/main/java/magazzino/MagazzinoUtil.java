package magazzino;

import Database.DbUtils;
import prodotto.Prodotto;
import user.Privato;
import user.Utente;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MagazzinoUtil {

    public static boolean aggiungereProdotto(Prodotto prodotto) {
        try {
            DbUtils.addProduct_to_db(prodotto);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean rimuoviProdotti(Privato utente) {
        DbUtils.rimozione_spesa_dal_db(utente);
        return true;
    }

    public static boolean rimuoviProdotto() {
        Scanner inputMenu = new Scanner(System.in);
        System.out.print("inserisci l'ID del prodotto da eliminare: ");
        String scelta = inputMenu.nextLine();
        DbUtils.delete_by_id(Integer.parseInt(scelta));
        return true;
    }

    public static void stampaProdotti() {
        ArrayList<Prodotto> listaProdotti = DbUtils.mapMagazzino();

        for (Prodotto prodotto : listaProdotti) {
            System.out.println(prodotto.toString());
        }
    }

    public static ArrayList<Prodotto> cercaProdotti(ParametroRicerca parametro) {
        return switch (parametro) {
            case PRODUTTORE -> ricercaPerProduttore();
            case MODELLO -> ricercaPerModello();
            case DESCRIZIONE -> ricercaPerDescrizione();
            case DIMENSIONE -> ricercaPerDimensione();
            case MEMORIA -> ricercaPerMemoria();
            case PREZZOACQUISTO -> ricercaPerPrezzoAcquisto();
            case PREZZOVENDITA -> ricercaPerPrezzoVendita();
            case RANGE -> ricercaPerRange();

            default -> throw new IllegalStateException("Se conosci già l'id del prodotto aggiungilo al tuo carrello!");

        };
    }

    public static ArrayList<Prodotto> ricercaProdottiStatica_azienda(ParametroRicerca parametro) throws SQLException {
        return switch (parametro) {
            case PRODUTTORE -> DbUtils.stampa_view_produttore();
            case MODELLO -> DbUtils.stampa_view_modello();
            case DESCRIZIONE -> DbUtils.stampa_view_descrizione();
            case DIMENSIONE -> DbUtils.stampa_view_dimensione_asc();
            case MEMORIA -> DbUtils.stampa_view_memoria_asc();
            case PREZZOACQUISTO -> DbUtils.stampa_view_prezzo_acquisto_asc();
            case PREZZOVENDITA -> DbUtils.stampa_view_prezzo_vendita_asc();

            default -> throw new IllegalStateException("Errore: ricerca fallita!");
        };
    }

    public static ArrayList<Prodotto> ricercaProdottiStatica_spesa(ParametroRicerca parametro) throws SQLException {
        return switch (parametro) {
            case PRODUTTORE -> DbUtils.stampa_view_produttore();
            case MODELLO -> DbUtils.stampa_view_modello();
            case DIMENSIONE -> DbUtils.stampa_view_dimensione_asc();
            case MEMORIA -> DbUtils.stampa_view_memoria_asc();
            case PREZZOVENDITA -> DbUtils.stampa_view_prezzo_vendita_asc();

            default -> throw new IllegalStateException("Errore: ricerca fallita!");
        };
    }

    public static ArrayList<Prodotto> ricercaPerProduttore() {
        Scanner inputMenu = new Scanner(System.in);
        System.out.println("inserisci produttore");
        String scelta = inputMenu.nextLine();
        try {
            return DbUtils.cerca_per_produttore(scelta);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Errore: Ricerca fallita");
        }
    }


    public static ArrayList<Prodotto> ricercaPerModello() {
        Scanner inputMenu = new Scanner(System.in);
        System.out.println("inserisci modello");
        String scelta = inputMenu.nextLine();
        try {
            return DbUtils.cerca_per_modello(scelta);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Errore: Ricerca fallita");
        }
    }

    public static ArrayList<Prodotto> ricercaPerDescrizione() {
        Scanner inputMenu = new Scanner(System.in);
        System.out.println("inserisci descrizione");
        String scelta = inputMenu.nextLine();
        try {
            return DbUtils.cerca_per_descrizione(scelta);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Errore: Ricerca fallita");
        }
    }

    public static ArrayList<Prodotto> ricercaPerDimensione() {
        Scanner inputMenu = new Scanner(System.in);
        System.out.println("inserisci dimensione");
        String scelta = inputMenu.nextLine();
        try {
            return DbUtils.cerca_per_dimensione(Double.parseDouble(scelta));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Errore: Ricerca fallita");
        }
    }

    public static ArrayList<Prodotto> ricercaPerMemoria() {
        Scanner inputMenu = new Scanner(System.in);
        System.out.println("inserisci memoria");
        String scelta = inputMenu.nextLine();
        try {
            return DbUtils.cerca_per_memoria(scelta);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Errore: Ricerca fallita");
        }
    }

    public static ArrayList<Prodotto> ricercaPerPrezzoAcquisto() {
        Scanner inputMenu = new Scanner(System.in);
        System.out.println("inserisci prezzo di acquisto");
        String scelta = inputMenu.nextLine();
        try {
            return DbUtils.cerca_per_prezzo_acquisto(BigDecimal.valueOf(Double.parseDouble(scelta)));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Errore: Ricerca fallita");
        }
    }

    public static ArrayList<Prodotto> ricercaPerPrezzoVendita() {
        Scanner inputMenu = new Scanner(System.in);
        System.out.println("inserisci prezzo di vendita");
        String scelta = inputMenu.nextLine();
        try {
            return DbUtils.cerca_per_prezzo_vendita(BigDecimal.valueOf(Double.parseDouble(scelta)));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Errore: Ricerca fallita");
        }
    }

    public static ArrayList<Prodotto> ricercaPerRange() {
        Scanner inputMenu = new Scanner(System.in);
        System.out.println("inserisci prezzo minimo:");
        BigDecimal min = inputMenu.nextBigDecimal();
        System.out.println("inserisci prezzo massimo:");
        BigDecimal max = inputMenu.nextBigDecimal();
        try {
            return DbUtils.cerca_per_range(min, max);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Errore: Ricerca fallita");
        }
    }

    public static Prodotto ricercaPerId() {
        Scanner inputMenu = new Scanner(System.in);
        System.out.println("inserisci l'ID del prodotto");
        String scelta = inputMenu.nextLine();
        try {
            return DbUtils.mappa_prodotto(Integer.parseInt(scelta));
        } catch (RuntimeException e) {
            System.out.println("Tipo di eccezione: " + e.getClass().getName());
            System.out.println("Messaggio: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Errore: Ricerca fallita", e);
        }
    }


}
//Aggiungere funzionalità di ricerca dei prodotti nella classe MAGAZZINO
//(il RETURN deve essere una lista di dispositivi o un messaggio di errore per tutte le ricerche)
