package magazzino;

import prodotto.Prodotto;

import java.util.ArrayList;

public class Magazzino {
    private ArrayList<Prodotto> magazzino;

    public Magazzino(ArrayList<Prodotto> magazzino) {
        this.magazzino = magazzino;
    }
    public Magazzino() {
        this.magazzino = new ArrayList<>();
    }

    public ArrayList<Prodotto> getMagazzino() {
        return magazzino;
    }

    public void setMagazzino(ArrayList<Prodotto> magazzino) {
        this.magazzino = magazzino;
    }
}
