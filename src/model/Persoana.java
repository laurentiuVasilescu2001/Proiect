package model;

public class Persoana {
    private int id;
    private String nume;
    private String prenume;
    private Sex sex;
    private Data dataNastere;

    public Persoana(int id, String nume, String prenume, Sex sex, Data dataNastere) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.sex = sex;
        this.dataNastere = dataNastere;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Data getDataNastere() {
        return dataNastere;
    }

    public void setDataNastere(Data dataNastere) {
        this.dataNastere = dataNastere;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", sex=" + sex +
                ", dataNastere=" + dataNastere +
                '}';
    }
}
