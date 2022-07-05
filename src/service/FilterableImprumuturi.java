package service;
import model.*;

import java.util.ArrayList;

public interface FilterableImprumuturi<T> {
    ArrayList<Imprumut> filter (ArrayList<Imprumut> imprumuturi, T value);

}
