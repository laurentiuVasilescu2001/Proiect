package repository;

import config.DatabaseConfiguration;
import model.*;

import java.sql.*;
import java.util.Optional;

public class AutorRepository {
    public void insert(Autor autor)   {
        String insertPersonSql = "INSERT INTO autor VALUES(null, ?, ?, ?, ?, ?, ?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertPersonSql);
            preparedStatement.setString(1, autor.getNume() );
            preparedStatement.setString(2, autor.getPrenume());
            preparedStatement.setString(3,autor.getSex().toString());
            preparedStatement.setString(4,autor.getDataNastere().toString());
            preparedStatement.setString(5,autor.getPerioada().toString());
            preparedStatement.setString(6,autor.getDataDeces().toString());
            preparedStatement.execute();
        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }

    public void updateNume(String nume, int id) {
        String updateNameSql = "UPDATE autor SET nume=? WHERE id=?";
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
        String updateNameSql = "UPDATE autor SET prenume=? WHERE id=?";
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


    public void deleteAutor(int id){
        String deleteAutorSql = "DELETE FROM autor WHERE id =?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(deleteAutorSql);
           preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Optional<Autor> select(int id)   {
        String selectSql = "SELECT * FROM autor  WHERE id = ?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToAutor(resultSet);
        } catch (SQLException e)    {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private Optional<Autor> mapToAutor(ResultSet resultSet) throws SQLException  {
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
            String perioadaString = resultSet.getString(6);

            Perioada perioada;
            if(perioadaString.equals("POSTBELICA"))
                perioada = Perioada.POSTBELICA;
            else if (perioadaString.equals("ANTEBELICA"))
                perioada = Perioada.ANTEBELICA;
            else if(perioadaString.equals("CLASICA"))
                perioada = Perioada.CLASICA;
            else perioada = Perioada.INTERBELICA;

            String dataSTring2 = resultSet.getString(7);
            String[] componenteDataDeces = dataSTring2.split("/");
            Data dataDeces = new Data(Integer.parseInt(componenteDataDeces[0]),Integer.parseInt(componenteDataDeces[1]),Integer.parseInt(componenteDataDeces[2]));

            return Optional.of(new Autor(id,nume,prenume,sex,dataNastere,perioada,dataDeces));
        }
        return Optional.empty();
    }
}