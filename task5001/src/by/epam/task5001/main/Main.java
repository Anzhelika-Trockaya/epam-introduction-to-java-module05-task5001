package by.epam.task5001.main;

//Задача 1.
//Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать,
//вывести на консоль содержимое, дополнить, удалить.

import by.epam.task5001.file.Directory;
import by.epam.task5001.file.FileException;
import by.epam.task5001.file.TextFile;
import by.epam.task5001.logic.TextFileLogic;
import by.epam.task5001.view.View;

import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws FileException {
        String directoryPath;
        Directory directory;
        String fileName;
        TextFile file;
        View view;

        String text1;
        String text2;

        directoryPath = "D:/introduction-to-java/new-directory";
        fileName = "task-5001.txt";
        directory = new Directory(Path.of(directoryPath));
        file = new TextFile(directory, fileName);
        view = new View();

        text1 = """
                M r. and Mrs. Dursley, of number four, Privet Drive, were proud to say
                that they were perfectly normal, thank you very much. They were the last people
                you’d expect to be involved in anything strange or mysterious, because they just
                didn’t hold with such nonsense.
                Mr. Dursley was the director of a firm called Grunnings, which made
                drills. He was a big, beefy man with hardly any neck, although he did have a
                very large mustache. Mrs. Dursley was thin and blonde and had nearly twice the
                usual amount of neck, which came in very useful as she spent so much of her
                small son called Dudley and in their opinion there was no finer boy anywhere.
                """;
        text2 = """
                 The Dursleys had everything they wanted, but they also had a secret, and
                their greatest fear was that somebody would discover it. They didn’t think they
                could bear it if anyone found out about the Potters. Mrs. Potter was Mrs.
                Dursley’s sister, but they hadn’t met for several years; in fact, Mrs. Dursley
                pretended she didn’t have a sister, because her sister and her good-for-nothing
                husband were as unDursleyish as it was possible to be.""";

        view.printToConsole("- Is exist file task-5001.txt? --- " +
                Files.exists(Path.of("D:/introduction-to-java/new-directory/task-5001.txt")));

        TextFileLogic.create(file);

        view.printToConsole("- Created file task-5001.txt.");
        view.printToConsole("- Is exist file task-5001.txt? --- " +
                Files.exists(Path.of("D:/introduction-to-java/new-directory/task-5001.txt")));
        view.printToConsole("- Is exist file Harry Potter.txt? --- " +
                Files.exists(Path.of("D:/introduction-to-java/new-directory/Harry Potter.txt")));

        TextFileLogic.rename(file,"Harry Potter.txt");

        view.printToConsole("- File \"task-5001.txt\" renamed to \"Harry Potter.txt\"");
        view.printToConsole("- Is exist file Harry Potter.txt? --- " +
                Files.exists(Path.of("D:/introduction-to-java/new-directory/Harry Potter.txt")));
        view.printToConsole("- Is exist file task-5001.txt? --- " +
                Files.exists(Path.of("D:/introduction-to-java/new-directory/task-5001.txt")));

        view.printToConsole("- File content:");
        view.printToConsole(TextFileLogic.getContent(file));

        TextFileLogic.addContent(file, text1);
        view.printToConsole("- Added text to file.");
        view.printToConsole("- File content:");
        view.printToConsole(TextFileLogic.getContent(file));

        TextFileLogic.addContent(file, text2);
        view.printToConsole("- Added text to file.");
        view.printToConsole("- File content:");
        view.printToConsole(TextFileLogic.getContent(file));

        TextFileLogic.deleteIfExists(file);
        view.printToConsole("- Deleted file.");
        view.printToConsole("- Is exist file Harry Potter.txt? --- " +
                Files.exists(Path.of("D:/introduction-to-java/new-directory/Harry Potter.txt")));
    }
}
