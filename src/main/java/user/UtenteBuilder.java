package user;

public class UtenteBuilder {
    private String name;
    private String surname;
    private String email;
    private String password;

    public UtenteBuilder() {
    }

    public UtenteBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UtenteBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public UtenteBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UtenteBuilder setPassword(String password) {
        this.password = password;
        return this;
    }
    public Utente build () {
        return new Utente(name,surname,email,password);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
