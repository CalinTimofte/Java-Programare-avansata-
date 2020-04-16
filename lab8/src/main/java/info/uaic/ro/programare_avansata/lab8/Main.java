package info.uaic.ro.programare_avansata.lab8;

import info.uaic.ro.programare_avansata.lab8.connection.Database;
import info.uaic.ro.programare_avansata.lab8.dao.AlbumController;
import info.uaic.ro.programare_avansata.lab8.dao.ArtistController;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        ArtistController artistController = new ArtistController();
        AlbumController albumController = new AlbumController();
        artistController.create("testartist3", "testcountry3");
        artistController.showArtistInfo(artistController.findByName("test3"));
        albumController.create("test_name3", artistController.findByName("test3"), 2020);
        albumController.findByArtist(artistController.findByName("test3"));
    }
}
