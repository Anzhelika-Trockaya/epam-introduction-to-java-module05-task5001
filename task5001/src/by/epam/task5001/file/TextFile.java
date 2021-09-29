package by.epam.task5001.file;

//Задача 1.
//Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать,
//вывести на консоль содержимое, дополнить, удалить.

import java.io.*;

public class TextFile extends File implements Serializable {

    public TextFile() throws FileException {
        super(new Directory(), "file.txt");
    }

    public TextFile(Directory directory, String name) throws FileException {
        super(directory, name);

        if (!name.endsWith(".txt")) {
            throw new IllegalArgumentException("Not text file!");
        }
    }


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
