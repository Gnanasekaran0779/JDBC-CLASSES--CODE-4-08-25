import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.util.Scanner;

public class Appcreate{
    public static void main(String[] args){
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/sample";// change 'your_database'
        String user = "root";// change to your mysql username
        String password ="root";//change to your
        String sql = "CREATE TABLE IF NOT EXISTS STUDENT ("+
                     "MOBILE NUMBER INT,"+
                     "NAME VARCHAR(100) NOT NULL," +
                     "VALUE VARCHAR(100)" +
                     ")";
        //connect and execute
        try (connection conn = DriverManager)