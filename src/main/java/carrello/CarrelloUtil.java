package carrello;

import magazzino.Magazzino;
import magazzino.MagazzinoUtil;


public class CarrelloUtil {
    public static boolean addProdottoACarrello(Carrello carrello, Prodotto prodotto, Magazzino magazzino) {
        if (prodotto == null) {
            throw new RuntimeException("Il prodotto è null");
        }
        if (carrello == null) {
            throw new RuntimeException("Il carrello è null");
        }
        if (magazzino == null) {
            throw new RuntimeException("Il magazzino è null");
        }
        carrello.getProdottiNelCarrello().add(prodotto);
        MagazzinoUtil.aggiungereProdotto(magazzino,prodotto);
        return true;
    }

    public static boolean rimuovieProdottoNelCarrello(Carrello carrello, Prodotto prodotto,Magazzino magazzino) {
        if (prodotto == null) {
            throw new RuntimeException("Il prodotto è null");
        }
        if (carrello == null) {
            throw new RuntimeException("Il carrello è null");
        }
        if (carrello.getProdottiNelCarrello().contains(prodotto)) {
            MagazzinoUtil.aggiungereProdotto(magazzino,prodotto);
            carrello.getProdottiNelCarrello().remove(prodotto);
            return true;
        }
        throw new RuntimeException("Non è presente questo prodotto nel carrello:"
                + prodotto);
    }

    public static ArrayList<Prodotto> mostraSpesaNelCarrello(Carrello carrello, Prodotto prodotto) {
        return carrello.getProdottiNelCarrello();
    }

    public static boolean fineSpesaRimozioneArticoli(Carrello carrello, Magazzino magazzino) {
        if (magazzino == null) {
            throw new RuntimeException("Il prodotto è null");
        }
        if (carrello == null) {
            throw new RuntimeException("Il carrello è null");
        }
        MagazzinoUtil.rimuoviProdotti(magazzino,carrello.getProdottiNelCarrello());
        return true;
    }
}
