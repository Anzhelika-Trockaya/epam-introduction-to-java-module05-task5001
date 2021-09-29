package by.epam.task5001.file;

public class FileException extends Exception {
    public FileException(String message) {
        super(message);
    }

    public FileException(Exception exception) {
        super(exception);
    }

    public FileException(String message, Exception exception) {
        super(message, exception);
    }

    public FileException() {
        super();
    }
}
