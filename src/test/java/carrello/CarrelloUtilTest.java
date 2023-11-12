package carrello;

import magazzino.Magazzino;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CarrelloUtilTest {
    Prodotto prodotto_null = null;
    Carrello carrello_null = null;
    Magazzino magazzino_null = null;
    Prodotto prodotto_non_presente = null;
    Prodotto prodotto_presente = new Prodotto();
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