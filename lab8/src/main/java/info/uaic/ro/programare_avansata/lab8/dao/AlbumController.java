package info.uaic.ro.programare_avansata.lab8.dao;

import info.uaic.ro.programare_avansata.lab8.connection.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AlbumController {
    public void create(String name, int artistId, int releaseYear) {
        String querry = "INSERT INTO albums (name, artist_id, release_year) VALUES (" + "'" + name + "'" + ", "
                + "'" + artistId + "'" + ", " + "'" + releaseYear + "'" + ")";
        try {
            Statement stmt = Database.getConn().createStatement();
            stmt.execute(querry);
        } catch (SQLException e) {
            System.err.println("Insert into albums failed.");
        }
    }

    public void findByArtist(int id) {
        String name;
        int releaseYear;
        String querry = "SELECT name, release_year FROM albums WHERE artist_id = " + "'" + id + "'" + ";";
        try {
            Statement stmt = Database.getConn().createStatement();
            ResultSet rs = stmt.executeQuery(querry);
            while (rs.next()) {
                name = rs.getString("name");
                releaseYear = rs.getInt("release_year");
                System.out.println("Album: " + name + ", released in: " + releaseYear);
            }
        } catch (SQLException e) {
            System.err.println("Specified artist id is invalid.");
        }
    }

    public AlbumController() {
        Database db = new Database();
    }

}
