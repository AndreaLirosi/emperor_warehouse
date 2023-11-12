package prodotto;

import java.math.BigDecimal;

public class Prodotto {

        private String produttore;
        private String modello;
        private String descrizione;
        private int dimensione;
        private String memoria;
        private BigDecimal prezzoAcquisto;
        private BigDecimal prezzoVendita;
        private String id;

        public Prodotto(String produttore, String modello, String descrizione, int dimensione, String memoria, BigDecimal prezzoAcquisto, BigDecimal prezzoVendita, String id) {
            this.produttore = produttore;
            this.modello = modello;
            this.descrizione = descrizione;
            this.dimensione = dimensione;
            this.memoria = memoria;
            this.prezzoAcquisto = prezzoAcquisto;
            this.prezzoVendita = prezzoVendita;
            this.id = id;

        }

        public String getProduttore() {
            return produttore;
        }

        public void setProduttore(String produttore) {
            this.produttore = produttore;
        }

        public String getModello() {
            return modello;
        }

        public void setModello(String modello) {
            this.modello = modello;
        }

        public String getDescrizione() {
            return descrizione;
        }

        public void setDescrizione(String descrizione) {
            this.descrizione = descrizione;
        }

        public int getDimensione() {
            return dimensione;
        }

        public void setDimensione(int dimensione) {
            this.dimensione = dimensione;
        }

        public String getMemoria() {
            return memoria;
        }

        public void setMemoria(String memoria) {
            this.memoria = memoria;
        }

        public BigDecimal getPrezzoAcquisto() {
            return prezzoAcquisto;
        }

        public void setPrezzoAcquisto(BigDecimal prezzoAcquisto) {
            this.prezzoAcquisto = prezzoAcquisto;
        }

        public BigDecimal getPrezzoVendita() {
            return prezzoVendita;
        }

        public void setPrezzoVendita(BigDecimal prezzoVendita) {
            this.prezzoVendita = prezzoVendita;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }


        public boolean equals(Prodotto prodotto) {
            return this.id == prodotto.getId();
        }


        @Override
        public String toString() {
            return " [" +
                    "produttore= " + produttore +
                    ", modello= " + modello +
                    ", descrizione= " + descrizione +
                    ", dimensione= " + dimensione +
                    ", memoria= " + memoria +
                    ", prezzoAcquisto= " + prezzoAcquisto +
                    ", prezzoVendita= " + prezzoVendita +
                    ", id= " + id +
                    ']';
        }
    }

