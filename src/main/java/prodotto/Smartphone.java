package prodotto;

import java.math.BigDecimal;

public class Smartphone extends Prodotto {
    private final Tipo tipo = Tipo.SMARTPHONE;

    public Tipo getTipo() {
        return tipo;
    }

    public Smartphone(String produttore, String modello, String descrizione, int dimensione, String memoria, BigDecimal prezzoAcquisto, BigDecimal prezzoVendita, String id) {
        super(produttore, modello, descrizione, dimensione, memoria, prezzoAcquisto, prezzoVendita, id);
    }

    @Override
    public String toString() {
        return tipo +super.toString();
    }
}
