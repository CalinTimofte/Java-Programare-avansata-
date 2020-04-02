package info.uaic.ro.programare_avansata.lab7;

public class Token {
    private int number;

    public Token(int number) {
        if (number < 1)
            throw new IllegalArgumentException("Number should be greater than 1");
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
