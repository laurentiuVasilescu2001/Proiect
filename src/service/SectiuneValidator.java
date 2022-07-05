package service;

import model.Sectiune;

public class SectiuneValidator {

    public boolean validate(Sectiune sectiune){
        NameValidator nameValidator = new NameValidator();
        if(nameValidator.validate(sectiune.getNumeSectiune()) && sectiune.getIdSectiune() > 0)
            return true;
        return false;
    }
}
