package info.uaic.ro.programare_avansata.lab7;

import java.util.LinkedList;
import java.util.List;

public class Board {
    private List<Token> tokenList = new LinkedList<Token>();

    public Board(int n) {
        for (int i = 1; i <= n; i++) {
            tokenList.add(new Token(i));
        }
    }

    public boolean extract(int tokenNumber) {
        for (int i = 0; i < tokenList.size(); i++) {
            if (tokenList.get(i).getNumber() == tokenNumber) {
                tokenList.remove(i);
                return true;
            }
        }
        return false;
    }
}
