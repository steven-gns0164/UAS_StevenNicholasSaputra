package Controller;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.*;

public class Controller {

    static DatabaseHandler conn = new DatabaseHandler();

    
    
    public boolean inputDataToDB(String user_id, String game_id) {
        conn.connect();
        String query = "INSERT INTO transactions (user_id, game_id) VALUES (?, ?)";
        PreparedStatement stmt;
        try {
            stmt = conn.con.prepareStatement(query);
            stmt.setString(1, user_id);
            stmt.setString(2, game_id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

     public int getID(String email) {
        conn.connect();
        String query = "SELECT id FROM users WHERE email = '" + email + "'";
        int id = 0;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                id = (rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (id);
    }

    public static boolean getUser(String email, String password) {
        conn.connect();
        String query = "SELECT * FROM users WHERE email = '" + email + "' AND password = '" + password + "'";
        boolean exists = false;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                exists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return exists;
    }

    public int getIDGames(String name) {
        conn.connect();
        String query = "SELECT id FROM games WHERE name = '" + name + "'";
        int id = 0;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                id = (rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (id);
    }
    
    public boolean getGame(String name, String genre, String price) {
        conn.connect();
        String query = "SELECT * FROM games \n"
                + "WHERE name = '" + name + "' AND genre = '" + genre + "' AND price = '" + price + "'";
        boolean exists = false;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                exists = true;
            }
            return exists;
        } catch (SQLException e) {
            e.printStackTrace();
            return exists;
        }
    }
    public boolean findTR(int user_id, int game_id) {
        conn.connect();
        String query = "SELECT * FROM transactions "
                + "WHERE user_id = '" + user_id + "' AND game_id = '" + game_id + "'";
        boolean exists = false;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                exists = true;
            }
            return exists;
        } catch (SQLException e) {
            e.printStackTrace();
            return exists;
        }
    }
}
