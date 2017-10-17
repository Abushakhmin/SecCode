package com.company;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class AddDir {

    static void onAddDir(String arg1) {
        Path path = Paths.get(arg1);

        try {
            Files.createDirectory(path);
        }

        catch (FileAlreadyExistsException e){
            // the directory already exists.
        }

        catch (IOException e) {
            //something else went wrong
        e.printStackTrace();
        }
    }
}
