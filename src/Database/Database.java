package Database;

import java.sql.*;
import java.util.Properties;
import java.util.Vector;

public class Database {
    private String DRIVER_CLASS;
    private String DB_URL;

    public Database(Properties p){
        this.DB_URL = p.getProperty("DB_URL");
        this.DRIVER_CLASS = p.getProperty("DRIVER_CLASS");
    }

    public  Connection getConnection(){
        Connection con = null;
        try {
            Class.forName(DRIVER_CLASS);
            con = DriverManager.getConnection(DB_URL);
        }
        catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }

    public void updateScore(int n){
        String sql = "UPDATE scores SET Highest_Score = ? ";
        try (
                Connection con = this.getConnection();
                PreparedStatement stt = con.prepareStatement(sql);
        )
        {
            // set value to ? in statement
            stt.setInt(1,  n);
            // update
            stt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public int  getScore(){
        String sql = "SELECT Highest_Score FROM scores";
        try (
                Connection con = this.getConnection();
                PreparedStatement stt = con.prepareStatement(sql)
        )
        {
            // Save result to rs
            ResultSet rs = stt.executeQuery();
            return rs.getInt(1);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public Vector<Vector<Integer>> getLevels(){
        Vector<Vector<Integer>> tempLevels= new Vector<>();
        Vector<Integer> tempObjects;

        String sql  = "SELECT * FROM levels";
        try (
            Connection con = this.getConnection();
            PreparedStatement stt = con.prepareStatement(sql)
        )
        {
            // Save result to rs
            ResultSet rs = stt.executeQuery();
            while(rs.next()){
                tempObjects = new Vector<>();
                tempObjects.add(rs.getInt(2));
                tempObjects.add(rs.getInt(3));
                tempObjects.add(rs.getInt(4));
                tempObjects.add(rs.getInt(5));
                tempObjects.add(rs.getInt(6));

                tempLevels.add(tempObjects);
            }
            return tempLevels;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tempLevels;
    }
}
