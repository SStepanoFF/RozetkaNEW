package com.rozetka.utils.filesOperations;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Sergii_Stepanov on 11/2/2015.
 */
public class CSVParser {

    private static String FILE_PATH="D:\\Work\\Project\\test.csv";

    public static List<String[]> readCSV(){
        List<String[]> csvBody=null;
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(FILE_PATH), ',');
            csvBody = reader.readAll();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return csvBody;
    }

    public static void writeToCell(String cellOldText, String newText){
        CSVWriter writer=null;
        List<String[]> csvBody=null;
        CSVReader reader = null;

        try {
            reader = new CSVReader(new FileReader(FILE_PATH), ',');
            csvBody = reader.readAll();
            for (int row=0;row<csvBody.size();row++){
                for (int cell=0;cell<csvBody.get(row).length;cell++){
                    if (csvBody.get(row)[cell].equalsIgnoreCase(cellOldText)){
                        csvBody.get(row)[cell]=newText;

                    }
                }
            }
            writer = new CSVWriter(new FileWriter(FILE_PATH), ',');
            writer.writeAll(csvBody);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.flush();
                writer.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(String.format("%s was not written!", newText));
            }
        }
    }
}
