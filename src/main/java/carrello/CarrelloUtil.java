package carrello;

import java.util.ArrayList;

public class CarrelloUtil {
    public boolean addProdottoACarrello(Carrello carrello, Prodotto prodotto){
        if (prodotto==null){
            throw new RuntimeException("Il prodotto è null");
        }
        if (carrello==null){
            throw new RuntimeException("Il carrello è null");
        }
        carrello.getProdottiNelCarrello().add(prodotto);
        return true;
    }
    public boolean removeProdottoNelCarrello(Carrello carrello, Prodotto prodotto){
        if (prodotto==null){
            throw new RuntimeException("Il prodotto è null");
        }
        if (carrello==null){
            throw new RuntimeException("Il carrello è null");
        }
        if (carrello.getProdottiNelCarrello().contains(prodotto)) {
            carrello.getProdottiNelCarrello().remove(prodotto);
            return true;
        }
        throw new RuntimeException("Non è presente questo prodotto nel carrello:"
                +prodotto);
    }
    public ArrayList<Prodotto> mostraSpesaNelCarrello (Carrello carrello, Prodotto prodotto){
        return carrello.getProdottiNelCarrello();
    }
    public boolean fineSpesaRimozioneArticoli(Carrello carrello, Magazzino magazzino){
        if (magazzino==null){
            throw new RuntimeException("Il prodotto è null");
        }
        if (carrello==null){
            throw new RuntimeException("Il carrello è null");
        }
        magazzino.getMagazzino().removeAll(carrello.getProdottiNelCarrello());
        return true;
    }
}
