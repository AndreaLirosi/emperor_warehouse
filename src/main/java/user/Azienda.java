package user;

import magazzino.Magazzino;

public class Azienda extends Utente {

    private String societyName;
    private Magazzino magazzino;


    public Azienda(String name, String surname, String email, String password, String societyName, Magazzino magazzino) {
        super(name, surname, email, password);
        this.societyName = societyName;
        this.magazzino = magazzino;
    }

    public Azienda(String name, String surname, String email, String password, String societyName) {
        super(name, surname, email, password);
        this.societyName = societyName;
        this.magazzino = new Magazzino();
    }
    public String getSocietyName() {
        return societyName;
    }

    public Magazzino getMagazzino() {
        return magazzino;
    }

    @Override
    public String toString() {
        return super.toString()+
                "Azienda{" +
                "societyName='" + societyName + '\'' +
                ", magazzino=" + magazzino +
                '}';
    }
}
