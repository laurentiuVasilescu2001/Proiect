package service;

import com.sun.source.doctree.IndexTree;
import model.*;
import service.audit.AuditService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public final class ReadingImprumutMethod {
    private static String path = "C:\\Users\\vasilescuandrei1996\\IdeaProjects\\Proiect\\src\\files\\ImprumutFile.csv";
    private static ReadingImprumutMethod instance;
    private ReadingImprumutMethod() {
    }

    public static ReadingImprumutMethod getInstance() {

        if (instance == null) {
            instance = new ReadingImprumutMethod();
        }
        return instance;
    }

    public ArrayList<Imprumut> read() throws FileNotFoundException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();
            ArrayList<Imprumut> imprumuturi = new ArrayList<>();
            while((line = reader.readLine()) != null){
                String [] elementeImprumut = line.split(", ");

                int idImprumut = Integer.parseInt(elementeImprumut[0]);

                int idCititor = Integer.parseInt(elementeImprumut[1]);

                String nume = elementeImprumut[2];

                String prenume = elementeImprumut[3];

                Sex sex;
                if (elementeImprumut[4].equals("M"))
                    sex = Sex.M;
                else sex = Sex.F;

                String[] componenteDataNastere = elementeImprumut[5].split("/");
                int ziNastere = Integer.parseInt(componenteDataNastere[0]);
                int lunaNastere = Integer.parseInt(componenteDataNastere[1]);
                int anNastere = Integer.parseInt(componenteDataNastere[2]);
                Data dataNastere = new Data(ziNastere, lunaNastere, anNastere);

                int idCarte = Integer.parseInt(elementeImprumut[6]);

                String denumire = elementeImprumut[7];

                int idAutor = Integer.parseInt(elementeImprumut[8]);

                String numeAutor = elementeImprumut[9];

                String prenumeAutor = elementeImprumut[10];

                Sex sex2;
                if (elementeImprumut[11].equals("M"))
                    sex2 = Sex.M;
                else sex2= Sex.F;


                String[] componenteDataNastere2 = elementeImprumut[12].split("/");
                int ziNastere2 = Integer.parseInt(componenteDataNastere2[0]);
                int lunaNastere2 = Integer.parseInt(componenteDataNastere2[1]);
                int anNastere2 = Integer.parseInt(componenteDataNastere2[2]);
                Data dataNastere2 = new Data(ziNastere2, lunaNastere2, anNastere2);

                Perioada perioada;
                if (elementeImprumut[13].equals("CLASICA"))
                    perioada = Perioada.CLASICA;
                else if (elementeImprumut[13].equals("ANTEBELICA"))
                    perioada = Perioada.ANTEBELICA;
                else if (elementeImprumut[13].equals("POSTBELICA"))
                    perioada = Perioada.POSTBELICA;
                else perioada = Perioada.CLASICA;


                String[] componenteDataDeces = elementeImprumut[14].split("/");
                int ziDeces = Integer.parseInt(componenteDataDeces[0]);
                int lunaDeces = Integer.parseInt(componenteDataDeces[1]);
                int anDeces = Integer.parseInt(componenteDataDeces[2]);
                Data dataDeces = new Data(ziDeces, lunaDeces, anDeces);

                int idEditura = Integer.parseInt(elementeImprumut[15]);


                String denumireEditura = elementeImprumut[16];

                String[] componenteDataInfiintare = elementeImprumut[17].split("/");
                int ziInfiintare = Integer.parseInt(componenteDataInfiintare[0]);
                int lunaInfiintare = Integer.parseInt(componenteDataInfiintare[1]);
                int anInfiintare = Integer.parseInt(componenteDataInfiintare[2]);
                Data dataInfiintare = new Data(ziInfiintare, lunaInfiintare, anInfiintare);

                String[] componenteDataPublicare = elementeImprumut[18].split("/");
                int ziPublicare = Integer.parseInt(componenteDataPublicare[0]);
                int lunaPublicare = Integer.parseInt(componenteDataPublicare[1]);
                int anPublicare = Integer.parseInt(componenteDataPublicare[2]);
                Data dataPublicare = new Data(ziPublicare, lunaPublicare, anPublicare);

                String numeSectiune = elementeImprumut[19];

                int idSectiune = Integer.parseInt(elementeImprumut[20]);

                Imprumut imprumut = new Imprumut(idImprumut,new Cititor(idCititor,nume,prenume,sex,dataNastere),new Carte(idCarte, denumire, new Autor(idAutor, numeAutor, prenumeAutor, sex2, dataNastere2, perioada, dataDeces), new Editura(idEditura,denumireEditura, dataInfiintare), dataPublicare, new Sectiune(numeSectiune, idSectiune)));
                imprumuturi.add(imprumut);


            }
            AuditService auditService = new AuditService("Citire_imprumuturi");
            auditService.WriteAuditService();
            return imprumuturi;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}