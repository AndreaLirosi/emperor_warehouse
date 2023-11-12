package prodotto;

import java.math.BigDecimal;

public class Tablet extends Prodotto{

    private final Tipo tipo = Tipo.TABLET;

    public Tipo getTipo() {
        return tipo;
    }

    public Tablet(String produttore, String modello, String descrizione, int dimensione, String memoria, BigDecimal prezzoAcquisto, BigDecimal prezzoVendita, String id) {
        super(produttore, modello, descrizione, dimensione, memoria, prezzoAcquisto, prezzoVendita, id);
    }

    @Override
    public String toString() {
        return this.tipo+ super.toString() ;
    }
}
