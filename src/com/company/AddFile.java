package com.company;

import java.io.File;
import java.io.IOException;

class AddFile {

    static void onAddFile(String arg1) {
        File filPath = new File(arg1);
        filPath.mkdir();

        try {
            filPath.createNewFile();
        }

        catch (IOException e) {
                e.printStackTrace();
        }
    }
}
