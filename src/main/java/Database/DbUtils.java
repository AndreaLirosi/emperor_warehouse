package Database;
import prodotto.Prodotto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbUtils {
    private static String selectQuery = "SELECT * FROM dbmagazzino";

    public static ArrayList<Prodotto> mapMagazzino() {
        ArrayList<Prodotto> magazzino = new ArrayList<>();
        try {
            ResultSet resultSet = DbManager.drawQuery().executeQuery(selectQuery);
            while (resultSet.next()) {
                magazzino.add(new Prodotto(resultSet.getString("id"), resultSet.getString("Produttore"), resultSet.getString("Modello"), resultSet.getInt("Dimensione"), resultSet.getString("Memoria"), resultSet.getBigDecimal("Prezzo_acquisto"), resultSet.getBigDecimal("Prezzo_vendita"), resultSet.getString("Tipo") + "\n"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return magazzino;
    }

    /*public static Prodotto addProduct(String produttore, String modello, String descrizione, int dimensione, String memoria, BigDecimal prezzoAcquisto, BigDecimal prezzoVendita, Tipo tipo) throws SQLException {
        Prodotto prodotto = null;
        String insertProduct = "INSERT INTO teamprogetto.dbmagazzino " +
                "(Produttore, Modello, Descrizione, Dimensione, Memoria, Prezzo_acquisto, Prezzo_vendita, Tipo) " +
                "VALUES " +
                "(" + produttore + "," + modello + "," + descrizione + "," + dimensione + "," + memoria + "," + prezzoAcquisto + "," + prezzoVendita + "," + tipo + ");";
        try {
            ResultSet resultSet = DbManager.drawQuery().executeQuery(insertProduct);
            prodotto.toString(resultSet.getString("Produttore"), resultSet.getString("Modello"), resultSet.getString("Descrizione"), resultSet.getInt("Dimensione"), resultSet.getString("Memoria"), resultSet.getBigDecimal("Prezzo_acquisto"), resultSet.getBigDecimal("Prezzo_vendita"), resultSet.getString("Tipo"));
        } catch (SQLException e) {
            e.getMessage();
        }


    }*/
}

