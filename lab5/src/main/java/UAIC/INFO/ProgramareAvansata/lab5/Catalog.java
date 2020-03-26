package UAIC.INFO.ProgramareAvansata.lab5;

import javax.print.Doc;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private String path;
    private List<Document> documents = new ArrayList<Document>();

    public Catalog(){

    }

    public Catalog(String name, String path) {
        this.name = new String(name);
        this.path = new String(path);
    }

    public Catalog(Object readObject) {
        Catalog catalog = (Catalog) readObject;
        this.name = catalog.name;
        this.path = catalog.path;
        this.addAll(catalog);
    }

    public void add(Document doc) {
        documents.add(doc);
    }

    public void addAll(Catalog cat) {
        for (int i = 0; i < cat.documents.size(); i++)
            this.add(cat.documents.get(i));
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

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", documents=" + documents +
                '}';
    }

    public Document findById(String id) {
        return documents.stream()
                .filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }
}
