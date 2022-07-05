package config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseMethods {

    public void createCarteTable()   {
        String createTableSql = "CREATE TABLE IF NOT EXISTS carte" +
                "(id int PRIMARY KEY AUTO_INCREMENT,titlu varchar(40),id_autor int,id_editura int,data_publicare varchar(10), id_sectiune int)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void createAutorTable(){
        String createTableSql = "CREATE TABLE IF NOT EXISTS autor"+
                                "(id int PRIMARY KEY AUTO_INCREMENT, nume varchar(20), prenume varchar(20), sex varchar(1), data_nastere varchar(10), perioada varchar(20) , data_deces varchar(10))";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void createEdituraTable(){
        String createTableSql = "CREATE TABLE IF NOT EXISTS editura"+
                                "(id int PRIMARY KEY AUTO_INCREMENT, denumire varchar(20), data_infiintare varchar(10))";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void createCititorTable(){
        String createTableSql = "CREATE TABLE IF NOT EXISTS cititor"+
                                "(id int PRIMARY KEY AUTO_INCREMENT, nume varchar(20), prenume varchar(20), sex varchar(1), data_nastere varchar(10))";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void createImprumutTable(){
        String createTableSql = "CREATE TABLE IF NOT EXISTS imprumut"+
                                "(id_imprumut int PRIMARY KEY AUTO_INCREMENT, id_cititor int, id_carte int)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void createSectiuneTable(){
        String createTableSql = "CREATE TABLE IF NOT EXISTS sectiune"+
                "(id_sectiune int PRIMARY KEY AUTO_INCREMENT, nume varchar(20))";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
