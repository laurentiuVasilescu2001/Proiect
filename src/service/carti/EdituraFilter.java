package service.carti;

import model.*;
import service.FilterableCarti;

import java.util.ArrayList;

public class EdituraFilter implements FilterableCarti<String> {

    @Override
    public ArrayList<Carte> filter(ArrayList<Carte> carti, String value) {


        ArrayList<Carte> cartiSectiuneFiltrate = new ArrayList<Carte>();

        for (Carte carte : carti){

            if(carte.getEditura().getDenumire().equals(value)){

                cartiSectiuneFiltrate.add(carte);

            }
        }
        return cartiSectiuneFiltrate;

    }


}
