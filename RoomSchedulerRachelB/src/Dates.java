
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author RachelBrooks
 */
public class Dates {
    private static Connection connection;
    private static ArrayList<String> date = new ArrayList<String>();
    private static PreparedStatement addDate;
    private static PreparedStatement getAllDates;
    private static ResultSet resultSet;
    
    public static void addDate(Date date)
    {
        connection = DBConnection.getConnection();
        try
        {
            addDate = connection.prepareStatement("insert into Dates (date) values (?)");
            addDate.setDate(1, date);
            addDate.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
    
    public static ArrayList<String> getAllDates()
    {
        connection = DBConnection.getConnection();
        ArrayList<String> date = new ArrayList<String>();
        try
        {
            getAllDates = connection.prepareStatement("select date from dates");
            resultSet = getAllDates.executeQuery();
            
            while(resultSet.next())
            {
                date.add(resultSet.getString(1));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return date;
        
    }
    
    
}
