package magazzino;

import prodotto.Prodotto;

import java.math.BigDecimal;
import java.util.ArrayList;

public class MagazzinoUtil {

    public static boolean aggiungereProdotto(Magazzino magazzino, Prodotto prodotto) {
        magazzino.getMagazzino().add(prodotto);
        return true;
    }

    public static boolean rimuoviProdotti(Magazzino magazzino, ArrayList<Prodotto> prodottiDaRimuovere) {
        magazzino.getMagazzino().removeAll(prodottiDaRimuovere);
        return true;
    }

    public static void stampaProdotti(Magazzino magazzino) {
        ArrayList<Prodotto> listaProdotti = magazzino.getMagazzino();

        for (Prodotto prodotto : listaProdotti) {
            System.out.println(prodotto.toString());
        }
    }

    public static ArrayList<Prodotto.Prodotto> cercaProdotti(Magazzino magazzino, ParametroRicerca parametro, String ricerca) {
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

    public static ArrayList<Prodotto> cercaProdottiRangePrezzo(Magazzino magazzino, double min, double max) {
        ArrayList<Prodotto> result = new ArrayList<Prodotto>();
        for (Prodotto luca : magazzino.getMagazzino()) {
            if (luca.getPrezzoVendita().doubleValue() <= max && luca.getPrezzoVendita().doubleValue() >= min) {
                result.add(luca);
            }
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
            if (luca.getId().equalsIgnoreCase(ricerca)) {
                result.add(luca);
            }
        }
        return result;
    }
}
//Aggiungere funzionalità di ricerca dei prodotti nella classe MAGAZZINO
//(il RETURN deve essere una lista di dispositivi o un messaggio di errore per tutte le ricerche)
