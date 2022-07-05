package service;
import model.*;
public class CarteValidator {
    public boolean validate(Carte carte) {
        AutorValidator autorValidator = new AutorValidator();
        EdituraValidator edituraValidator = new EdituraValidator();
        SectiuneValidator sectiuneValidator = new SectiuneValidator();
        DataValidator dataValidator = new DataValidator();
        NameValidator nameValidator = new NameValidator();
        if(carte.getId() > 0 && autorValidator.valiadate(carte.getAutor()) && edituraValidator.validate(carte.getEditura()) && sectiuneValidator.validate(carte.getSectiune())
           && dataValidator.validate(carte.getDataPublicare()) && nameValidator.validate(carte.getTitlu()))
            return true;
        return false;
    }

}
