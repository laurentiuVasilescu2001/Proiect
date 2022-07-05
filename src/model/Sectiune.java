package model;

import java.util.Arrays;

public class Sectiune {
    private String numeSectiune;
    private int idSectiune;

    public Sectiune(String numeSectiune, int idSectiune) {
        this.numeSectiune = numeSectiune;
        this.idSectiune = idSectiune;
    }

    public String getNumeSectiune() {
        return numeSectiune;
    }

    public void setNumeSectiune(String numeSectiune) {
        this.numeSectiune = numeSectiune;
    }

    public int getIdSectiune() {
        return idSectiune;
    }

    public void setIdSectiune(int idSectiune) {
        this.idSectiune = idSectiune;
    }

    @Override
    public String toString() {
        return "Sectiune{" +
                "numeSectiune='" + numeSectiune + '\'' +
                ", idSectiune=" + idSectiune +
                '}';
    }
}
