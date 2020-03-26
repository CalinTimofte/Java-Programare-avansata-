package UAIC.INFO.ProgramareAvansata.lab5;

import com.sun.jndi.toolkit.url.Uri;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class CatalogUtil {
    public static void save(Catalog catalog)
            throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }


    public static Catalog load(String path)
            throws InvalidCatalogException, FileNotFoundException {
        Catalog returnCatalog = new Catalog();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            returnCatalog = new Catalog(ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return returnCatalog;
    }

    public static void view(Document doc) throws URISyntaxException, IOException {
        Desktop desktop = Desktop.getDesktop();
        if (doc.getLocation().startsWith("http")) {
            URI myUri = new URI(doc.getLocation());
            desktop.browse(myUri);
        } else if (doc.getLocation().startsWith("https")) {
            URI myUri = new URI(doc.getLocation());
            desktop.browse(myUri);
        } else {
            File file = new File(doc.getLocation());
            desktop.edit(file);
        }
    }
}
