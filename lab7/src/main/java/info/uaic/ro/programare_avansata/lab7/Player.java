package info.uaic.ro.programare_avansata.lab7;

import java.util.LinkedList;
import java.util.List;

public class Player implements Runnable {
    private String name;
    private List<Token> gamePieces = new LinkedList<Token>();

    public Player(String name) {
        this.name = name;
    }

    public void run() {

    }
}
