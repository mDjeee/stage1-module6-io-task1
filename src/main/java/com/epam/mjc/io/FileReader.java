package com.epam.mjc.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        try (java.io.FileReader fs = new java.io.FileReader(file.getAbsolutePath())) {
            int ch;
            StringBuilder sb = new StringBuilder();
            while((ch=fs.read()) != -1) {
                sb.append((char)ch);
            }
            String[] keyvalues = sb.toString().split("\n");
            String[] values = new String[keyvalues.length];
            for (int j = 0; j < keyvalues.length; j++) {
                String value = keyvalues[j].trim().split(": ")[1];
                values[j] = value.trim();
            }
            return new Profile(values[0], Integer.parseInt(values[1]), values[2], (long)Integer.parseInt(values[3]));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return new Profile();
    }
}
