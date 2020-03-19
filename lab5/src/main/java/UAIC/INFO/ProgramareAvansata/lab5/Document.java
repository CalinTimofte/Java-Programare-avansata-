package UAIC.INFO.ProgramareAvansata.lab5;

import java.util.HashMap;
import java.util.Map;

public class Document {
    private String id;

    private String name;

    //file name or Web page
    private String location;

    private Map<String, Object> tags = new HashMap<String, Object>();

    public Document(String id, String name, String location) {
        this.id = new String(id);
        this.name = new String(name);
        this.location = new String(location);
    }

    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }
}
