package service;
import model.*;
public class EdituraValidator {

    public boolean validate(Editura editura){
        NameValidator nameValidator = new NameValidator();
        DataValidator dataValidator = new DataValidator();
        if(nameValidator.validate(editura.getDenumire()) && dataValidator.validate(editura.getDataInfiintare()))
            return true;
        return false;

    }
}
