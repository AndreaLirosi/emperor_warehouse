package prodotto;

import java.math.BigDecimal;

public class Notebook extends Prodotto {
    private final Tipo tipo = Tipo.NOTEBOOK;

    public Tipo getTipo() {
        return tipo;
    }

    public Notebook(String produttore, String modello, String descrizione, int dimensione, String memoria, BigDecimal prezzoAcquisto, BigDecimal prezzoVendita, String id) {
        super(produttore, modello, descrizione, dimensione, memoria, prezzoAcquisto, prezzoVendita, id);
    }
    @Override
    public String toString() {
        return tipo +super.toString();
    }
}
