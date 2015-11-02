package com.rozetka.utils.filesOperations;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


import com.rozetka.utils.PropertyLoader;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;


public class TXTParser {

	//Example:  System.out.println(TXTParser.readFromFile("//10.17.11.109/Share/", "test.docx"));
	//http://developeriq.in/articles/2012/jul/03/handling-ms-word-documents-using-apache-poi/

	private static String fileFolder= PropertyLoader.loadProperty("docsFolder");

	private static File getFile(String fileName){
		File file = new File(fileFolder);  //folder location
        File [] files = file.listFiles();
        File workFile=null;
        List<File> fileList= new ArrayList<File>();
        for(File currentFile: files )
        {
             if (currentFile.getName().equals(fileName)){   //select file with name fileName
            	 workFile=currentFile;
             }
        }
        return workFile;
	}
	
	public static String readTXTFile(String fileName){
		File file=getFile(fileName);
		if (file==null){
			throw new RuntimeException("File was not found");
		}else{
		BufferedReader bufReader=null;
		String everything=null;
		try {
			bufReader = new BufferedReader(new FileReader(file));
			StringBuilder stringBuilder = new StringBuilder();
		    String line = bufReader.readLine();

		    while (line != null) {
		    	stringBuilder.append(line);
		    	stringBuilder.append(System.lineSeparator());
		        line = bufReader.readLine();
		    }
		    everything = stringBuilder.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bufReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return everything;
		}
	}
	
	public static void writeToTXT(String fileLocation, String fileName, String newText){
		File file=getFile(fileName);
		if (file==null){
			throw new RuntimeException("File was not found");
		}else{
		BufferedWriter writer = null;
		try {
//			writer =new BufferedWriter(new FileWriter(getFile(fileLocation, fileName),true));
		    writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true), "UTF-8"));
		    writer.write("\r\n"+newText);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		   try {
			   writer.close();
		   } catch (Exception e) {
			   e.printStackTrace();
			   throw new RuntimeException("Can't write to TXT file");
		   }
		}
		}
	}
}
