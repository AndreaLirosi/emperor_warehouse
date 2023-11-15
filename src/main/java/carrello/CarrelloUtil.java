package carrello;

import magazzino.Magazzino;
import magazzino.MagazzinoUtil;
import prodotto.Prodotto;

import java.math.BigDecimal;
import java.util.ArrayList;


public class CarrelloUtil {
    public static boolean addProdottoACarrello(Carrello carrello, Prodotto prodotto, Magazzino magazzino) {
        if (prodotto == null && carrello == null && magazzino == null){
            throw new NullPointerException("è TUTTO ROTTO!!");
        }
        if (prodotto == null && carrello == null || magazzino == null && carrello == null || prodotto == null && magazzino == null ){
            throw new NullPointerException("2 degli oggetti passati sono null");
        }
        if (prodotto == null) {
            throw new NullPointerException("Il prodotto è null");
        }
        if (carrello == null) {
            throw new NullPointerException("Il carrello è null");
        }
        if (magazzino == null) {
            throw new NullPointerException("Il magazzino è null");
        }
        carrello.getProdottiNelCarrello().add(prodotto);
        MagazzinoUtil.aggiungereProdotto(magazzino,prodotto);
        return true;
    }

    public static boolean rimuovieProdottoNelCarrello(Carrello carrello, Prodotto prodotto,Magazzino magazzino) {
        if (prodotto == null && carrello == null && magazzino == null){
            throw new NullPointerException("è TUTTO ROTTO!!");
        }
        if (prodotto == null && carrello == null || magazzino == null && carrello == null || prodotto == null && magazzino == null ){
            throw new NullPointerException("2 degli oggetti passati sono null");
        }
        if (prodotto == null) {
            throw new NullPointerException("Il prodotto è null");
        }
        if (carrello == null) {
            throw new NullPointerException("Il carrello è null");
        }
        if (magazzino == null) {
            throw new NullPointerException("Il magazzino è null");
        }
        if (carrello.getProdottiNelCarrello().contains(prodotto)) {
            MagazzinoUtil.aggiungereProdotto(magazzino,prodotto);
            carrello.getProdottiNelCarrello().remove(prodotto);
            return true;
        }
        throw new RuntimeException("Non è presente questo prodotto nel carrello:"
                + prodotto);
    }

    public static ArrayList<Prodotto> mostraSpesaNelCarrello(Carrello carrello) {
        if (carrello==null){
            throw new NullPointerException("Il carrello è null");
        }
        return carrello.getProdottiNelCarrello();
    }

    public static ArrayList<Prodotto> fineSpesaRimozioneArticoli(Carrello carrello, Magazzino magazzino) {
        if (magazzino == null && carrello ==null) {
            throw new NullPointerException("Il magazzino e carrello sono null");
        }
        if (magazzino == null) {
            throw new NullPointerException("Il magazzino è null");
        }
        if (carrello == null) {
            throw new NullPointerException("Il carrello è null");
        }
        MagazzinoUtil.rimuoviProdotti(magazzino,carrello.getProdottiNelCarrello());
        return carrello.getProdottiNelCarrello();
    }
    public static BigDecimal totaleSpesaCarrello(Carrello carrello){
        if (carrello==null){
            throw new NullPointerException("Il carrello è null");
        }
        BigDecimal totSpesa = BigDecimal.ZERO;
        for (Prodotto prodotto : carrello.getProdottiNelCarrello()) {
            totSpesa = totSpesa.add(prodotto.getPrezzoVendita());
        }
        return totSpesa;
    }
}
