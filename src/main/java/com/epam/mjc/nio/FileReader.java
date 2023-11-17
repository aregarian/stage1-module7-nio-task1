package com.epam.mjc.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;




public class FileReader {

    public Profile getDataFromFile(File file) {
        String name = null;
        int age = 4;
        String email = null;
        String fileData = null;
        try(FileInputStream stream = new FileInputStream(file)) {
            Path path = FileSystems.getDefault().getPath(file.getPath());
            fileData = Files.readString(path);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }


        String[] splitStrings = fileData.split(": ");
        name = splitStrings[1];
        age = Integer.parseInt(splitStrings[2].replaceAll("[^0-9,]", ""));
        String[] hehe = name.split("[^\\w']+");
        String[] hehe1 = hehe[0].split("Age");
        String hehegirl = hehe1[0];

        Profile profile = new Profile(
                hehegirl,
                age,
                hehegirl,
                (long) age
        );



        return profile;
    }





}
