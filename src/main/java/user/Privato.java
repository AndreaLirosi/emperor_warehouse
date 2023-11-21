package user;

import carrello.Carrello;
import magazzino.Magazzino;

public class Privato extends Utente{

    private Carrello spesa;
    private Magazzino magazzino;

    public Magazzino getMagazzino() {
        return magazzino;
    }

    public Privato(String name, String surname, String email, String password, Carrello spesa) {
        super(name, surname, email, password);
        this.spesa = spesa;
    }
    public Privato(String name, String surname, String email, String password) {
        super(name, surname, email, password);
        this.spesa = new Carrello();
    }

    public Carrello getSpesa() {
        return spesa;
    }

    public void setSpesa(Carrello spesa) {
        this.spesa = spesa;
    }

    @Override
    public String toString() {

        return  super.toString()+
                "Privato{" +
                "spesa=" + spesa +
                '}';
    }
}
