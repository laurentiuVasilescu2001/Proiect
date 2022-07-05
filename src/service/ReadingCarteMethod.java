package service;

import model.*;
import service.audit.AuditService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public final class ReadingCarteMethod{
    private static String path = "C:\\Users\\vasilescuandrei1996\\IdeaProjects\\Proiect\\src\\files\\CarteFile.csv";
    private static ReadingCarteMethod instance;
    private ReadingCarteMethod() {
    }

    public static ReadingCarteMethod getInstance() {

        if (instance == null) {
            instance = new ReadingCarteMethod();
        }
        return instance;
    }

    public ArrayList<Carte> read() throws IOException {

        String line = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            line = reader.readLine();
            String[] values = line.split(", ");
                    ArrayList<Carte> cartiCititie = new ArrayList<Carte>();
                    while ((line = reader.readLine()) != null) {

                        String[] elementeCarte = line.split(", ");

                        int idCarte = Integer.parseInt(elementeCarte[0]);

                        String denumire = elementeCarte[1];

                        int idAutor = Integer.parseInt(elementeCarte[2]);

                        String numeAutor = elementeCarte[3];

                        String prenumeAutor = elementeCarte[4];

                        Sex sex;
                        if (elementeCarte[5].equals("M"))
                            sex = Sex.M;
                        else sex = Sex.F;


                        String[] componenteDataNastere = elementeCarte[6].split("/");
                        int ziNastere = Integer.parseInt(componenteDataNastere[0]);
                        int lunaNastere = Integer.parseInt(componenteDataNastere[1]);
                        int anNastere = Integer.parseInt(componenteDataNastere[2]);
                        Data dataNastere = new Data(ziNastere, lunaNastere, anNastere);

                        Perioada perioada;
                        if (elementeCarte[7].equals("CLASICA"))
                            perioada = Perioada.CLASICA;
                        else if (elementeCarte[7].equals("ANTEBELICA"))
                            perioada = Perioada.ANTEBELICA;
                        else if (elementeCarte[7].equals("POSTBELICA"))
                            perioada = Perioada.POSTBELICA;
                        else perioada = Perioada.CLASICA;


                        String[] componenteDataDeces = elementeCarte[8].split("/");
                        int ziDeces = Integer.parseInt(componenteDataDeces[0]);
                        int lunaDeces = Integer.parseInt(componenteDataDeces[1]);
                        int anDeces = Integer.parseInt(componenteDataDeces[2]);
                        Data dataDeces = new Data(ziDeces, lunaDeces, anDeces);

                        int id_editura = Integer.parseInt(elementeCarte[9]);

                        String denumireEditura = elementeCarte[10];

                        String[] componenteDataInfiintare = elementeCarte[11].split("/");
                        int ziInfiintare = Integer.parseInt(componenteDataInfiintare[0]);
                        int lunaInfiintare = Integer.parseInt(componenteDataInfiintare[1]);
                        int anInfiintare = Integer.parseInt(componenteDataInfiintare[2]);
                        Data dataInfiintare = new Data(ziInfiintare, lunaInfiintare, anInfiintare);

                        String[] componenteDataPublicare = elementeCarte[12].split("/");
                        int ziPublicare = Integer.parseInt(componenteDataPublicare[0]);
                        int lunaPublicare = Integer.parseInt(componenteDataPublicare[1]);
                        int anPublicare = Integer.parseInt(componenteDataPublicare[2]);
                        Data dataPublicare = new Data(ziPublicare, lunaPublicare, anPublicare);

                        String numeSectiune = elementeCarte[13];


                        int idSectiune = Integer.parseInt(elementeCarte[14]);


                        Carte carte = new Carte(idCarte, denumire, new Autor(idAutor, numeAutor, prenumeAutor, sex, dataNastere, perioada, dataDeces), new Editura(1,denumireEditura, dataInfiintare), dataPublicare, new Sectiune(numeSectiune, idSectiune));
                        cartiCititie.add(carte);


                    }

                    AuditService auditService = new AuditService("Citire_carti");
                    auditService.WriteAuditService();
                    return cartiCititie;

                }


        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}



