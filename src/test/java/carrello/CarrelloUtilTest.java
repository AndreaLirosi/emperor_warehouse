package carrello;

import magazzino.Magazzino;
import org.junit.jupiter.api.Test;
import prodotto.Prodotto;


import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CarrelloUtilTest {

    //@BeforeEach
    Prodotto prodotto_null = null;
    Carrello carrello_null = null;
    Magazzino magazzino_null = null;
    Smartphone prodotto_presente = new Smartphone("Samsung", "S3", "ma che ne so", 2, "poca", BigDecimal.valueOf(213.55), BigDecimal.valueOf(549.99), "SMRTP-01");
    Smartphone prodotto_non_presente = new Smartphone("Huawei", "M8", "ma che ne so", 1, "un po' di più", BigDecimal.valueOf(213.55), BigDecimal.valueOf(0.99), "SMRTP-02");
    Carrello carrello = new Carrello();
    Magazzino magazzino = new Magazzino(new ArrayList<Prodotto>());

    @Test
    void addProdottoACarrello() {

        assertEquals(true, CarrelloUtil.addProdottoACarrello(carrello, prodotto_presente, magazzino), "impossibile");
    }

    @Test
    void addProdottoACarrello_nonPresente() {

        assertEquals(true, CarrelloUtil.addProdottoACarrello(carrello, prodotto_non_presente, magazzino), "impossibile");
    }

    @Test
    void addProdottoACarrello_prodottoNull() {

        Exception e = assertThrows(NullPointerException.class, () -> CarrelloUtil.addProdottoACarrello(carrello, prodotto_null, magazzino));
        assertEquals("Il prodotto è null", e.getMessage());
        assertEquals(NullPointerException.class, e.getClass());
    }

    @Test
    void addProdottoACarrello_magazzinoNull() {

        Exception e = assertThrows(NullPointerException.class, () -> CarrelloUtil.addProdottoACarrello(carrello, prodotto_presente, magazzino_null));
        assertEquals("Il magazzino è null", e.getMessage());
        assertEquals(NullPointerException.class, e.getClass());
    }

    @Test
    void addProdottoACarrello_carrelloNull() {

        Exception e = assertThrows(NullPointerException.class, () -> CarrelloUtil.addProdottoACarrello(carrello_null, prodotto_presente, magazzino));
        assertEquals("Il carrello è null", e.getMessage());
        assertEquals(NullPointerException.class, e.getClass());
    }

    @Test
    void addProdottoACarrello_tuttoNull() {

        Exception e = assertThrows(NullPointerException.class, () -> CarrelloUtil.addProdottoACarrello(carrello_null, prodotto_null, magazzino_null));
        assertEquals("è TUTTO ROTTO!!", e.getMessage());
        assertEquals(NullPointerException.class, e.getClass());
    }

    @Test
    void addProdottoACarrello_quasiTuttoNull_noCarrello() {

        Exception e = assertThrows(NullPointerException.class, () -> CarrelloUtil.addProdottoACarrello(carrello, prodotto_null, magazzino_null));
        assertEquals("2 degli oggetti passati sono null", e.getMessage());
        assertEquals(NullPointerException.class, e.getClass());
    }

    @Test
    void addProdottoACarrello_quasiTuttoNull_noMagazzino() {

        Exception e = assertThrows(NullPointerException.class, () -> CarrelloUtil.addProdottoACarrello(carrello_null, prodotto_null, magazzino));
        assertEquals("2 degli oggetti passati sono null", e.getMessage());
        assertEquals(NullPointerException.class, e.getClass());
    }

    @Test
    void addProdottoACarrello_quasiTuttoNull_noProdotto() {

        Exception e = assertThrows(NullPointerException.class, () -> CarrelloUtil.addProdottoACarrello(carrello_null, prodotto_presente, magazzino_null));
        assertEquals("2 degli oggetti passati sono null", e.getMessage());
        assertEquals(NullPointerException.class, e.getClass());
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////


    @Test
    void rimuovieProdottoNelCarrello() {
        CarrelloUtil.addProdottoACarrello(carrello, prodotto_presente, magazzino);
        assertEquals(true, CarrelloUtil.rimuovieProdottoNelCarrello(carrello, prodotto_presente, magazzino), "impossibile");
    }

    @Test
    void rimuovieProdottoNelCarrello_nonPresente() {
        CarrelloUtil.addProdottoACarrello(carrello, prodotto_presente, magazzino);

        Exception e = assertThrows(RuntimeException.class, () -> CarrelloUtil.rimuovieProdottoNelCarrello(carrello, prodotto_non_presente, magazzino));
        assertEquals("Non è presente questo prodotto nel carrello:"
                + prodotto_non_presente, e.getMessage());
        assertEquals(RuntimeException.class, e.getClass());
    }

    @Test
    void rimuovieProdottoNelCarrello_prodottoNull() {

        Exception e = assertThrows(NullPointerException.class, () -> CarrelloUtil.rimuovieProdottoNelCarrello(carrello, prodotto_null, magazzino));
        assertEquals("Il prodotto è null", e.getMessage());
        assertEquals(NullPointerException.class, e.getClass());
    }

    @Test
    void rimuovieProdottoNelCarrello_magazzinoNull() {

        Exception e = assertThrows(NullPointerException.class, () -> CarrelloUtil.rimuovieProdottoNelCarrello(carrello, prodotto_presente, magazzino_null));
        assertEquals("Il magazzino è null", e.getMessage());
        assertEquals(NullPointerException.class, e.getClass());
    }

    @Test
    void rimuovieProdottoNelCarrello_carrelloNull() {

        Exception e = assertThrows(NullPointerException.class, () -> CarrelloUtil.rimuovieProdottoNelCarrello(carrello_null, prodotto_presente, magazzino));
        assertEquals("Il carrello è null", e.getMessage());
        assertEquals(NullPointerException.class, e.getClass());
    }

    @Test
    void rimuovieProdottoNelCarrello_tuttoNull() {

        Exception e = assertThrows(NullPointerException.class, () -> CarrelloUtil.rimuovieProdottoNelCarrello(carrello_null, prodotto_null, magazzino_null));
        assertEquals("è TUTTO ROTTO!!", e.getMessage());
        assertEquals(NullPointerException.class, e.getClass());
    }

    @Test
    void rimuovieProdottoNelCarrello_quasiTuttoNull_noCarrello() {

        Exception e = assertThrows(NullPointerException.class, () -> CarrelloUtil.rimuovieProdottoNelCarrello(carrello, prodotto_null, magazzino_null));
        assertEquals("2 degli oggetti passati sono null", e.getMessage());
        assertEquals(NullPointerException.class, e.getClass());
    }

    @Test
    void rimuovieProdottoNelCarrello_quasiTuttoNull_noMagazzino() {

        Exception e = assertThrows(NullPointerException.class, () -> CarrelloUtil.rimuovieProdottoNelCarrello(carrello_null, prodotto_null, magazzino));
        assertEquals("2 degli oggetti passati sono null", e.getMessage());
        assertEquals(NullPointerException.class, e.getClass());
    }

    @Test
    void rimuovieProdottoNelCarrello_quasiTuttoNull_noProdotto() {

        Exception e = assertThrows(NullPointerException.class, () -> CarrelloUtil.rimuovieProdottoNelCarrello(carrello_null, prodotto_presente, magazzino_null));
        assertEquals("2 degli oggetti passati sono null", e.getMessage());
        assertEquals(NullPointerException.class, e.getClass());
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    void mostraSpesaNelCarrello() {
        //non penso abbia senso provarlo così
        CarrelloUtil.addProdottoACarrello(carrello, prodotto_presente, magazzino);
        assertEquals(carrello.getProdottiNelCarrello(), CarrelloUtil.mostraSpesaNelCarrello(carrello), "Non penso possa venire sbagliato");
    }

    @Test
    void mostraSpesaNelCarrello_null() {
        //non penso abbia senso provarlo così
        Exception e = assertThrows(NullPointerException.class, () -> CarrelloUtil.mostraSpesaNelCarrello(carrello_null));
        assertEquals("Il carrello è null", e.getMessage());
        assertEquals(NullPointerException.class, e.getClass());
    }

    @Test
    void fineSpesaRimozioneArticoli() {
        assertEquals(carrello.getProdottiNelCarrello(), CarrelloUtil.fineSpesaRimozioneArticoli(carrello, magazzino));
    }

    @Test
    void fineSpesaRimozioneArticoli_magazzinoNull() {
        Exception e = assertThrows(NullPointerException.class, () -> CarrelloUtil.fineSpesaRimozioneArticoli(carrello,magazzino_null));
        assertEquals("Il magazzino è null", e.getMessage());
        assertEquals(NullPointerException.class, e.getClass());
    }

    @Test
    void fineSpesaRimozioneArticoli_carrelloNull() {
        Exception e = assertThrows(NullPointerException.class, () -> CarrelloUtil.fineSpesaRimozioneArticoli(carrello_null,magazzino));
        assertEquals("Il carrello è null", e.getMessage());
        assertEquals(NullPointerException.class, e.getClass());
    }
    @Test
    void fineSpesaRimozioneArticoli_carrello_eMagazzino_Null() {
        Exception e = assertThrows(NullPointerException.class, () -> CarrelloUtil.fineSpesaRimozioneArticoli(carrello_null,magazzino_null));
        assertEquals("Il magazzino e carrello sono null", e.getMessage());
        assertEquals(NullPointerException.class, e.getClass());
    }
    @Test
    void totaleSpesaCarrello(){
        carrello.getProdottiNelCarrello().add(prodotto_presente);
        carrello.getProdottiNelCarrello().add(prodotto_non_presente);
        assertEquals(BigDecimal.valueOf(550.98),CarrelloUtil.totaleSpesaCarrello(carrello),"Dovrebbe restituire l'ammontare del valore della spesa");
    }
    @Test
    void totaleSpesaCarrello_senza_prodotti(){
        assertEquals(BigDecimal.valueOf(0),CarrelloUtil.totaleSpesaCarrello(carrello),"Dovrebbe restituire 0");
    }

    @Test
    void totaleSpesaCarrello_carrelloNull() {
        Exception e = assertThrows(NullPointerException.class, () -> CarrelloUtil.totaleSpesaCarrello(carrello_null));
        assertEquals("Il carrello è null", e.getMessage());
        assertEquals(NullPointerException.class, e.getClass());
    }
}