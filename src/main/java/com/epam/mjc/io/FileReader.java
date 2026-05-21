package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String name = null;
            String email = null;
            int age = 0;
            long phone = 0;

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(": ", 2);
                if(parts.length < 2) continue;

                String key = parts[0].trim();
                String value = parts[1].trim();

                switch (key) {
                    case "Name":  name  = value; break;
                    case "Age":   age   = Integer.parseInt(value); break;
                    case "Email": email = value; break;
                    case "Phone": phone = Long.parseLong(value); break;
                    default: break;
                }
            }
            return new Profile(name, age, email, phone);
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
