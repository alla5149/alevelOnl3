package com.zhmaka.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFile implements Action {
    String fileName = "D:/JavaProjects/alevelOnl3/src/main/resources/CarObject.json";


    @Override
    public void execute() throws IOException {
        private static void readUsingFileReader(String fileName) throws IOException {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                //обрабатываем считанную строку - пишем ее в консоль
                System.out.println(line);
            }
            br.close();
            fr.close();

        }

    }
}
