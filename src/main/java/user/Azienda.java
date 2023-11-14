package user;

public class Azienda extends Utente {

    private String societyName;

    public Azienda(String name, String surname, String email, String password) {
        super(name, surname, email, password);
    }

    public Azienda(String name, String surname, String email, String password, String societyName) {
        super(name, surname, email, password);
        this.societyName = societyName;
    }

    public String getSocietyName() {
        return societyName;
    }

    @Override
    public String toString() {
        return "Azienda{" +
                "societyName='" + societyName + '\'' +
                '}';
    }
}
