package service;

import model.Cititor;
import model.Data;
import model.Sex;
import service.audit.AuditService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public final class ReadingCititorMethod {
    private static String path = "C:\\Users\\vasilescuandrei1996\\IdeaProjects\\Proiect\\src\\files\\CititorFile.csv";
    private static ReadingCititorMethod instance;
    private ReadingCititorMethod() {
    }

    public static ReadingCititorMethod getInstance() {
        if (instance == null) {
            instance = new ReadingCititorMethod();
        }
        return instance;
    }

    public ArrayList<Cititor> read() throws FileNotFoundException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();
            ArrayList<Cititor> cititori = new ArrayList<>();
            while((line = reader.readLine()) != null){
                String [] elementeCitite = line.split(", ");

                int idCititor = Integer.parseInt(elementeCitite[0]);

                String nume = elementeCitite[1];

                String prenume = elementeCitite[2];

                Sex sex;
                if (elementeCitite[3].equals("M"))
                    sex = Sex.M;
                else sex = Sex.F;

                String[] componenteDataNastere = elementeCitite[4].split("/");
                int ziNastere = Integer.parseInt(componenteDataNastere[0]);
                int lunaNastere = Integer.parseInt(componenteDataNastere[1]);
                int anNastere = Integer.parseInt(componenteDataNastere[2]);
                Data dataNastere = new Data(ziNastere, lunaNastere, anNastere);

                Cititor cititor = new Cititor(idCititor,nume,prenume,sex,dataNastere);
                cititori.add(cititor);


            }
            AuditService auditService = new AuditService("Citire_cititori");
            auditService.WriteAuditService();
            return cititori;

    } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
