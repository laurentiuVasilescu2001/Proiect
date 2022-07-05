package repository;

import config.DatabaseConfiguration;
import model.*;

import java.sql.*;
import java.util.Optional;

public class SectiuneRepository {
    public void insert(Sectiune sectiune)   {
        String insertPersonSql = "INSERT INTO sectiune VALUES(null, ?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertPersonSql);
            preparedStatement.setString(1,sectiune.getNumeSectiune());
            preparedStatement.execute();
        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }

    public void updateNumeSectiune(String nume, int idSectiune){
        String updateNameSql = "UPDATE sectiune SET nume=? WHERE id_sectiune=?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql);
            preparedStatement.setString(1,nume);
            preparedStatement.setInt(2, idSectiune);
            preparedStatement.executeUpdate();
        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }

    public void deleteSectiune(int id){
        String deleteImprumutSql = "DELETE FROM sectiune WHERE id_sectiune =?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(deleteImprumutSql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Optional<Sectiune> select(int id)   {
        String selectSql = "SELECT * FROM sectiune WHERE id_sectiune = ?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToSectiune(resultSet);
        } catch (SQLException e)    {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private Optional<Sectiune> mapToSectiune(ResultSet resultSet) throws SQLException  {
        if(resultSet.next())    {

            int id_sectiune = resultSet.getInt(1);
            String nume_sectiune = resultSet.getString(2);
            return Optional.of(new Sectiune(nume_sectiune,id_sectiune));


        }
        return Optional.empty();
    }
}