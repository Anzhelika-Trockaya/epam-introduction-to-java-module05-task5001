package by.epam.task5001.logic;

import by.epam.task5001.file.Directory;

import java.io.IOException;
import java.nio.file.Files;

public class DirectoryLogic {
    public static void create(Directory directory) throws IOException {
        Files.createDirectories(directory.getPath());
    }

    public static boolean notExists(Directory directory) {
        return Files.notExists(directory.getPath());
    }
}
