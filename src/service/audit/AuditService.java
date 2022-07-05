package service.audit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

public class AuditService {
    private String numeActriune;
    private static String path = "C:\\Users\\vasilescuandrei1996\\IdeaProjects\\Proiect\\src\\files\\AuditService.csv";
    private static Timestamp timestamp = new Timestamp(System.currentTimeMillis());


    public AuditService(String numeActriune) {
        this.numeActriune = numeActriune;
    }

    public void WriteAuditService(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path,true))) {
            writer.write(this.numeActriune + ", " + timestamp);
            writer.write("\n");

    } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
