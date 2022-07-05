package model;

public class Imprumut {
    private int idImprumut;
    private Cititor cititor;
    private Carte carte;

    public Imprumut(int idImprumut, Cititor cititor, Carte carte) {
        this.idImprumut = idImprumut;
        this.cititor = cititor;
        this.carte = carte;
    }

    public int getIdImprumut() {
        return idImprumut;
    }

    public void setIdImprumut(int idImprumut) {
        this.idImprumut = idImprumut;
    }

    public Cititor getCititor() {
        return cititor;
    }

    public void setCititor(Cititor cititor) {
        this.cititor = cititor;
    }

    public Carte getCarte() {
        return carte;
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
    }

    @Override
    public String toString() {
        return "Imprumut{" +
                "idImprumut=" + idImprumut +
                ", cititor=" + cititor +
                ", carte=" + carte +
                '}';
    }
}
