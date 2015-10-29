package com.rozetka.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;


import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.docx4j.Docx4jProperties;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.slf4j.LoggerFactory;


public class FileOperations {
	
	//http://developeriq.in/articles/2012/jul/03/handling-ms-word-documents-using-apache-poi/
	
	private static File getFile(String fileLocation, String fileName){
		File file = new File(fileLocation);  //folder location
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
	
	public static String readFromFile(String fileLocation, String fileName){
		if (fileName.contains(".txt")){
			return readTXTFile(fileLocation, fileName);
		}
		if (fileName.contains(".docx")){
			return readWordX(fileLocation, fileName);
		}else {
			throw new RuntimeException("Unknown file format");
		}
	}
	
	private static String readTXTFile(String fileLocation, String fileName){
		File file=getFile(fileLocation, fileName);
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
	
	private static String readWordX(String fileLocation, String fileName){
		XWPFWordExtractor wordExtractor=null;
		File file=getFile(fileLocation, fileName);
		if (file==null){
			throw new RuntimeException("File was not found");
		}else{
		try
		{
			XWPFDocument docx = new XWPFDocument(new FileInputStream(getFile(fileLocation, fileName)));			
			wordExtractor = new XWPFWordExtractor(docx);
			return wordExtractor.getText();
         }catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Can't read WordX file");
         }finally{
        	 if(wordExtractor!=null){
        		 try {
					wordExtractor.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	 }
         }
		}
    }
	
	public static void readWord(String fileLocation, String fileName){
//		POIFSFileSystem fs = null;
//		ClassLoader classloader =
//				   org.apache.poi.poifs.filesystem.POIFSFileSystem.class.getClassLoader();
//				URL res = classloader.getResource(
//				         "org/apache/poi/poifs/filesystem/POIFSFileSystem.class");
//				String path = res.getPath();
//				System.out.println("Core POI came from " + path);
//		try
//		{
//			fs = new POIFSFileSystem(new FileInputStream(getFile(fileLocation, fileName).getAbsoluteFile()));
////			HWPFDocument doc = new HWPFDocument(fs); 
////			HWPFDocument doc = new HWPFDocument(new FileInputStream(getFile(fileLocation, fileName)));
//			
//			WordExtractor wordExtractor = new WordExtractor(fs);
//			System.out.println( wordExtractor.getText());
//           }catch(Exception e) {
//                    e.printStackTrace();
//                }
         }
	
	
	//Example:  System.out.println(FileOperations.readFromFile("//10.17.11.109/Share/", "test.docx"));
	
	public static void writeToFile(String fileLocation, String fileName, String newText){
		if (fileName.contains(".txt")){
			writeToTXT(fileLocation, fileName, newText);
		}
		if (fileName.contains(".docx")){
			writeToWordX(fileLocation, fileName, newText);
		}else {
			throw new RuntimeException("Unknown file format");
		}
		
	}
	
	private static void writeToTXT(String fileLocation, String fileName, String newText){
		File file=getFile(fileLocation, fileName);
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
	
	private static void writeToWordX(String fileLocation, String fileName, String newText){
//		XWPFDocument document=null;	
		
		File file=getFile(fileLocation, fileName);
		if (file==null){
			throw new RuntimeException("File was not found");
		}else{
			try{
//					document = new XWPFDocument(new FileInputStream(file));
//					XWPFParagraph para = document.createParagraph();
//					XWPFRun run = para.createRun();
//					run.getText(0);
//					run.setText("\t\n\r"+newText);
//					document. write(new FileOutputStream(file,true));
				
				WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(file);
				wordMLPackage.getMainDocumentPart().addParagraphOfText(newText);
				wordMLPackage.save(file);
			}catch (Exception e){
				e.printStackTrace();
				throw new RuntimeException("Can't write to WordX file");
			}
//			finally {
//				try {
//					document.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
		}
	}

}
