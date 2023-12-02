package Database;
import prodotto.Prodotto;
import prodotto.ProdottoBuilder;
import prodotto.Tipo;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbUtils {
    private static String selectQuery = "SELECT * FROM dbmagazzino";

    public static ArrayList<Prodotto> mapMagazzino() {
        ArrayList<Prodotto> magazzino = new ArrayList<>();
        try {
            ResultSet resultSet = DbManager.drawQuery().executeQuery(selectQuery);
            ProdottoBuilder builder = new ProdottoBuilder();

            while (resultSet.next()) {
                builder.setId(resultSet.getString("id"))
                        .setProduttore(resultSet.getString("Produttore"))
                        .setModello(resultSet.getString("Modello"))
                        .setDimensione(resultSet.getInt("Dimensione"))
                        .setDescrizione(resultSet.getString("Descrizione"))
                        .setMemoria(resultSet.getString("Memoria"))
                        .setPrezzoAcquisto(resultSet.getBigDecimal("Prezzo_acquisto"))
                        .setPrezzoVendita(resultSet.getBigDecimal("Prezzo_vendita"))
                        .setTipo(Tipo.stringTipo(resultSet.getString("Tipo")));
                magazzino.add(builder.build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return magazzino;
    }

    public static Prodotto addProduct(String produttore, String modello, String descrizione, int dimensione, String memoria, BigDecimal prezzoAcquisto, BigDecimal prezzoVendita, Tipo tipo) throws SQLException {
        Prodotto prodotto = null;
        String insertProduct = "INSERT INTO teamprogetto.dbmagazzino " +
                "(Produttore, Modello, Descrizione, Dimensione, Memoria, Prezzo_acquisto, Prezzo_vendita, Tipo) " +
                "VALUES " +
                "(" + produttore + "," + modello + "," + descrizione + "," + dimensione + "," + memoria + "," + prezzoAcquisto + "," + prezzoVendita + "," + tipo + ");";
        try {
            ResultSet resultSet = DbManager.drawQuery().executeQuery(insertProduct);
            ProdottoBuilder builder = new ProdottoBuilder();
            builder.setId(resultSet.getString("id"))
                    .setProduttore(resultSet.getString("Produttore"))
                    .setModello(resultSet.getString("Modello"))
                    .setDimensione(resultSet.getInt("Dimensione"))
                    .setDescrizione(resultSet.getString("Descrizione"))
                    .setMemoria(resultSet.getString("Memoria"))
                    .setPrezzoAcquisto(resultSet.getBigDecimal("Prezzo_acquisto"))
                    .setPrezzoVendita(resultSet.getBigDecimal("Prezzo_vendita"))
                    .setTipo(Tipo.stringTipo(resultSet.getString("Tipo")));
            prodotto = builder.build();
        } catch (SQLException e) {
            e.getMessage();
        }

        return prodotto;
    }
}

