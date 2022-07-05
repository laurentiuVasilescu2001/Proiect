package service.imprumuturi;

import model.*;
import service.FilterableCarti;
import service.FilterableImprumuturi;
import service.audit.AuditService;

import java.util.ArrayList;

public class ImprumutService {
    private ArrayList<Imprumut> imprumuturi;


    public ArrayList<Imprumut> filter(FilterableImprumuturi filterable, String name) {
        AuditService auditService = new AuditService("Filtrare_imprumuturi");
        auditService.WriteAuditService();
        return filterable.filter(this.imprumuturi, name);

    }

    public ArrayList<Imprumut> filter(FilterableImprumuturi filterable, Integer name) {
        AuditService auditService = new AuditService("Filtrare_imprumuturi");
        auditService.WriteAuditService();
        return filterable.filter(this.imprumuturi, name);

    }


    public ImprumutService() {
        this.imprumuturi = new ArrayList<>();
    }

    public void AddImprumut(Imprumut imprumut){
        this.imprumuturi.add(imprumut);
        AuditService auditService = new AuditService("Adaugare_imprumut");
        auditService.WriteAuditService();
    }


    public void DeleteImprumut(int idImprumut){
        for (Imprumut imprumut : imprumuturi){
            if(imprumut.getIdImprumut() == idImprumut){
                this.imprumuturi.remove(imprumut);
                break;
            }
        }
        AuditService auditService = new AuditService("Stergere_imprumut");
        auditService.WriteAuditService();
    }

    public void ListImprumuturi(Cititor cititor){
        System.out.print("Imprumuturi cititor =[");
        for(Imprumut imprumut : imprumuturi){
            if(imprumut.getCititor().getId() == cititor.getId()){
                System.out.print(imprumut);
            }
        }
        System.out.print("]");
        System.out.println();

        AuditService auditService = new AuditService("Listare_imprumuturi");
        auditService.WriteAuditService();
    }

    @Override
    public String toString() {
        return "ImprumutService{" +
                "imprumuturi=" + imprumuturi +
                '}';
    }
}
