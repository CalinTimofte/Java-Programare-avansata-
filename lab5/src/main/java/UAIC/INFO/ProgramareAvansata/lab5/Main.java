package UAIC.INFO.ProgramareAvansata.lab5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String args[]) {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() {
        Catalog catalog =
                new Catalog("Java Resources", "D:/Work/JavaResources/catalog.txt");
        Document doc =
                new Document("java1", "Java Course 1",
                        "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        doc.addTag("type", "Slides");
        catalog.add(doc);
        try {
            CatalogUtil.save(catalog);
        } catch (IOException e) {
            System.out.println("The catalog can't be saved");
            System.out.println(e);
        }
    }

    private void testLoadView() {
        try {
            Catalog catalog = CatalogUtil.load("D:/Work/JavaResources/catalog.txt");
            Document doc =
                    catalog.findById("java1");
            CatalogUtil.view(doc);
        } catch (InvalidCatalogException | URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}
