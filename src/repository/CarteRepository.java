package repository;

import config.DatabaseConfiguration;
import model.*;

import java.sql.*;
import java.util.Optional;

public class CarteRepository {
    public void insert(Carte carte)   {
        String insertPersonSql = "INSERT INTO carte VALUES(null, ?, ?, ?, ?, ?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertPersonSql);
            preparedStatement.setString(1, carte.getTitlu());
            preparedStatement.setInt(2, carte.getAutor().getId());
            preparedStatement.setInt(3,carte.getEditura().getId());
            preparedStatement.setString(4,carte.getDataPublicare().toString());
            preparedStatement.setInt(5,carte.getSectiune().getIdSectiune());

            preparedStatement.execute();
        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }

    public void updateTitlu(String titlu, int id){
        String updateNameSql = "UPDATE carte SET titlu=? WHERE id=?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql);
            preparedStatement.setString(1,titlu);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }

    public void updateAutor(int id_autor, int id){
        String updateNameSql = "UPDATE carte SET id_autor=? WHERE id=?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql);
            preparedStatement.setInt(1,id_autor);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }
    public void updateEditura(int id_editura, int id){
        String updateNameSql = "UPDATE carte SET id_editura=? WHERE id=?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql);
            preparedStatement.setInt(1,id_editura);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }
    public void updateSectiune(int id_sectiune, int id){
        String updateNameSql = "UPDATE carte SET id_sectiune=? WHERE id=?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql);
            preparedStatement.setInt(1,id_sectiune);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }

    public void deleteCarte(int id){
        String deleteCarteSql = "DELETE FROM carte WHERE id =?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(deleteCarteSql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void select(int id){
        String selectCarteSql = "SELECT * FROM CARTE WHERE id = ?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectCarteSql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            mapToCarte(resultSet);
        } catch (SQLException e)    {
            e.printStackTrace();
        }


    }

    private void mapToCarte(ResultSet resultSet) throws SQLException  {
        if(resultSet.next())    {
            int id = resultSet.getInt(1);
            String titlu =resultSet.getString(2);
            int id_autor = resultSet.getInt(3);
            int id_editura =resultSet.getInt(4);
            String dataSTring = resultSet.getString(5);
            int id_sectiune = resultSet.getInt(6);

            System.out.println("carte: " + "id=" + id +" titlu=" +titlu + " id_autor=" + id_autor + " id_editura=" + id_editura + " data_publicare=" + dataSTring + " id_sectiune=" + id_sectiune );
        }

    }

}
