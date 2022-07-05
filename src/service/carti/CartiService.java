package service.carti;

import model.*;
import service.CarteValidator;
import service.FilterableCarti;
import service.audit.AuditService;

import java.util.ArrayList;

public class CartiService  {
    private ArrayList<Carte> carti;

    public CartiService() {
        this.carti = new ArrayList<Carte>();
    }

    public ArrayList<Carte> filter(FilterableCarti filterable, String name) {

        AuditService auditService = new AuditService("Filtrare_carti");
        auditService.WriteAuditService();

        return filterable.filter(this.carti, name);


    }



    public void AddCarte(Carte carte) {
        CarteValidator carteValidator = new CarteValidator();
        if(carteValidator.validate(carte)) {
            this.carti.add(carte);
        }
        else System.out.println("Carte invalida");

        AuditService auditService = new AuditService("Adaugare_carte");
        auditService.WriteAuditService();
    }


    public void DeleteCarteById(int id){
        for(Carte carte : this.carti){
            if (carte.getId() == id){
                this.carti.remove(carte);
                break;
                }


        }
        AuditService auditService = new AuditService("Stergere_carte");
        auditService.WriteAuditService();
    }


    public void SortareByDataPublicarii(){

        this.carti.sort(new CarteSorterByDataPublicarii());
        AuditService auditService = new AuditService("Sortare_carte_data_publicarii");
        auditService.WriteAuditService();
    }

    public void SortareByAutorAndTitlu(){
        this.carti.sort(new CarteSorterByAutorAndTitlu());
        AuditService auditService = new AuditService("Sortare_carte_autor_titlu");
        auditService.WriteAuditService();
    }

    public void UpdateCarte(int id,Carte carte){
        CarteValidator carteValidator = new CarteValidator();
        for(Carte carteUpdate : this.carti){
            if(carteUpdate.getId() == id && carteValidator.validate(carte)){
                carteUpdate.setTitlu(carte.getTitlu());
                carteUpdate.setAutor(carte.getAutor());
                carteUpdate.setEditura(carte.getEditura());
                carteUpdate.setDataPublicare(carte.getDataPublicare());
                carteUpdate.setSectiune(carte.getSectiune());
                break;
            }

        }
        AuditService auditService = new AuditService("Update_carte");
        auditService.WriteAuditService();
    }

    public void informatiiCarte(String titlu){
        for (Carte carte :this.carti){
            if(carte.getTitlu().equals(titlu) ){
                System.out.println(carte);
                break;
            }
        }
        AuditService auditService = new AuditService("Informatii_carte");
        auditService.WriteAuditService();
    }


    @Override
    public String toString() {
        return "BookService{" +
                "carti=" + carti +
                '}';
    }
}





