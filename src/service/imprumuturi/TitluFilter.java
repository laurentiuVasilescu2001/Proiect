package service.imprumuturi;

import model.Carte;
import model.Imprumut;
import service.FilterableImprumuturi;

import java.util.ArrayList;

public class TitluFilter implements FilterableImprumuturi<String> {
    @Override
    public ArrayList<Imprumut> filter(ArrayList<Imprumut> imprumuturi, String value) {


        ArrayList<Imprumut> imprumuturiFiltrateTitlu = new ArrayList<Imprumut>();

        for (Imprumut imprumut : imprumuturi){

            if(imprumut.getCarte().getTitlu().equals(value)){

                imprumuturiFiltrateTitlu.add(imprumut);

            }
        }
        return imprumuturiFiltrateTitlu;
    }


}
