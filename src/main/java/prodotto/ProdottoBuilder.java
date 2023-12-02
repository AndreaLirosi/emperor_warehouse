package prodotto;

import user.Utente;
import user.UtenteBuilder;

import java.math.BigDecimal;


public class ProdottoBuilder {

    private String produttore;
    private String modello;
    private String descrizione;
    private int dimensione;
    private String memoria;
    private BigDecimal prezzoAcquisto;
    private BigDecimal prezzoVendita;
    private String id;
    private Tipo tipo;

    public ProdottoBuilder () {
        
    }

    public Tipo getTipo() {
        return tipo;
    }

    public ProdottoBuilder setTipo(Tipo tipo) {
        this.tipo = tipo;
        return this;
    }

    public String getProduttore() {
        return produttore;
    }

    public ProdottoBuilder setProduttore(String produttore) {
        this.produttore = produttore;
        return this;
    }

    public String getModello() {
        return modello;
    }

    public ProdottoBuilder setModello(String modello) {
        this.modello = modello;
        return this;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public ProdottoBuilder setDescrizione(String descrizione) {
        this.descrizione = descrizione;
        return this;
    }

    public int getDimensione() {
        return dimensione;
    }

    public ProdottoBuilder setDimensione(int dimensione) {
        this.dimensione = dimensione;
        return this;
    }

    public String getMemoria() {
        return memoria;
    }

    public ProdottoBuilder setMemoria(String memoria) {
        this.memoria = memoria;
        return this;
    }

    public BigDecimal getPrezzoAcquisto() {
        return prezzoAcquisto;
    }

    public ProdottoBuilder setPrezzoAcquisto(BigDecimal prezzoAcquisto) {
        this.prezzoAcquisto = prezzoAcquisto;
        return this;
    }

    public BigDecimal getPrezzoVendita() {
        return prezzoVendita;
    }

    public ProdottoBuilder setPrezzoVendita(BigDecimal prezzoVendita) {
        this.prezzoVendita = prezzoVendita;
        return this;
    }

    public String getId() {
        return id;
    }

    public ProdottoBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public Prodotto build () {
        return new Prodotto(produttore,modello,descrizione,dimensione,memoria,prezzoAcquisto,prezzoVendita,id,tipo);
    }
}
