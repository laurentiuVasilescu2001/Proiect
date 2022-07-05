package service.carti;
import model.*;
import java.util.Comparator;

public class CarteSorterByAutorAndTitlu implements Comparator <Carte> {
    @Override
    public int compare(Carte carte1, Carte carte2) {
        int compareAutor = carte1.getAutor().getNume().compareTo(carte2.getAutor().getNume());
        int compareTitlu = carte1.getTitlu().compareTo(carte2.getTitlu());
        return (compareAutor == 0) ? compareTitlu : compareAutor;
    }
}
