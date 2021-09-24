package by.epam.task5001.file;

import java.io.Serializable;
import java.util.Objects;

public class File implements Serializable {
    private Directory directory;
    private String name;


    public File() {
        this.directory = new Directory();
        this.name = "file";
    }

    public File(Directory directory, String name) {
        if (directory != null) {
            this.directory = directory;
        } else {
            this.directory = new Directory();
        }

        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Incorrect file name!");
        }
    }

    public Directory getDirectory() {
        return directory;
    }

    public void setDirectory(Directory directory) {
        if (directory != null) {
            this.directory = directory;
        } else {
            this.directory = new Directory();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Incorrect file name!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof File)) return false;
        File file = (File) o;
        return directory.equals(file.directory) &&
                name.equals(file.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(directory, name);
    }

    @Override
    public String toString() {
        return "File{" +
                "directory=" + directory +
                ", name='" + name + '\'' +
                '}';
    }
}
