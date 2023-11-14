package user;

import carrello.Carrello;

public class PrivatoBuilder extends UtenteBuilder {
    private Carrello spesa;

    public PrivatoBuilder() {
    }

    public PrivatoBuilder setSpesa(Carrello spesa) {
        this.spesa = spesa;
        return this;
    }
    public Privato build () {
        return new Privato(getName(),getSurname(),getEmail(),getPassword(),spesa);
    }

}
