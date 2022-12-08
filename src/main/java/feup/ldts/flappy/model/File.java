package feup.ldts.flappy.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class File {
    private String path;

    public File(String path) {
        this.path = path;
    }

    public String[] readFile() throws IOException {

        Path path_ = Path.of(path);
        String contents = Files.readString(path_);
        //sort the contents
        String[] names = contents.split("\n");
        for (int i = 0; i < names.length; i++) {
            for (int j = i + 1; j < names.length; j++) {
                if (Integer.parseInt(names[i].split(" ")[0]) < Integer.parseInt(names[j].split(" ")[0])) {
                    String temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;
                }
            }
        }
        return names;
    }
    public String[] readCuriosities() throws IOException {
        //Read a file with curiosities separated by ###
        Path path_ = Path.of(path);
        String contents = Files.readString(path_);
        String[] curiosities = contents.split("###");
        //print the curiosities
        return curiosities;
    }
}
