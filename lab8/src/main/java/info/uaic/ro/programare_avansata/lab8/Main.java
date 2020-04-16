package info.uaic.ro.programare_avansata.lab8;

import info.uaic.ro.programare_avansata.lab8.connection.Database;
import info.uaic.ro.programare_avansata.lab8.dao.AlbumController;
import info.uaic.ro.programare_avansata.lab8.dao.ArtistController;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
//        Database connection = new Database();
//        try {
//            System.out.println(Database.getConn().getSchema());
//        } catch (SQLException e) {
//            System.err.println(e);
//        }
        ArtistController artistController = new ArtistController();
        AlbumController albumController = new AlbumController();
        artistController.showArtistInfo(artistController.findByName("test2"));
//        albumController.create("test_name2", artistController.findByName("test2"), 2020);
        albumController.findByArtist(artistController.findByName("test2"));
    }
}
