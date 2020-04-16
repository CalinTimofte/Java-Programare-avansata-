package info.uaic.ro.programare_avansata.lab8.dao;

import info.uaic.ro.programare_avansata.lab8.connection.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ArtistController {
    public void create(String name, String country) {
        String querry = "INSERT INTO artists (name, country) VALUES (" + "'" + name + "'" + ", " + "'" + country + "'" + ")";
        try {
            Statement stmt = Database.getConn().createStatement();
            stmt.execute(querry);
        } catch (SQLException e) {
            System.err.println("Insert into artists failed.");
        }
    }

    public int findByName(String name) {
        int return_id = 0;
        String querry = "SELECT id FROM artists WHERE name = " + "'" + name + "'" + ";";
        try {
            Statement stmt = Database.getConn().createStatement();
            ResultSet rs = stmt.executeQuery(querry);
            rs.next();
            return_id = rs.getInt("id");
        } catch (SQLException e) {
            System.err.println("Artist can't be found");
        }
        return return_id;
    }

    public void showArtistInfo(int id) {
        String name = "";
        String country = "";
        String querry = "SELECT name, country FROM artists WHERE id = " + "'" + id + "'" + ";";
        try {
            Statement stmt = Database.getConn().createStatement();
            ResultSet rs = stmt.executeQuery(querry);
            rs.next();
            name = rs.getString("name");
            country = rs.getString("country");
        } catch (SQLException e) {
            System.err.println("Specified artist id is invalid.");
        }
        System.out.println(name + " " + country);
    }

    public ArtistController() {
        Database db = new Database();
    }
}
