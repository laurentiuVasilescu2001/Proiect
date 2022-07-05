package service.carti;

import model.*;
import service.FilterableCarti;

import java.util.ArrayList;

public class AutorFilter implements FilterableCarti<String> {

    @Override
    public ArrayList<Carte> filter(ArrayList<Carte> carti, String value) {


        ArrayList<Carte> cartiSectiuneFiltrate = new ArrayList<Carte>();

        for (Carte carte : carti){

            if(carte.getAutor().getNume().equals(value)){

                cartiSectiuneFiltrate.add(carte);

            }
        }
        return cartiSectiuneFiltrate;
    }
}
