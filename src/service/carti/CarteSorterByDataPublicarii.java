package service.carti;
import model.*;
import java.util.Comparator;

public class CarteSorterByDataPublicarii implements Comparator <Carte> {
    @Override
    public int compare(Carte carte1, Carte carte2) {
        int compareLuna = carte2.getDataPublicare().getLuna() - carte1.getDataPublicare().getLuna();
        int compareAn = carte2.getDataPublicare().getAn() - carte1.getDataPublicare().getAn();
        int compareZi = carte2.getDataPublicare().getZi() - carte1.getDataPublicare().getZi();

        //return (compareAn == 0) ? compareLuna : ((compareLuna==0) ? compareZi :compareLuna);

        if(compareAn == 0){
            if(compareLuna==0) {
                return compareZi;
            }

            return compareLuna;
            }
        return compareAn;


    }
}
