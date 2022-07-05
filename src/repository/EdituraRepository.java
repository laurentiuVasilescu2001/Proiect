package repository;

import config.DatabaseConfiguration;
import model.*;

import java.sql.*;
import java.util.Optional;

public class EdituraRepository {

    public void insert(Editura editura) {
        String insertPersonSql = "INSERT INTO editura VALUES(null, ?, ?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertPersonSql);
            preparedStatement.setString(1, editura.getDenumire());
            preparedStatement.setString(2, editura.getDataInfiintare().toString());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDenumire(String denumire, int id){
        String updateNameSql = "UPDATE editura SET denumire=? WHERE id=?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql);
            preparedStatement.setString(1,denumire);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }

    public void deleteEditura(int id){
        String deleteEdituraSql = "DELETE FROM editura WHERE id =?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(deleteEdituraSql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Optional<Editura> select(int id)   {
        String selectSql = "SELECT * FROM editura  WHERE id = ?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToEditura(resultSet);
        } catch (SQLException e)    {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private Optional<Editura> mapToEditura(ResultSet resultSet) throws SQLException  {
        if(resultSet.next())    {
            int id_editura = resultSet.getInt(1);
            String denumire = resultSet.getString(2);
            String dataSTring = resultSet.getString(3);
            String[] componenteDataInfiintare = dataSTring.split("/");
            Data dataInfiintare = new Data(Integer.parseInt(componenteDataInfiintare[0]),Integer.parseInt(componenteDataInfiintare[1]),Integer.parseInt(componenteDataInfiintare[2]));

            return Optional.of(new Editura(id_editura,denumire,dataInfiintare));


        }
        return Optional.empty();
    }


}