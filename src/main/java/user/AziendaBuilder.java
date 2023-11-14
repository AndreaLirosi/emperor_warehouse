package user;

public class AziendaBuilder extends UtenteBuilder {
    private String societyName;

    public AziendaBuilder() {
    }

    public AziendaBuilder setSocietyName(String societyName) {
        this.societyName = societyName;
        return this;
    }
    public Azienda build () {
        return new Azienda(getName(),getSurname(),getEmail(),getPassword(),societyName);
    }
}
