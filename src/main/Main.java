package main;
import config.DatabaseMethods;
import model.*;
import repository.*;

import java.io.IOException;
import java.util.ArrayList;

import service.*;
import service.carti.AutorFilter;
import service.carti.CartiService;
import service.carti.EdituraFilter;
import service.imprumuturi.ImprumutService;
import service.imprumuturi.TitluFilter;

public class Main {
    public static void main(String[] args) throws IOException {

        // 1-12 actiuni ce se pot face in cadrul sistemului
        //Obiecte: Persoana(Autor, Cititor) , Carte, Editura, Data, Sectiune, Imprumut
        //Enum:Sex, Perioada

        String sex = new String("M");
        Autor autor = new Autor(1,"Eminescu", "Mihai", Sex.M, new Data(13, 1, 1813), Perioada.CLASICA, new Data(13, 2, 1850));
        Autor autor2 = new Autor(2,"Creanga", "Ion", Sex.M, new Data(7, 4, 1823), Perioada.CLASICA, new Data(25, 8, 1877));
        Autor autor3 = new Autor(3,"Blandiana", "Ana", Sex.F, new Data(10, 2, 1800), Perioada.CLASICA, new Data(22, 10, 1861));
        Autor autor4 = new Autor(4,"Preda", "Marin", Sex.M, new Data(12, 5, 1900), Perioada.POSTBELICA, new Data(30, 6, 1960));


        Editura editura = new Editura(1,"Litera", new Data(20, 4, 2000));
        Editura editura2 = new Editura(2,"Paralela", new Data(10, 8, 2006));
        Editura editura3 = new Editura(3,"Corint", new Data(14, 2, 2001));

        Sectiune sectiune1 = new Sectiune("Carti clasice", 1);
        Sectiune sectiune2 = new Sectiune("Carti poezii", 2);
        Sectiune sectiune3 = new Sectiune("Romane", 3);

        Carte carte = new Carte(1,"Luceafarul", autor, editura, new Data(12, 12, 2005), sectiune2);
        //Carte carte2 = new Carte(2,"Amintiri din copilarie", autor2, editura2, new Data(13, 12, 2005), sectiune1);
        Carte carte3 = new Carte(3,"Morometii", autor4, editura, new Data(13, 12, 2005), sectiune3);
       // Carte carte4 = new Carte(4,"Departe de casa", autor3, editura, new Data(13, 12, 2005), sectiune2);
        //Carte carte5 = new Carte(5,"Floare Albastra", autor, editura3, new Data(20, 5, 2010), sectiune2);
        //Carte carte6 = new Carte(6,"Patul lui Procust", autor4, editura2, new Data(11, 2, 2015), sectiune1);
       // Carte carte7 = new Carte(7,"Povestea lui Harap Alb", autor2, editura2, new Data(27, 10, 2005), sectiune1);
        //Carte carte8 = new Carte(8,"Mandrie si prejudecata", autor3, editura, new Data(7, 9, 2004), sectiune3);
        Carte carte9 =new Carte(9,"Larry",autor4,editura2,new Data(5,9,1999),sectiune3);


        //DatabaseMethods databaseMethods = new DatabaseMethods();
        //databaseMethods.createCarteTable();
       // databaseMethods.createAutorTable();
       // databaseMethods.createEdituraTable();
        //databaseMethods.createCititorTable();
       // databaseMethods.createImprumutTable();
        //databaseMethods.createSectiuneTable();

        CarteRepository carteRepository = new CarteRepository();
        carteRepository.insert(carte9);
        //carteRepository.updateTitlu("Floareee Albastra",1);
        //carteRepository.updateAutor(2,1);
        //carteRepository.updateEditura(2,1);
        //carteRepository.updateSectiune(3,1);
        //carteRepository.deleteCarte(3);
        //carteRepository.select(2);

        //AutorRepository autorRepository = new AutorRepository();
        //autorRepository.insert(autor4);
        //autorRepository.updateNume("Bacovia",1);
        //autorRepository.updatePrenume("Laurentiu",1);
        //autorRepository.deleteAutor(2);
        //System.out.println(autorRepository.select(3));


       //EdituraRepository edituraRepository = new EdituraRepository();
        //edituraRepository.insert(editura3);
        //edituraRepository.updateDenumire("Flamingo",1);
        //edituraRepository.deleteEditura(2);
        //System.out.println(edituraRepository.select(1));


        //SectiuneRepository sectiuneRepository = new SectiuneRepository();
        //sectiuneRepository.insert(sectiune2);
        //sectiuneRepository.updateNumeSectiune("Romane",1);
        //sectiuneRepository.deleteSectiune(1);
        //System.out.println(sectiuneRepository.select(2));



        CartiService bookService = new CartiService();
        //1
        bookService.AddCarte(carte);
        //bookService.AddCarte(carte2);
        bookService.AddCarte(carte3);
        //bookService.AddCarte(carte4);
        //bookService.AddCarte(carte5);
       // bookService.AddCarte(carte6);
       // bookService.AddCarte(carte7);
       // bookService.AddCarte(carte8);
        bookService.AddCarte(carte9);
        //System.out.println(bookService);

        //2
        //bookService.informatiiCarte("Luceafarul");

        //3
        //ArrayList<Carte> cartiFiltrateEdiura = bookService.filter(new EdituraFilter(), "Paralela");
        //System.out.println(cartiFiltrateEdiura);

        //4
        //ArrayList<Carte> cartiFiltrateAutor = bookService.filter(new AutorFilter(),"Eminescu");
        //System.out.println(cartiFiltrateAutor);

        //5
        //bookService.SortareByDataPublicarii();
        //System.out.println(bookService);

        //6
        //bookService.SortareByAutorAndTitlu();
        //System.out.println(bookService);


        //7
        //bookService.DeleteCarteById(3);
        //System.out.println(bookService);

        //8
        //bookService.UpdateCarte(1,carte9);
        //System.out.println(bookService);

        Cititor cititor1 = new Cititor(1, "Vasilescu" , "Laurentu", Sex.M,new Data(13, 12, 2005));
        Cititor cititor2 = new Cititor(2, "Vasilescu" , "Laurentu", Sex.M,new Data(3, 10, 2003));
        Cititor cititor3 = new Cititor(3, "Vasilescu" , "Laurentu", Sex.M,new Data(1, 2, 2001));
        Cititor cititor4 = new Cititor(4, "Vasilescu" , "Laurentu", Sex.M,new Data(5, 1, 2002));

        CititorRepository cititorRepository = new CititorRepository();
        //cititorRepository.insert(cititor1);
        //cititorRepository.updateNume("Patru",1);
        //cititorRepository.updatePrenume("Bogdan",1);
        //cititorRepository.deleteCititor(1);
        //System.out.println(cititorRepository.select(1));

        Imprumut imprumut = new Imprumut(1,cititor1,carte);
        Imprumut imprumut2 = new Imprumut(2,cititor2,carte3);
        Imprumut imprumut3 = new Imprumut(3,cititor1,carte9);

        ImprumutRepository imprumutRepository = new ImprumutRepository();
        //imprumutRepository.insert(imprumut2);
        //imprumutRepository.deleteImprumut(4);
        //imprumutRepository.select(2);




        ImprumutService imprumutService = new ImprumutService();
        //9
        imprumutService.AddImprumut(imprumut);
        imprumutService.AddImprumut(imprumut2);
        imprumutService.AddImprumut(imprumut3);
        //System.out.println(imprumutService);

        //10
        //ArrayList<Imprumut> imprumuturiFiltrate = imprumutService.filter( new TitluFilter(),"Luceafarul");
        //System.out.println(imprumuturiFiltrate);

        //11
        //ArrayList<Imprumut> imprumuturiFiltrate2 = imprumutService.filter(new CititorFilter(),new Integer(1));
        //System.out.println(imprumuturiFiltrate2);

        //12
        //imprumutService.DeleteImprumut(3);
        //System.out.println(imprumutService);


        //ReadingCarteMethod reader = ReadingCarteMethod.getInstance();
        //ArrayList<Carte> carti = reader.read();
        //System.out.println(carti);

       //WritingMethod writer =  WritingMethod.getInstance("C:\\Users\\vasilescuandrei1996\\IdeaProjects\\Proiect\\src\\files\\CarteFileOut.csv");
       //writer.write(carte);

        //WritingMethod writer2 = WritingMethod.getInstance("C:\\Users\\vasilescuandrei1996\\IdeaProjects\\Proiect\\src\\files\\CititorFileOut.csv");
        //writer2.write(cititor1);

        //ReadingCititorMethod reader3 = ReadingCititorMethod.getInstance();
        //ArrayList<Cititor> cititori = reader3.read();
        //System.out.println(cititori);

        //ReadingImprumutMethod reader4 = ReadingImprumutMethod.getInstance();
        //ArrayList<Imprumut> imprumuturi = reader4.read();
        //System.out.println(imprumuturi);

        //ReadingAutorMethod reader2 = ReadingAutorMethod.getInstance();
        //ArrayList<Autor> autori = reader2.read();
        //System.out.println(autori);

        //WritingMethod writer3 = WritingMethod.getInstance("C:\\Users\\vasilescuandrei1996\\IdeaProjects\\Proiect\\src\\files\\ImprumutFileOut.csv");
        //writer3.write(imprumut);

        //WritingMethod writerAutor = WritingMethod.getInstance("C:\\Users\\vasilescuandrei1996\\IdeaProjects\\Proiect\\src\\files\\AutorFileOut.csv");
        //writerAutor.write(autor);



        //CartiService bookservice = new CartiService();

        ///for (Carte carte : carti){
           // writer.write(carte);
        //}


        //writer2.write(cititor2);






    }

}
