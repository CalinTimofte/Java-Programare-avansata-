import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        //fakerul ce va fi folosit pt a genera nume
        Faker faker = new Faker();

        //generez rezidentii cu un stream
        Resident[] r = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Resident(faker.name().fullName()))
                .toArray(Resident[]::new);

        //rezidentii sunt memorati intr-un arraylist si dupa sunt sortati
        List<Resident> residents = new ArrayList<Resident>(Arrays.asList(r));
        Collections.sort(residents);

        //generez spitalele cu un stream, numele vor fi adrese
        Hospital[] h = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Hospital(faker.address().streetAddress()) )
                .toArray(Hospital[]::new);

        //retin spitalele intr-un treeset
        Set<Hospital> hospitals = new TreeSet<Hospital>(Arrays.asList(h));

        //hashmap cu preferintele rezidentilor
        Map<Resident, List<Hospital>> resPrefMap = new HashMap<>();
        resPrefMap.put(r[0], Arrays.asList(h[0], h[1], h[2]));
        resPrefMap.put(r[1], Arrays.asList(h[0], h[1], h[2]));
        resPrefMap.put(r[2], Arrays.asList(h[0], h[1]));
        resPrefMap.put(r[3], Arrays.asList(h[0], h[2]));

        //treemap cu preferintele spitalelor
        Map<Hospital, List<Resident>> hospitalPrefMap = new TreeMap<>();
        hospitalPrefMap.put(h[0], Arrays.asList(r[3], r[0], r[1], r[2]));
        hospitalPrefMap.put(h[1], Arrays.asList(r[0], r[2], r[1]));
        hospitalPrefMap.put(h[2], Arrays.asList(r[0], r[1], r[3]));

        //afisare preferinte
        System.out.println(resPrefMap);
        System.out.println(hospitalPrefMap);

        //filtrare rezidenti, aleg doar cei ce prefera h0 si h2
        List<Hospital> target = Arrays.asList(h[0], h[2]);
        List<Resident> result = residents.stream()
                .filter(res -> resPrefMap.get(res).containsAll(target))
                .collect(Collectors.toList());
        System.out.println(result);

        //filtrare spitale, printare spitale ce prefera r0
        hospitals.stream()
                .filter(hos -> hospitalPrefMap.get(hos).contains(r[0]))
                .forEach(System.out::println);
    }
}
