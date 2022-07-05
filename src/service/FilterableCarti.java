package service;
import model.*;

import java.util.ArrayList;

public interface FilterableCarti<T> {
    ArrayList<Carte> filter (ArrayList<Carte> carti, T value);

}
