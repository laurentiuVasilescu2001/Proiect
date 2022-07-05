package service;
import model.*;
public class DataValidator {

    public boolean validate(Data data){
        if(validateZi(data.getZi()) && validateLuna(data.getLuna()) && validateAn(data.getAn()))
            return true;
        return false;
    }

    public boolean validateZi(int zi){
        if (zi<=30 && zi>=1)
            return true;
        return false;
    }

    public boolean validateLuna(int luna){
        if(luna>=1 && luna <= 12)
            return true;
        return false;
    }

    public boolean validateAn(int an){
        if(an > 1500 && an <2050)
            return true;
        return false;
    }


}
