package model;
public class Autor<String> extends Persoana {
    private Perioada perioada;
    private Data dataDeces;


    public Autor(int id, String nume, String prenume, Sex sex, Data dataNastere, Perioada perioada, Data dataDeces) {
        super(id, nume, prenume, sex, dataNastere);
        this.perioada = perioada;
        this.dataDeces = dataDeces;
    }

    public Perioada getPerioada() {
        return perioada;
    }

    public void setPerioada(Perioada perioada) {
        this.perioada = perioada;
    }

    public Data getDataDeces() {
        return dataDeces;
    }

    public void setDataDeces(Data dataDeces) {
        this.dataDeces = dataDeces;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + this.getId() + ' ' +
                "nume='" + this.getNume() + '\'' +
                ", prenume='" + this.getPrenume() + '\'' +
                ", sex=" + this.getSex() +
                ", dataNastere=" + this.getDataNastere() +
                '}' +
                "perioada=" + perioada +
                ", dataDeces=" + dataDeces +
                '}';
    }


}
