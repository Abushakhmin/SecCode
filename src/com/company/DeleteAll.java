package com.company;

import java.io.IOException;
import java.nio.file.*;

class DeleteAll {

    static void onDeleteAll(String arg1) {

        Path del = Paths.get(arg1);

        try {
            Files.delete(del);

        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", del);
        } catch (DirectoryNotEmptyException x) {
            System.err.format("%s not empty%n", del);
        } catch (IOException x) {
            // File permission problems are caught here.
            System.err.println(x);
        }
    }
}
