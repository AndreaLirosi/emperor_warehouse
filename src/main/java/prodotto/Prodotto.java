package prodotto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Prodotto {

    private String produttore;
    private String modello;
    private String descrizione;
    private double dimensione;
    private String memoria;
    private BigDecimal prezzoAcquisto;
    private BigDecimal prezzoVendita;
    private int id;
    private Tipo tipo;

    public Prodotto(String produttore, String modello, String descrizione, double dimensione, String memoria, BigDecimal prezzoAcquisto, BigDecimal prezzoVendita, int id, Tipo tipo) {
        this.produttore = produttore;
        this.modello = modello;
        this.descrizione = descrizione;
        this.dimensione = dimensione;
        this.memoria = memoria;
        this.prezzoAcquisto = prezzoAcquisto.setScale(2,RoundingMode.HALF_DOWN);
        this.prezzoVendita = prezzoVendita.setScale(2,RoundingMode.HALF_DOWN);
        this.id = id;
        this.tipo = tipo;

    }


    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
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

    public double getDimensione() {
        return dimensione;
    }

    public void setDimensione(double dimensione) {
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
        this.prezzoAcquisto = prezzoAcquisto.setScale(2,RoundingMode.HALF_DOWN);
    }

    public BigDecimal getPrezzoVendita() {
        return prezzoVendita;
    }

    public void setPrezzoVendita(BigDecimal prezzoVendita) {
        this.prezzoVendita = prezzoVendita.setScale(2,RoundingMode.HALF_DOWN);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public boolean equals(Prodotto prodotto) {
        return this.id == prodotto.getId();
    }


    @Override
    public String toString() {
        return "Prodotto{" +
                "produttore='" + produttore + '\'' +
                ", modello='" + modello + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", dimensione=" + dimensione +
                ", memoria='" + memoria + '\'' +
                ", prezzoAcquisto=" + prezzoAcquisto +
                ", prezzoVendita=" + prezzoVendita +
                ", id='" + id + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}

