package by.epam.task5001.logic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import by.epam.task5001.file.File;
import by.epam.task5001.file.FileException;

public class FileLogic {
    public static final String FILE_NAME_REGEX = "[^\"*|?/:<>\\\\]+";

    public static Path getPath(File file){
        return Path.of(file.getDirectory().getPath().toString()+"/"+file.getName());
    }

    public static void create(File file) throws FileException {
        if (DirectoryLogic.notExists(file.getDirectory())) {
            DirectoryLogic.create(file.getDirectory());
        }

        try {
            Files.createFile(getPath(file));
        } catch(IOException exception){
            throw new FileException(exception);
        }
    }

    public static void rename(File file, String newName) throws FileException {
        Path newPath;

        if (file.getName().equals(newName)) {
            return;
        }

        if (Files.notExists(getPath(file))) {
            file.setName(newName);
            return;
        }

        if (newName.matches(FILE_NAME_REGEX)) {
            newPath = Path.of(file.getDirectory().getPath().toString() +"/"+ newName);

            if (Files.notExists(newPath)) {
                try {
                    Files.move(getPath(file), newPath);
                    file.setName(newName);
                } catch (IOException exception) {
                    throw new FileException("The file not renamed!" + exception);
                }
            }
        } else {
            throw new FileException("The file not renamed! As the file name " + newName
                    + " contains the following characters");
        }
    }

    public static void deleteIfExists(File file) throws FileException {
        try {
            Files.deleteIfExists(getPath(file));
        } catch(IOException exception){
            throw new FileException(exception);
        }
    }
}
