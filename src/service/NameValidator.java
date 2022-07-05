package service;

public class NameValidator {

    public boolean validate(String name){
        if (validateName(name) && validateNameRegex(name))
            return true;
        return false;
    }

    public boolean validateName(String name){
        if(name.isEmpty() || name.isBlank())
            return false;
        return true;
    }

    public boolean validateNameRegex(String name){
        String regex = "[A-Z][A-z, ]+";
            return name.matches(regex);
    }
}
