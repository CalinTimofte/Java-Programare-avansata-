import java.util.ArrayList;
import java.util.List;

public class Hospital implements Comparable<Hospital> {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //    private List<Resident> residentPrefference = new ArrayList<Resident>();

    public Hospital(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(Hospital o) {
        if (o == null)
            throw new NullPointerException();
        if (!(o instanceof Hospital))
            throw new ClassCastException("Uncomparable objects!");
        return this.name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "name='" + name + '\'' +
                '}';
    }
}
