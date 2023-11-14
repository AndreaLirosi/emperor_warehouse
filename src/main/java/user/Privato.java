package user;

import carrello.Carrello;

public class Privato extends Utente{

    private Carrello spesa;

    public Privato(String name, String surname, String email, String password) {
        super(name, surname, email, password);
    }

    public Privato(String name, String surname, String email, String password, Carrello spesa) {
        super(name, surname, email, password);
        this.spesa = spesa;
    }

    public Carrello getSpesa() {
        return spesa;
    }

    public void setSpesa(Carrello spesa) {
        this.spesa = spesa;
    }

    @Override
    public String toString() {
        super.toString();
        return "Utente{" +
                "name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                "Privato{" +
                "spesa=" + spesa +
                '}';
    }
}
