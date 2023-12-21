package carrello;

import magazzino.Magazzino;
import magazzino.MagazzinoUtil;
import prodotto.Prodotto;
import user.Privato;

import java.math.BigDecimal;
import java.util.ArrayList;


public class CarrelloUtil {
    public static boolean addProdottoACarrello(Carrello carrello, Prodotto prodotto) {

        if (prodotto == null && carrello == null ) {
            throw new NullPointerException("2 degli oggetti passati sono null");
        }
        if (prodotto == null) {
            throw new NullPointerException("Il prodotto è null");
        }
        if (carrello == null) {
            throw new NullPointerException("Il carrello è null");
        }
        carrello.getProdottiNelCarrello().add(prodotto);
        return true;
    }

    public static boolean rimuovieProdottoNelCarrello(Carrello carrello, Prodotto prodotto) {

        if (prodotto == null && carrello == null ) {
            throw new NullPointerException("2 degli oggetti passati sono null");
        }
        if (prodotto == null) {
            throw new NullPointerException("Il prodotto è null");
        }
        if (carrello == null) {
            throw new NullPointerException("Il carrello è null");
        }
        if (carrello.getProdottiNelCarrello().contains(prodotto)) {
            carrello.getProdottiNelCarrello().remove(prodotto);
            return true;
        }
        throw new RuntimeException("Non è presente questo prodotto nel carrello:"
                + prodotto);
    }
    public static boolean rimuovieProdottoNelCarrello(Carrello carrello, int id) {

        if (carrello == null) {
            throw new NullPointerException("Il carrello è null");
        }
        for (Prodotto p : carrello.getProdottiNelCarrello()){
            if (p.getId()==id){
                carrello.getProdottiNelCarrello().remove(p);
                return true;
            }
        }
        throw new RuntimeException("Non è presente questo prodotto nel carrello");
        }



    public static ArrayList<Prodotto> mostraSpesaNelCarrello(Carrello carrello) {
        if (carrello == null) {
            throw new NullPointerException("Il carrello è null");
        }
        return carrello.getProdottiNelCarrello();
    }

    public static ArrayList<Prodotto> fineSpesaRimozioneArticoli(Privato utente) {
        if (utente.getSpesa() == null) {
            throw new NullPointerException("Il carrello è null");
        }
        MagazzinoUtil.rimuoviProdotti(utente);
        return utente.getProdottiNelCarrello();
    }

    public static BigDecimal totaleSpesaCarrello(Carrello carrello) {
        if (carrello == null) {
            throw new NullPointerException("Il carrello è null");
        }
        BigDecimal totSpesa = BigDecimal.ZERO;
        for (Prodotto prodotto : carrello.getProdottiNelCarrello()) {
            totSpesa = totSpesa.add(prodotto.getPrezzoVendita());
        }
        return totSpesa;
    }
}
