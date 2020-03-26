package UAIC.INFO.ProgramareAvansata.lab5;

public class InvalidCatalogException extends Exception {
    public InvalidCatalogException(String message){
        super(message);
    }

    public InvalidCatalogException(Catalog catalog){
        super("Invalid catalog" + catalog);
    }
}
