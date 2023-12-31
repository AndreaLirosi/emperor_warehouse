package Database;

import prodotto.Prodotto;
import prodotto.ProdottoBuilder;
import prodotto.Tipo;
import user.*;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import static org.example.Menu.creazionePrivato;

public class DbUtils {
    private static String selectQuery = "SELECT * FROM dbmagazzino";

    public static boolean createMagazzino(Azienda utente) {
        String create_table = "CREATE TABLE `" + utente.getSocietyName() + "` (\n" +
                "  `id` int(11) PRIMARY KEY AUTO_INCREMENT,\n" +
                "  `Produttore` varchar(30) DEFAULT NULL,\n" +
                "  `Modello` varchar(30) DEFAULT NULL,\n" +
                "  `Descrizione` varchar(50) DEFAULT NULL,\n" +
                "  `Dimensione` float DEFAULT NULL,\n" +
                "  `Memoria` varchar(30) DEFAULT NULL,\n" +
                "  `Prezzo_acquisto` decimal(20,6) DEFAULT NULL,\n" +
                "  `Prezzo_vendita` decimal(20,6) DEFAULT NULL,\n" +
                "  `Tipo` varchar(30) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;";

        try (Statement stms = DbManager.drawQuery()) {
            stms.execute(create_table);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException("Errore durante la creazione della tabella");
        }

    }

    public static ArrayList<Prodotto> mapMagazzino() {
        ArrayList<Prodotto> magazzino = new ArrayList<>();
        try {
            ResultSet resultSet = DbManager.drawQuery().executeQuery(selectQuery);
            ProdottoBuilder builder = new ProdottoBuilder();

            while (resultSet.next()) {
                builder.setId(resultSet.getInt("id"))
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

    public static ArrayList <Prodotto> mappaStorico (Privato utente){
        int utenteid = searchUtente(utente);
        ArrayList <Prodotto> storico = new ArrayList<>();
        String mappaStorico = "SELECT Produttore, Modello,Prezzo_acquisto, Prezzo_vendita, Tipo " +
                                " FROM storico_magazzino" +
                                " WHERE idUtente= " + utenteid + ";";
        try (Statement stm = DbManager.drawQuery()){
            System.out.println(mappaStorico);
            System.out.println();
            storico = mappazzone(stm.executeQuery(mappaStorico));
        } catch (SQLException e) {
            System.out.println("Errore di connessione");
            e.getMessage();
        }
        return storico;
        //throw new RuntimeException("Errore nella mappattura dello storico");
    }

    /**
     * Inserimento di un prodotto nel db
     */
    public static boolean addToStorico(Prodotto p, int idUtente) throws SQLException {

        String insertProduct = "INSERT INTO storico_magazzino " +
                "(idProdotto, Produttore, Modello, Descrizione, Dimensione, Memoria, Prezzo_acquisto, Prezzo_vendita, Tipo, idUtente) " +
                "VALUES " +
                "(" +p.getId()+", '"+ p.getProduttore() + "','" + p.getModello() + "','" + p.getDescrizione() + "'," + p.getDimensione() +
                ",'" + p.getMemoria() + "'," + p.getPrezzoAcquisto() + "," + p.getPrezzoVendita() + ",'" + p.getTipo() + "', " + idUtente + ");";
        System.out.println(insertProduct);
        try {
            DbManager.drawQuery().execute(insertProduct);
        } catch (SQLException e) {
            System.out.println("Il prodotto non è stato inserito nello storico");
            e.getMessage();
        }

        return true;
    }

    /**
     * Inserimento di un prodotto nel db
     */
    public static boolean addProduct_to_db(Prodotto p) throws SQLException {

        String insertProduct = "INSERT INTO dbmagazzino " +
                "(Produttore, Modello, Descrizione, Dimensione, Memoria, Prezzo_acquisto, Prezzo_vendita, Tipo) " +
                "VALUES " +
                "('" + p.getProduttore() + "','" + p.getModello() + "','" + p.getDescrizione() + "'," + p.getDimensione() +
                ",'" + p.getMemoria() + "'," + p.getPrezzoAcquisto() + "," + p.getPrezzoVendita() + ",'" + p.getTipo() + "');";
        try {
            DbManager.drawQuery().execute(insertProduct);
        } catch (SQLException e) {
            System.out.println("Il prodotto non è stato inserito nel db");
            e.getMessage();
        }

        return true;
    }

    public static Utente mappa_Utente(Utente utente) {
        try (Statement stmt = DbManager.drawQuery()) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM utenti WHERE email='" + utente.getEmail() + "' AND password= '" + utente.getPassword() + "';");

            if (rs.next()) { // Verifica se ci sono risultati nel ResultSet
                PrivatoBuilder builder = new PrivatoBuilder();
                builder.setSurname(rs.getString("Cognome"))
                        .setName(rs.getString("Nome"))
                        .setEmail(rs.getString("email"))
                        .setPassword(rs.getString("password"));
                return builder.build();

            } else throw new RuntimeException("utente non trovato");

        } catch (SQLException e) {
            throw new RuntimeException("Si è verificato un errore durante la mappatura dell'utente", e);
        }

    }


    /**
     * ricerca tramite id e restituzione dell'oggetto mappato
     */
    public static Prodotto mappa_prodotto(int id) {
        try (Statement stmt = DbManager.drawQuery()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM dbmagazzino WHERE id = " + id + " ;");

            if (rs.next()) { // Verifica se ci sono risultati nel ResultSet
                ProdottoBuilder builder = new ProdottoBuilder();
                builder.setId(rs.getInt("id"))
                        .setProduttore(rs.getString("Produttore"))
                        .setModello(rs.getString("Modello"))
                        .setDimensione(rs.getInt("Dimensione"))
                        .setDescrizione(rs.getString("Descrizione"))
                        .setMemoria(rs.getString("Memoria"))
                        .setPrezzoAcquisto(rs.getBigDecimal("Prezzo_acquisto"))
                        .setPrezzoVendita(rs.getBigDecimal("Prezzo_vendita"))
                        .setTipo(Tipo.stringTipo(rs.getString("Tipo")));
                return builder.build();
            } else {
                throw new RuntimeException("Nessun risultato trovato per l'ID " + id);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Si è verificato un errore durante la mappatura dell'oggetto", e);
        }
    }

    public static int searchUtente(Privato utente) {
        String queryFindUtenti = "SELECT * FROM utenti WHERE Cognome = '" + utente.getSurname() + "' " + "AND Nome= '" + utente.getName() + "' AND email= '" + utente.getEmail() + "' ;";
        System.out.println(queryFindUtenti);
        try (Statement stmt = DbManager.drawQuery()) {
            ResultSet rst = stmt.executeQuery(queryFindUtenti);
            if (rst.next()) {
                return rst.getInt("id");
            }
            else throw new RuntimeException("utente non trovato");
        } catch (SQLException e) {

            throw new RuntimeException("Errore durante la ricerca dell'utente");
        }

    }

    public static boolean addNewPrivato(Privato privato){
        String insertPrivato = "INSERT INTO utenti\n" +
                "(Cognome, Nome, email, password)\n" +
                "VALUES('" + privato.getSurname() +"', '" + privato.getName() + "', '" + privato.getEmail() + "', '" + privato.getPassword() +"');";
        try (Statement stmt = DbManager.drawQuery()) {
            stmt.executeUpdate(insertPrivato);

        } catch (SQLException e) {

            throw new RuntimeException("errore durante la registrazione, utente non inserito");
        }
        return true;
    }

    /**
     * dato un arrayList elimina ogni prodotto dell'arraylist dal db
     */
    public static boolean rimozione_spesa_dal_db(Privato utente) {
        int idUtente = searchUtente(utente);

        for (Prodotto p : utente.getSpesa().getProdottiNelCarrello()) {
            try {
                addToStorico(p, idUtente);
            } catch (SQLException e) {
                throw new RuntimeException("Errore nella trasrcizione dell'oggetto");
            }
            delete_by_id(p.getId());
        }
        return true;
    }

    /**
     * dato un id elimina il prodotto dal db
     */
    public static boolean delete_by_id(int id) {
        String delete_query = "DELETE FROM dbmagazzino WHERE id = " + id + " ;";
        try (Statement stmt = DbManager.drawQuery()) {
            stmt.execute(delete_query);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException("ERRORE: Delete query ha dato un errore");
        }
    }

    /**
     * Dato un ResultSet trasforma il risultato della query in un ArrayList<Prodotto>
     */
    private static ArrayList<Prodotto> mappa_prodotti(ResultSet resultSet) {
        ArrayList<Prodotto> tabella_prodotti = new ArrayList<>();
        try {
            while (resultSet.next()) {
                ProdottoBuilder builder = new ProdottoBuilder();
                builder.setId(resultSet.getInt("id"))
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
        } catch (SQLException e) {
            throw new RuntimeException("Si è verificato un errore durante la mappatura dell'array");
        }
    }

    /**
     * da duplicare per ogni view creata [per tipo, per parametro di ricerca (asc, desc)...]
     * //CREATE VIEW tablet AS SELECT * FROM dbmagazzino WHERE Tipo = 'TABLET' WITH CASCADED CHECK OPTION;
     * //SELECT * FROM dbmagazzino ORDER BY Prezzo_vendita ASC;
     * <p>
     * public static ArrayList<Prodotto> stampa_view_nomeview() throws SQLException {
     * String nome_view = "SELECT * FROM *nomeview*";
     * try (Statement stmt = DbManager.drawQuery()) {
     * return mappa_prodotti(stmt.executeQuery(nome_view));
     * }
     * }
     */

    public static ArrayList<Prodotto> stampa_view_tablet() throws SQLException {
        String nome_view = "SELECT * FROM tablet";
        try (Statement stmt = DbManager.drawQuery()) {
            return mappa_prodotti(stmt.executeQuery(nome_view));
        }
    }

    public static ArrayList<Prodotto> stampa_view_descrizione() throws SQLException {
        String nome_view = "SELECT * FROM descrizione";
        try (Statement stmt = DbManager.drawQuery()) {
            return mappa_prodotti(stmt.executeQuery(nome_view));
        }
    }

    public static ArrayList<Prodotto> stampa_view_smartphone() throws SQLException {
        String nome_view = "SELECT * FROM smartphone";
        try (Statement stmt = DbManager.drawQuery()) {
            return mappa_prodotti(stmt.executeQuery(nome_view));
        }
    }

    public static ArrayList<Prodotto> stampa_view_notebook() throws SQLException {
        String nome_view = "SELECT * FROM notebook";
        try (Statement stmt = DbManager.drawQuery()) {
            return mappa_prodotti(stmt.executeQuery(nome_view));
        }
    }

    public static ArrayList<Prodotto> stampa_view_prezzo_vendita_asc() throws SQLException {
        String nome_view = "SELECT * FROM prezzo_vendita_asc";
        try (Statement stmt = DbManager.drawQuery()) {
            return mappa_prodotti(stmt.executeQuery(nome_view));
        }
    }

    public static ArrayList<Prodotto> stampa_view_prezzo_vendita_desc() throws SQLException {
        String nome_view = "SELECT * FROM prezzo_vendita_desc";
        try (Statement stmt = DbManager.drawQuery()) {
            return mappa_prodotti(stmt.executeQuery(nome_view));
        }
    }

    public static ArrayList<Prodotto> stampa_view_prezzo_acquisto_desc() throws SQLException {
        String nome_view = "SELECT * FROM prezzo_acquisto_desc";
        try (Statement stmt = DbManager.drawQuery()) {
            return mappa_prodotti(stmt.executeQuery(nome_view));
        }
    }

    public static ArrayList<Prodotto> stampa_view_prezzo_acquisto_asc() throws SQLException {
        String nome_view = "SELECT * FROM prezzo_acquisto_asc";
        try (Statement stmt = DbManager.drawQuery()) {
            return mappa_prodotti(stmt.executeQuery(nome_view));
        }
    }

    public static ArrayList<Prodotto> stampa_view_dimensione_asc() throws SQLException {
        String nome_view = "SELECT * FROM dimensione_asc";
        try (Statement stmt = DbManager.drawQuery()) {
            return mappa_prodotti(stmt.executeQuery(nome_view));
        }
    }

    public static ArrayList<Prodotto> stampa_view_dimensione_desc() throws SQLException {
        String nome_view = "SELECT * FROM dimensione_desc";
        try (Statement stmt = DbManager.drawQuery()) {
            return mappa_prodotti(stmt.executeQuery(nome_view));
        }
    }

    public static ArrayList<Prodotto> stampa_view_memoria_desc() throws SQLException {
        String nome_view = "SELECT * FROM memoria_desc";
        try (Statement stmt = DbManager.drawQuery()) {
            return mappa_prodotti(stmt.executeQuery(nome_view));
        }
    }

    public static ArrayList<Prodotto> stampa_view_memoria_asc() throws SQLException {
        String nome_view = "SELECT * FROM memoria_asc";
        try (Statement stmt = DbManager.drawQuery()) {
            return mappa_prodotti(stmt.executeQuery(nome_view));
        }
    }

    public static ArrayList<Prodotto> stampa_view_produttore() throws SQLException {
        String nome_view = "SELECT * FROM produttore";
        try (Statement stmt = DbManager.drawQuery()) {
            return mappa_prodotti(stmt.executeQuery(nome_view));
        }
    }

    public static ArrayList<Prodotto> stampa_view_modello() throws SQLException {
        String nome_view = "SELECT * FROM modello";
        try (Statement stmt = DbManager.drawQuery()) {
            return mappa_prodotti(stmt.executeQuery(nome_view));
        }
    }


    public static ArrayList<Prodotto> cerca_per_range(BigDecimal minimo, BigDecimal massimo) throws SQLException {
        String ricerca_range = "SELECT * FROM dbmagazzino WHERE Prezzo_vendita BETWEEN " + minimo + " AND " + massimo;
        try (Statement stmt = DbManager.drawQuery()) {
            return mappa_prodotti(stmt.executeQuery(ricerca_range));
        }
    }

    public static ArrayList<Prodotto> cerca_per_produttore(String produttore) throws SQLException {
        String select_produttore = "SELECT * FROM dbmagazzino WHERE Produttore LIKE '%" + produttore + "%' ;";
        try (Statement stmt = DbManager.drawQuery()) {
            return mappa_prodotti(stmt.executeQuery(select_produttore));
        }
    }

    public static ArrayList<Prodotto> cerca_per_modello(String modello) throws SQLException {
        String select_produttore = "SELECT * FROM dbmagazzino WHERE Modello LIKE '%" + modello + "%' ;";
        try (Statement stmt = DbManager.drawQuery()) {
            return mappa_prodotti(stmt.executeQuery(select_produttore));
        }
    }

    public static ArrayList<Prodotto> cerca_per_descrizione(String descrizione) throws SQLException {
        String select_produttore = "SELECT * FROM dbmagazzino WHERE Descrizione LIKE '%" + descrizione + "%' ;";
        try (Statement stmt = DbManager.drawQuery()) {
            return mappa_prodotti(stmt.executeQuery(select_produttore));
        }
    }

    public static ArrayList<Prodotto> cerca_per_dimensione(double dimensione) throws SQLException {
        String select_produttore = "SELECT * FROM dbmagazzino WHERE Dimensione = '" + dimensione + "' ;";
        try (Statement stmt = DbManager.drawQuery()) {
            return mappa_prodotti(stmt.executeQuery(select_produttore));
        }
    }

    public static ArrayList<Prodotto> cerca_per_memoria(String memoria) throws SQLException {
        String select_produttore = "SELECT * FROM dbmagazzino WHERE Memoria LIKE '%" + memoria + "%' ;";
        try (Statement stmt = DbManager.drawQuery()) {
            return mappa_prodotti(stmt.executeQuery(select_produttore));
        }
    }

    public static ArrayList<Prodotto> cerca_per_prezzo_acquisto(BigDecimal prezzo_acquisto) throws SQLException {
        String select_produttore = "SELECT * FROM dbmagazzino WHERE Prezzo_acquisto = '" + prezzo_acquisto + "' ;";
        try (Statement stmt = DbManager.drawQuery()) {
            return mappa_prodotti(stmt.executeQuery(select_produttore));
        }
    }

    public static ArrayList<Prodotto> cerca_per_prezzo_vendita(BigDecimal prezzo_vendita) throws SQLException {
        String select_produttore = "SELECT * FROM dbmagazzino WHERE Prezzo_vendita = '" + prezzo_vendita + "' ;";
        try (Statement stmt = DbManager.drawQuery()) {
            return mappa_prodotti(stmt.executeQuery(select_produttore));
        }
    }
    private static ArrayList<Prodotto> mappazzone(ResultSet resultSet) {
        ArrayList<Prodotto> tabella_prodotti = new ArrayList<>();
        try {
            while (resultSet.next()) {
                ProdottoBuilder builder = new ProdottoBuilder();
                builder.setProduttore(resultSet.getString("Produttore"))
                        .setModello(resultSet.getString("Modello"))
                        .setPrezzoAcquisto(resultSet.getBigDecimal("Prezzo_acquisto"))
                        .setPrezzoVendita(resultSet.getBigDecimal("Prezzo_vendita"))
                        .setTipo(Tipo.stringTipo(resultSet.getString("Tipo")));
                tabella_prodotti.add(builder.build());
            }
            return tabella_prodotti;
        } catch (SQLException e) {
            throw new RuntimeException("Si è verificato un errore durante la mappatura dell'array");
        }
    }

}

