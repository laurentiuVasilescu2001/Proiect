package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Cititor extends Persoana {



    public Cititor(int id, String nume, String prenume, Sex sex, Data dataNastere) {
        super(id, nume, prenume, sex, dataNastere);

    }



    @Override
    public String toString() {
        return "Cititor{" +
                "id=" + this.getId() + ' ' +
                "nume='" + this.getNume() + '\'' +
                ", prenume='" + this.getPrenume() + '\'' +
                ", sex=" + this.getSex() +
                ", dataNastere=" + this.getDataNastere() +
                '}';

    }


}
