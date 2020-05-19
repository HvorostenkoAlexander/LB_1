package com.company;

import com.google.gson.*;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InOutFile {




    //запись в файл
    public static void OutFile (Object obj) throws IOException {

        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Files.write(Paths.get("test.json"), gson.toJson(obj).getBytes());
        }
       // Предусмотреть обработку исключений, возникающих при нехватке памяти
        catch (OutOfMemoryError e) {
            e.getMessage();
        }
    }
  //чтение из файла
    public static List<Country> inFile () throws IOException {

            // create Gson instance
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("test.json"));
            // convert JSON array to list of books
            List<Country> countrys = Arrays.asList(gson.fromJson(reader, Country[].class));

            for (Country pm : countrys) {
                System.out.println(gson.toJson(pm));
            }

        return countrys;
    }


}
