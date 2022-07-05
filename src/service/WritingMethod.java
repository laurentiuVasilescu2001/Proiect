package service;

import model.Autor;
import model.Carte;
import model.Cititor;
import model.Imprumut;
import service.audit.AuditService;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class WritingMethod {
    private  String path ;
    private static WritingMethod instance;


    private WritingMethod(String path) {
        this.path = path;
    }

    public static synchronized WritingMethod getInstance(String path) {

        if (instance == null) {
            instance = new WritingMethod(path);
        }
        return instance;
    }


    public void  write(Object obj){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path,true))) {
            switch (path){
                case "C:\\Users\\vasilescuandrei1996\\IdeaProjects\\Proiect\\src\\files\\CarteFileOut.csv":{
                    Carte carte = ((Carte) obj);
                    writer.write(""  + carte.getId()+ ", " + carte.getTitlu() + ", " + carte.getAutor().getId() +
                            ", " + carte.getAutor().getNume()+ ", " + carte.getAutor().getPrenume()+ ", " +
                            carte.getAutor().getSex()+", "+ carte.getAutor().getDataNastere()+", "+ carte.getAutor().getPerioada()+
                            ", "+carte.getAutor().getDataDeces()+", " + carte.getEditura().getId() + ", " +carte.getEditura().getDenumire()+", "
                            +carte.getEditura().getDataInfiintare()+", "+carte.getDataPublicare()+", "+carte.getSectiune().getNumeSectiune()
                            +", "+carte.getSectiune().getIdSectiune());
                    writer.write("\n");

                    AuditService auditService = new AuditService("Scriere_carte");
                    auditService.WriteAuditService();

                    break;
                }
                case "C:\\Users\\vasilescuandrei1996\\IdeaProjects\\Proiect\\src\\files\\CititorFileOut.csv":{
                    Cititor cititor = (Cititor) obj;
                    writer.write(cititor.getId()+", "+cititor.getNume()+", "+cititor.getPrenume()+", "+cititor.getSex()+", "+ cititor.getDataNastere());
                    writer.write("\n");

                    AuditService auditService = new AuditService("Scriere_citior");
                    auditService.WriteAuditService();
                    break;


                }

                case "C:\\Users\\vasilescuandrei1996\\IdeaProjects\\Proiect\\src\\files\\ImprumutFileOut.csv":{
                    Imprumut imprumut = (Imprumut) obj;
                    writer.write(imprumut.getIdImprumut()+", "+ imprumut.getCititor().getId()+", " + imprumut.getCititor().getNume()+
                            ", "+imprumut.getCititor().getPrenume()+", "+ imprumut.getCititor().getSex()+", " + imprumut.getCititor().getDataNastere()+
                            ", "+imprumut.getCarte().getId()+", "+imprumut.getCarte().getTitlu()+", "+imprumut.getCarte().getAutor().getId()+", "+
                            imprumut.getCarte().getAutor().getNume()+", "+ imprumut.getCarte().getAutor().getPrenume()+", "+imprumut.getCarte().getAutor().getSex()+
                            ", "+ imprumut.getCarte().getAutor().getDataNastere()+", "+imprumut.getCarte().getAutor().getPerioada()+", "+
                            imprumut.getCarte().getAutor().getDataDeces()+", "+ imprumut.getCarte().getEditura().getId() + ", "  + imprumut.getCarte().getEditura().getDenumire()+", "+
                            imprumut.getCarte().getEditura().getDataInfiintare()+", "+imprumut.getCarte().getDataPublicare()+", "+
                            imprumut.getCarte().getSectiune().getNumeSectiune()+", "+imprumut.getCarte().getSectiune().getIdSectiune());
                    writer.write("\n");

                    AuditService auditService = new AuditService("Scriere_imprumut");
                    auditService.WriteAuditService();

                    break;
                }

                case "C:\\Users\\vasilescuandrei1996\\IdeaProjects\\Proiect\\src\\files\\AutorFileOut.csv":{
                    Autor autor = (Autor) obj;
                    writer.write(autor.getId()+", "+autor.getNume()+", "+ autor.getPrenume()+", "+ autor.getSex()+", "+ autor.getDataNastere()+", "+
                            autor.getPerioada()+", "+ autor.getDataDeces());
                    writer.write("\n");

                    AuditService auditService = new AuditService("Scriere_autor");
                    auditService.WriteAuditService();
                }
            }





        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
