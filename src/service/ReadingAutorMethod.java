package service;

import model.Autor;
import model.Data;
import model.Perioada;
import model.Sex;
import service.audit.AuditService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public final class ReadingAutorMethod {
    private static String path = "C:\\Users\\vasilescuandrei1996\\IdeaProjects\\Proiect\\src\\files\\AutorFile.csv";
    private static ReadingAutorMethod instance;

    private ReadingAutorMethod() {
    }

    public static ReadingAutorMethod getInstance() {
        if (instance == null) {
            instance = new ReadingAutorMethod();
        }
        return instance;
    }

        public ArrayList<Autor> read()  {
            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                String linie = reader.readLine();
                ArrayList<Autor> autori = new ArrayList<>();

                while ((linie = reader.readLine()) != null) {
                    String[] elementeAutor = linie.split(", ");

                    int idAutor = Integer.parseInt(elementeAutor[0]);

                    String numeAutor = elementeAutor[1];

                    String prenumeAutor = elementeAutor[2];

                    Sex sex;
                    if (elementeAutor[3].equals("M"))
                        sex = Sex.M;
                    else sex = Sex.F;


                    String[] componenteDataNastere = elementeAutor[4].split("/");
                    int ziNastere = Integer.parseInt(componenteDataNastere[0]);
                    int lunaNastere = Integer.parseInt(componenteDataNastere[1]);
                    int anNastere = Integer.parseInt(componenteDataNastere[2]);
                    Data dataNastere = new Data(ziNastere, lunaNastere, anNastere);

                    Perioada perioada;
                    if (elementeAutor[5].equals("CLASICA"))
                        perioada = Perioada.CLASICA;
                    else if (elementeAutor[5].equals("ANTEBELICA"))
                        perioada = Perioada.ANTEBELICA;
                    else if (elementeAutor[5].equals("POSTBELICA"))
                        perioada = Perioada.POSTBELICA;
                    else perioada = Perioada.CLASICA;


                    String[] componenteDataDeces = elementeAutor[6].split("/");
                    int ziDeces = Integer.parseInt(componenteDataDeces[0]);
                    int lunaDeces = Integer.parseInt(componenteDataDeces[1]);
                    int anDeces = Integer.parseInt(componenteDataDeces[2]);
                    Data dataDeces = new Data(ziDeces, lunaDeces, anDeces);

                    Autor autor = new Autor(idAutor, numeAutor, prenumeAutor, sex, dataNastere, perioada, dataDeces);
                    autori.add(autor);


                }
                AuditService auditService = new AuditService("Citire_autori");
                auditService.WriteAuditService();
                return autori;

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    }

