package UAIC.INFO.ProgramareAvansata.lab5;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private String name;
    private String path;
    private List<Document> documents = new ArrayList<Document>();

    public Catalog(String name, String path) {
        this.name = new String(name);
        this.path = new String(path);
    }

    public void add(Document doc) {
        documents.add(doc);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
