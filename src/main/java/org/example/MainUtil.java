package org.example;

import carrello.Carrello;
import carrello.CarrelloUtil;
import magazzino.Magazzino;
import magazzino.MagazzinoUtil;
import prodotto.Notebook;
import prodotto.Smartphone;
import prodotto.Tablet;

import java.math.BigDecimal;
import java.util.Scanner;

public class MainUtil {
    public static boolean addProdotto_Magazzino(Magazzino magazzino, Scanner scanner){
        System.out.println("aggiungi:\n1-> Tablet\n2-> Notebook\n3-> Smartphone");
        int scleta= scanner.nextInt();
        switch (scleta){
            case 1:
                MagazzinoUtil.aggiungereProdotto(magazzino,new Tablet("Apple","PinkLady","la mela del supermercato",1,"piu del normale", BigDecimal.valueOf(20),BigDecimal.valueOf(20000),"Giacomo"));
                return true;
            case 2:
                MagazzinoUtil.aggiungereProdotto(magazzino,new Notebook("Ma chi li compra?","Ma pigliati un fisso","che poi ti ritrovi copme paola",0,"non ne ha", BigDecimal.valueOf(20),BigDecimal.valueOf(20000),"Paola2"));
                return true;
            case 3:
                MagazzinoUtil.aggiungereProdotto(magazzino,new Smartphone("Apple","Smith","la mela del supermercato",1,"piu del normale", BigDecimal.valueOf(20),BigDecimal.valueOf(20000),"Giacomo"));
                return true;
            default:
                MagazzinoUtil.aggiungereProdotto(magazzino,new Tablet("Apple","PinkLady","la mela del supermercato",1,"piu del normale", BigDecimal.valueOf(20),BigDecimal.valueOf(20000),"Giacomo"));
                return false;
        }
    }
    public static boolean addProdotto_Carrello(Carrello carrello, Magazzino magazzino, Scanner scanner){
        System.out.println("aggiungi:\n1-> Tablet\n2-> Notebook\n3-> Smartphone");
        int scleta= scanner.nextInt();
        switch (scleta){
            case 1:
                CarrelloUtil.addProdottoACarrello(carrello,new Tablet("Apple","PinkLady","la mela del supermercato",1,"piu del normale", BigDecimal.valueOf(20),BigDecimal.valueOf(20000),"Giacomo"),magazzino);
                return true;
            case 2:
                CarrelloUtil.addProdottoACarrello(carrello,new Notebook("Ma chi li compra?","Ma pigliati un fisso","che poi ti ritrovi copme paola",0,"non ne ha", BigDecimal.valueOf(20),BigDecimal.valueOf(20000),"Paola2"),magazzino);
                return true;
            case 3:
                CarrelloUtil.addProdottoACarrello(carrello,new Smartphone("Apple","Smith","la mela del supermercato",1,"piu del normale", BigDecimal.valueOf(20),BigDecimal.valueOf(20000),"Giacomo"),magazzino);
                return true;
            default:
                CarrelloUtil.addProdottoACarrello(carrello,new Tablet("Apple","PinkLady","la mela del supermercato",1,"piu del normale", BigDecimal.valueOf(20),BigDecimal.valueOf(20000),"Giacomo"),magazzino);
                return false;
        }
    }
}
