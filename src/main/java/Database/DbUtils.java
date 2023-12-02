package Database;

import prodotto.Prodotto;
import prodotto.ProdottoBuilder;
import prodotto.Tipo;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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


    public static boolean addProduct_to_db(String produttore, String modello, String descrizione, int dimensione, String memoria, BigDecimal prezzoAcquisto, BigDecimal prezzoVendita, Tipo tipo) throws SQLException {

        String insertProduct = "INSERT INTO teamprogetto.dbmagazzino " +
                "(Produttore, Modello, Descrizione, Dimensione, Memoria, Prezzo_acquisto, Prezzo_vendita, Tipo) " +
                "VALUES " +
                "(" + produttore + "," + modello + "," + descrizione + "," + dimensione + "," + memoria + "," + prezzoAcquisto + "," + prezzoVendita + "," + tipo + ");";
        try {
            DbManager.drawQuery().executeQuery(insertProduct);
        } catch (SQLException e) {
            System.out.println("Il prodotto non è stato inserito nel db");
            e.getMessage();
        }

        return true;
    }

    public static Prodotto mappa_prodotto(int id) throws SQLException {

        try (Statement stmt = DbManager.drawQuery()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM teamprogetto.dbmagazzino WHERE id = " + id + " ;");
            ProdottoBuilder builder = new ProdottoBuilder();
            builder.setId(rs.getString("id"))
                    .setProduttore(rs.getString("Produttore"))
                    .setModello(rs.getString("Modello"))
                    .setDimensione(rs.getInt("Dimensione"))
                    .setDescrizione(rs.getString("Descrizione"))
                    .setMemoria(rs.getString("Memoria"))
                    .setPrezzoAcquisto(rs.getBigDecimal("Prezzo_acquisto"))
                    .setPrezzoVendita(rs.getBigDecimal("Prezzo_vendita"))
                    .setTipo(Tipo.stringTipo(rs.getString("Tipo")));
            return builder.build();
        }
    }

    public static ArrayList<Prodotto> mappa_prodotti(ResultSet resultSet) throws SQLException {
        ArrayList<Prodotto> tabella_prodotti = new ArrayList<>();
        while (resultSet.next()) {
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
            tabella_prodotti.add(builder.build());
        }
        return tabella_prodotti;
    }

    /**da duplicare per ogni view creata [per tipo, per parametro di ricerca...]*/
    public static ArrayList<Prodotto> stampa_view_nomeview() throws SQLException {
        String nome_view = "SELECT * FROM *nomeview*";
        try (Statement stmt = DbManager.drawQuery()) {
            return mappa_prodotti(stmt.executeQuery(nome_view));
        }
    }

    public static ArrayList<Prodotto> cerca_per_range (BigDecimal minimo, BigDecimal massimo)throws SQLException{
        String ricerca_range= "SELECT * FROM teamprogetto.dbmagazzino WHERE Prezzo_vendita BETWEEN "+ minimo +" AND " +massimo;
        try(Statement stmt = DbManager.drawQuery()){
            return mappa_prodotti(stmt.executeQuery(ricerca_range));
        }
    }



}

