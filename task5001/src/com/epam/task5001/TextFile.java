package com.epam.task5001;

//Задача 1.
//Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать,
//вывести на консоль содержимое, дополнить, удалить.


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextFile {

    private Path file;


    public TextFile(Path directory, String name) {
        if (!name.matches("(.*)([\"*|?/:<>\\\\])(.*)")) {
            name = name.replaceAll("\s+$", "");
            name = name + ".txt";
            file = Path.of(directory.toString() + "/" + name);
        } else throw new IllegalArgumentException("The file name must not contain the following characters:" +
                " \\/\"*|?:<>");
    }

    public void create() throws IOException {
        if (Files.notExists(file.getParent())) Files.createDirectories(file.getParent());
        Files.createFile(file);
    }

    public void rename(String newName) throws IOException {
        if (file.toString().endsWith(newName + ".txt")) return;
        if (Files.notExists(file)) {
            file = Path.of(file.getParent() + "/" + newName + ".txt");
            return;
        }

        if (!newName.matches("(.*)([\"*|?/:<>\\\\])(.*)")) {
            Path newPath = Path.of(file.getParent() + "/" + newName.replaceAll("\s+$", "") + ".txt");
            if (Files.notExists(newPath)) {
                try {
                    file = Files.move(file, newPath);
                } catch (IOException exception) {
                    throw new IOException("The file not renamed!" + exception);
                }
            }
        } else
            throw new IllegalArgumentException("The file not renamed! As the file name " + newName + " contains the following characters");

    }

    public void printContent() throws IOException {
        try (BufferedReader bufferedReader = Files.newBufferedReader(file)) {
            while (bufferedReader.ready()) {
                System.out.println(bufferedReader.readLine());
            }

        } catch (IOException exception) {
            throw new IOException("An exception occurred while outputting a file! \t" + exception);
        }
    }

    public void add(String newContent) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file.toFile(), true)))) {
            bw.write(newContent);
        } catch (IOException e) {
            throw new IOException("New context not added to file!" + e);
        }
    }

    public void delete() throws IOException {
        Files.deleteIfExists(file);
    }
}
