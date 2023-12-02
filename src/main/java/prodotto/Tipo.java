package prodotto;

public enum Tipo {
    TABLET,
    SMARTPHONE,
    NOTEBOOK;

    public static Tipo stringTipo(String text) {
        if (text.equalsIgnoreCase(Tipo.TABLET.toString())) {
            return Tipo.TABLET;
        } else if (text.equalsIgnoreCase(Tipo.SMARTPHONE.toString())) {
            return Tipo.SMARTPHONE;
        } else if (text.equalsIgnoreCase(Tipo.NOTEBOOK.toString())) {
            return Tipo.NOTEBOOK;
        } else {
            throw new NullPointerException("non esiste questo tipo di prodotto");
        }

    }


}
