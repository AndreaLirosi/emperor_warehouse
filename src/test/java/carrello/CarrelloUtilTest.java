package carrello;

import magazzino.Magazzino;
import org.junit.jupiter.api.Test;
import prodotto.Prodotto;
import prodotto.Smartphone;


import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CarrelloUtilTest {
    Prodotto prodotto_null = null;
    Carrello carrello_null = null;
    Magazzino magazzino_null = null;
    Smartphone prodotto_presente = new Smartphone("Samsung","S3","ma che ne so",2,"poca", BigDecimal.valueOf(213.55),BigDecimal.valueOf(549.99),"SMRTP-01");
    Smartphone prodotto_non_presente = new Smartphone("Huawei","M8","ma che ne so",1,"un po' di più", BigDecimal.valueOf(213.55),BigDecimal.valueOf(549.99),"SMRTP-02");
    Carrello carrello = new Carrello();
    Magazzino magazzino = new Magazzino(new ArrayList<Prodotto>());

    @Test
    void addProdottoACarrello() {

    }

    @Test
    void rimuovieProdottoNelCarrello() {
    }

    @Test
    void mostraSpesaNelCarrello() {
    }

    @Test
    void fineSpesaRimozioneArticoli() {
    }
}