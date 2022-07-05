package model;

public class Carte {
    private int id;
    private String titlu;
    private Autor autor;
    private Editura editura;
    private Data dataPublicare;
    private Sectiune sectiune;

    public Carte(int id, String titlu, Autor autor, Editura editura, Data dataPublicare, Sectiune sectiune) {
        this.id = id;
        this.titlu = titlu;
        this.autor = autor;
        this.editura = editura;
        this.dataPublicare = dataPublicare;
        this.sectiune = sectiune;
    }

    public String getTitlu() {
        return titlu;
    }

    public Autor getAutor() {
        return autor;
    }

    public Editura getEditura() {
        return editura;
    }

    public Data getDataPublicare() {
        return dataPublicare;
    }

    public Sectiune getSectiune() {
        return sectiune;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setEditura(Editura editura) {
        this.editura = editura;
    }

    public void setDataPublicare(Data dataPublicare) {
        this.dataPublicare = dataPublicare;
    }

    public void setSectiune(Sectiune sectiune) {
        this.sectiune = sectiune;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Carte{" +
                "id=" + id +
                ", titlu='" + titlu + '\'' +
                ", autor=" + autor +
                ", editura=" + editura +
                ", dataPublicare=" + dataPublicare +
                ", sectiune=" + sectiune +
                '}';
    }


}
