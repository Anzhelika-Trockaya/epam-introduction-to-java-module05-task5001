package by.epam.task5001.file;

import java.io.Serializable;
import java.nio.file.Path;

public class Directory implements Serializable {
    private Path path;

    public Directory() {
        this.path = Path.of("new folder");
    }

    public Directory(Path path) {
        if (path != null) {
            this.path = path;
        } else {
            this.path = Path.of("new folder");
        }
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        if (path != null) {
            this.path = path;
        } else {
            this.path = Path.of("");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Directory)) return false;
        Directory directory = (Directory) o;
        return path.equals(directory.path);
    }

    @Override
    public int hashCode() {
        return path.hashCode();
    }

    @Override
    public String toString() {
        return "Directory{" +
                "path=" + path +
                '}';
    }
}
