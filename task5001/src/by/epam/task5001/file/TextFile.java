package by.epam.task5001.file;

//Задача 1.
//Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать,
//вывести на консоль содержимое, дополнить, удалить.

import by.epam.task5001.file.Directory;
import by.epam.task5001.file.File;

import java.io.*;

public class TextFile extends File implements Serializable{

    public TextFile(){
        super();
    }

    public TextFile(Directory directory, String name) {
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