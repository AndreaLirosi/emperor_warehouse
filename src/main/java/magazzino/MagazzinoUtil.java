package magazzino;

import Database.DbUtils;
import org.example.Main;
import prodotto.Prodotto;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MagazzinoUtil {

    public static boolean aggiungereProdotto(Magazzino magazzino, Prodotto prodotto) {

        magazzino.getMagazzino().add(prodotto);
        return true;
    }

    public static boolean rimuoviProdotti(Magazzino magazzino, ArrayList<Prodotto> prodottiDaRimuovere) {
        magazzino.getMagazzino().removeAll(prodottiDaRimuovere);
        return true;
    }

    public static void stampaProdotti() {
        ArrayList<Prodotto> listaProdotti = DbUtils.mapMagazzino();

        for (Prodotto prodotto : listaProdotti) {
            System.out.println(prodotto.toString());
        }
    }

    public static ArrayList<Prodotto> cercaProdotti(Magazzino magazzino, ParametroRicerca parametro, String ricerca) {
        return switch (parametro) {
            case PRODUTTORE -> ricercaPerProduttore(magazzino, ricerca);
            case MODELLO -> ricercaPerModello(magazzino, ricerca);
            case DESCRIZIONE -> ricercaPerDescrizione(magazzino, ricerca);
            case DIMENSIONE -> ricercaPerDimensione(magazzino, ricerca);
            case MEMORIA -> ricercaPerMemoria(magazzino, ricerca);
            case PREZZOACQUISTO -> ricercaPerPrezzoAcquisto(magazzino, ricerca);
            case PREZZOVENDITA -> ricercaPerPrezzoVendita(magazzino, ricerca);
            case ID -> ricercaPerId(magazzino, ricerca);
        };
    }
    public static ArrayList<Prodotto> cercaProdotti(ParametroRicerca parametro, String ricerca) throws SQLException {
        return switch (parametro) {
            case PRODUTTORE -> DbUtils.cerca_per_produttore(ricerca);
            case MODELLO -> DbUtils.cerca_per_modello(ricerca);
            case DESCRIZIONE -> DbUtils.cerca_per_descrizione(ricerca);
            case DIMENSIONE -> DbUtils.cerca_per_dimensione(Double.parseDouble(ricerca));
            case MEMORIA -> DbUtils.cerca_per_memoria(Double.parseDouble(ricerca));
            case PREZZOACQUISTO -> DbUtils.cerca_per_prezzo_acquisto(BigDecimal.valueOf(Double.parseDouble(ricerca)));
            case PREZZOVENDITA -> DbUtils.cerca_per_prezzo_vendita(BigDecimal.valueOf(Double.parseDouble(ricerca)));

            default -> throw new IllegalStateException("Se conosci già l'id del prodotto aggiungilo al tuo carrello!");
        };
    }

    public static ArrayList<Prodotto> cercaProdottiRangePrezzo(Magazzino magazzino) {
        ArrayList<Prodotto> result = new ArrayList<Prodotto>();
        Scanner inputScanner = new Scanner(System.in);

try {
    System.out.print("Inserisci il valore minimo del prezzo: ");
    double min = inputScanner.nextDouble();

    System.out.print("Inserisci il valore massimo del prezzo: ");
    double max = inputScanner.nextDouble();

    for (Prodotto luca : magazzino.getMagazzino()) {
        if (luca.getPrezzoVendita().doubleValue() <= max && luca.getPrezzoVendita().doubleValue() >= min) {
            result.add(luca);
        }
    }
}catch (InputMismatchException e) {
    System.out.println("inserimento non valido!. inserire valori numerici.");
}

        return result;
    }

    public static ArrayList<Prodotto> ricercaPerProduttore(Magazzino magazzino, String ricerca) {
        ArrayList<Prodotto> result = new ArrayList<Prodotto>();

        for (Prodotto luca : magazzino.getMagazzino()) {
            if (luca.getProduttore().equalsIgnoreCase(ricerca)) {
                result.add(luca);
            }
        }
        return result;
    }

    public static ArrayList<Prodotto> ricercaPerModello(Magazzino magazzino, String ricerca) {
        ArrayList<Prodotto> result = new ArrayList<Prodotto>();

        for (Prodotto luca : magazzino.getMagazzino()) {
            if (luca.getModello().equalsIgnoreCase(ricerca)) {
                result.add(luca);
            }
        }
        return result;
    }

    public static ArrayList<Prodotto> ricercaPerDescrizione(Magazzino magazzino, String ricerca) {
        ArrayList<Prodotto> result = new ArrayList<Prodotto>();

        for (Prodotto luca : magazzino.getMagazzino()) {
            if (luca.getDescrizione().equalsIgnoreCase(ricerca)) {
                result.add(luca);
            }
        }
        return result;
    }

    public static ArrayList<Prodotto> ricercaPerDimensione(Magazzino magazzino, String ricerca) {

        ArrayList<Prodotto> result = new ArrayList<Prodotto>();

        for (Prodotto luca : magazzino.getMagazzino()) {
            if (luca.getDimensione() == Integer.parseInt(ricerca)) {
                result.add(luca);
            }
        }
        return result;
    }

    public static ArrayList<Prodotto> ricercaPerMemoria(Magazzino magazzino, String ricerca) {
        ArrayList<Prodotto> result = new ArrayList<Prodotto>();

        for (Prodotto luca : magazzino.getMagazzino()) {
            if (luca.getMemoria().equalsIgnoreCase(ricerca)) {
                result.add(luca);
            }
        }
        return result;
    }

    public static ArrayList<Prodotto> ricercaPerPrezzoAcquisto(Magazzino magazzino, String ricerca) {
        ArrayList<Prodotto> result = new ArrayList<Prodotto>();

        for (Prodotto luca : magazzino.getMagazzino()) {
            if (luca.getPrezzoAcquisto().equals(BigDecimal.valueOf(Integer.parseInt(ricerca)))) {
                result.add(luca);
            }
        }
        return result;
    }

    public static ArrayList<Prodotto> ricercaPerPrezzoVendita(Magazzino magazzino, String ricerca) {
        ArrayList<Prodotto> result = new ArrayList<Prodotto>();

        for (Prodotto luca : magazzino.getMagazzino()) {
            if (luca.getPrezzoVendita().equals(BigDecimal.valueOf(Integer.parseInt(ricerca)))) {
                result.add(luca);
            }
        }
        return result;
    }

    public static ArrayList<Prodotto> ricercaPerId(Magazzino magazzino, String ricerca) {
        ArrayList<Prodotto> result = new ArrayList<Prodotto>();

        for (Prodotto luca : magazzino.getMagazzino()) {
            if (luca.getId()==Integer.parseInt(ricerca)) {
                result.add(luca);
            }
        }
        return result;
    }
}
//Aggiungere funzionalità di ricerca dei prodotti nella classe MAGAZZINO
//(il RETURN deve essere una lista di dispositivi o un messaggio di errore per tutte le ricerche)
