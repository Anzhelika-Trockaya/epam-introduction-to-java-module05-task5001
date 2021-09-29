package by.epam.task5001.logic;

import by.epam.task5001.file.FileException;
import by.epam.task5001.file.TextFile;

import java.io.*;

public class TextFileLogic extends FileLogic {

    public static void rename(TextFile textFile, String newName) throws FileException {
        if (newName.endsWith(".txt")) {
            FileLogic.rename(textFile, newName);
        } else {
            throw new IllegalArgumentException("Incorrect TextFile name!");
        }
    }

    public static void printContent(TextFile textFile) throws FileException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(getPath(textFile).toFile()))) {
            while (bufferedReader.ready()) {
                System.out.println(bufferedReader.readLine());
            }
        } catch (IOException exception) {
            throw new FileException("An exception occurred while outputting a file!", exception);
        }
    }

    public static void addContent(TextFile textFile, String newContent) throws FileException {
        if (newContent != null) {
            try (BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(getPath(textFile).toFile(), true)))) {

                bw.write(newContent);
            } catch (IOException e) {
                throw new FileException("New context not added to file!", e);
            }
        }
    }
}
