package service;

import model.Autor;

public class AutorValidator {

    public boolean valiadate(Autor autor){
        NameValidator nameValidator = new NameValidator();
        DataValidator dataValidator = new DataValidator();
        if(autor.getId() > 0 && nameValidator.validate(autor.getNume()) && nameValidator.validate(autor.getPrenume()) && dataValidator.validate(autor.getDataNastere())
           && dataValidator.validate(autor.getDataDeces()) && autor.getDataDeces().getAn() > autor.getDataNastere().getAn()){
                return true;
        }
        return false;
    }
}
