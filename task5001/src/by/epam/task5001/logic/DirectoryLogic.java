package by.epam.task5001.logic;

import by.epam.task5001.file.Directory;
import by.epam.task5001.file.FileException;

import java.io.IOException;
import java.nio.file.Files;

public class DirectoryLogic {
    public static void create(Directory directory) throws FileException {
        try {
            Files.createDirectories(directory.getPath());
        } catch(IOException exception){
            throw new FileException(exception);
        }
    }

    public static boolean notExists(Directory directory) {
        return Files.notExists(directory.getPath());
    }
}
