package repository;

import config.DatabaseConfiguration;
import model.*;

import java.sql.*;
import java.util.Optional;

public class ImprumutRepository {
    public void insert(Imprumut imprumut)   {
        String insertPersonSql = "INSERT INTO imprumut VALUES(null, ?, ?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertPersonSql);
            preparedStatement.setInt(1,imprumut.getCititor().getId());
            preparedStatement.setInt(2,imprumut.getCarte().getId());
            preparedStatement.execute();
        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }

    public void deleteImprumut(int id){
        String deleteImprumutSql = "DELETE FROM imprumut WHERE id_imprumut =?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(deleteImprumutSql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Optional<Imprumut> select(int id)   {
        String selectSql = "SELECT * FROM imprumut  WHERE id_imprumut = ?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            mapToImprumut(resultSet);
        } catch (SQLException e)    {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private void mapToImprumut(ResultSet resultSet) throws SQLException  {
        if(resultSet.next())    {
            int id_imprumut = resultSet.getInt(1);
            int id_cititor = resultSet.getInt(2);
            int id_carte = resultSet.getInt(3);
            System.out.println("Imprumut: " + "id_imprumut=" + id_imprumut + " id_cititor=" + id_cititor + " id_carte=" + id_carte);


        }
    }
}