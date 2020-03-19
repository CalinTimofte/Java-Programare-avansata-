import java.util.ArrayList;
import java.util.List;

public class Resident implements Comparable<Resident> {
    private String name;
//    private List<Hospital> hospitalPrefference = new ArrayList<Hospital>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Resident(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Resident o) {
        if (o == null)
            throw new NullPointerException();
        if (!(o instanceof Resident))
            throw new ClassCastException("Uncomparable objects!");
        return this.name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "Resident{" +
                "name='" + name + '\'' +
                '}';
    }
}
