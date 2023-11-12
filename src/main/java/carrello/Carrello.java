package carrello;

import prodotto.Prodotto;

import java.util.ArrayList;

public class Carrello {
    private ArrayList<Prodotto> prodottiNelCarrello;

    public Carrello(ArrayList<Prodotto> prodottiNelCarrello) {
        this.prodottiNelCarrello = prodottiNelCarrello;
    }

    public Carrello() {
        this.prodottiNelCarrello = new ArrayList<Prodotto>();
    }

    public ArrayList<Prodotto> getProdottiNelCarrello() {
        return this.prodottiNelCarrello;
    }

    public void setProdottiNelCarrello(ArrayList<Prodotto> prodottiNelCarrello) {
        this.prodottiNelCarrello = prodottiNelCarrello;
    }
}