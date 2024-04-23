class Buch {
    private String titel;
    private String autor;
    private boolean verfuegbar;

    public Buch(String titel, String autor) {
        this.titel = titel;
        this.autor = autor;
        this.verfuegbar = true;
    }

    public String getTitel() {
        return titel;
    }

    public String getAutor() {
        return autor;
    }

    public boolean istVerfuegbar() {
        return verfuegbar;
    }

    public void setVerfuegbar(boolean verfuegbar) {
        this.verfuegbar = verfuegbar;
    }
}














