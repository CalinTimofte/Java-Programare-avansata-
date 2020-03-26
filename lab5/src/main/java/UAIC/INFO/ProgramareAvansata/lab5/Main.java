package UAIC.INFO.ProgramareAvansata.lab5;

import java.io.IOException;

public class Main {
    public static void main(String args[]) {
        Main app = new Main();
        app.testCreateSave();
//        app.testLoadView();
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
        }
        catch (IOException e){
            System.out.println("The catalog can't be saved");
            System.out.println(e);
        }
    }

//    private void testLoadView() {
//        Catalog catalog =
//                CatalogUtil.load("d:/java/catalog.ser");
//        Document doc =
//                catalog.findById("java1");
//        CatalogUtil.view(doc);
//    }
}
