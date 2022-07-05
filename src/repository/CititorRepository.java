package repository;

import config.DatabaseConfiguration;
import model.*;

import java.sql.*;
import java.util.Optional;

public class CititorRepository {
    public void insert(Cititor cititor)   {
        String insertPersonSql = "INSERT INTO cititor VALUES(null, ?, ?, ?, ?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertPersonSql);
            preparedStatement.setString(1, cititor.getNume() );
            preparedStatement.setString(2, cititor.getPrenume());
            preparedStatement.setString(3,cititor.getSex().toString());
            preparedStatement.setString(4,cititor.getDataNastere().toString());
            preparedStatement.execute();
        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }

    public void updateNume(String nume, int id) {
        String updateNameSql = "UPDATE cititor SET nume=? WHERE id=?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql);
            preparedStatement.setString(1,nume);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }

    public void updatePrenume(String prenume, int id) {
        String updateNameSql = "UPDATE cititor SET prenume=? WHERE id=?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql);
            preparedStatement.setString(1,prenume);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }

    public void deleteCititor(int id){
        String deleteCititorSql = "DELETE FROM cititor WHERE id =?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(deleteCititorSql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Optional<Cititor> select(int id)   {
        String selectSql = "SELECT * FROM cititor  WHERE id = ?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToCititor(resultSet);
        } catch (SQLException e)    {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private Optional<Cititor> mapToCititor(ResultSet resultSet) throws SQLException  {
        if(resultSet.next())    {
            int id = resultSet.getInt(1);
            String nume = resultSet.getString(2);
            String prenume = resultSet.getString(3);
            String sexx = resultSet.getString(4);
            Sex sex;
            if(sexx.equals("M"))
                sex = Sex.M;
            else sex = Sex.F;
            String dataSTring = resultSet.getString(5);
            String[] componenteDataNastere = dataSTring.split("/");
            Data dataNastere = new Data(Integer.parseInt(componenteDataNastere[0]),Integer.parseInt(componenteDataNastere[1]),Integer.parseInt(componenteDataNastere[2]));



            return Optional.of(new Cititor(id,nume,prenume,sex,dataNastere));
        }
        return Optional.empty();
    }
}