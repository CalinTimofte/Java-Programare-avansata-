package UAIC.INFO.ProgramareAvansata.lab5;

import java.io.*;

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
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))){
            Catalog returnCatalog = new Catalog(ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void view(Document doc) {
        Desktop desktop = Desktop.getDesktop();
        //… browse or open, depending of the location type
    }
}
}
