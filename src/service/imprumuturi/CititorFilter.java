package service.imprumuturi;

import model.Imprumut;
import service.FilterableImprumuturi;

import java.util.ArrayList;

public class CititorFilter implements FilterableImprumuturi<Integer> {
    public ArrayList<Imprumut> filter(ArrayList<Imprumut> imprumuturi, Integer value) {


        ArrayList<Imprumut> imprumuturiFiltrateIdCititor = new ArrayList<Imprumut>();

        for (Imprumut imprumut : imprumuturi){

            if(imprumut.getCititor().getId() == value){

                imprumuturiFiltrateIdCititor.add(imprumut);

            }
        }
        return imprumuturiFiltrateIdCititor;
    }
}
