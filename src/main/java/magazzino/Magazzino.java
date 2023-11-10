package classiDiGestione;

import java.util.ArrayList;

public class Magazzino {
        private ArrayList<Prodotto> magazzino;

        public Magazzino(ArrayList<Prodotto> magazzino) {
            this.magazzino = magazzino;
        }

        public ArrayList<Prodotto> getMagazzino() {
            return magazzino;
        }

        public void setMagazzino(ArrayList<Prodotto> magazzino) {
            this.magazzino = magazzino;
        }
}
