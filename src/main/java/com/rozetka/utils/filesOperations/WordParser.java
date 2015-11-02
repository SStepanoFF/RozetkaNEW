package com.rozetka.utils.filesOperations;

import com.rozetka.utils.PropertyLoader;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergii_Stepanov on 11/2/2015.
 */
public class WordParser {

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

    public static String readWordX(String fileName){
        XWPFWordExtractor wordExtractor=null;
        File file=getFile(fileName);
        if (file==null){
            throw new RuntimeException("File was not found");
        }else{
            try
            {
                XWPFDocument docx = new XWPFDocument(new FileInputStream(getFile(fileName)));
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

    public static void writeToWordX(String fileLocation, String fileName, String newText){
//		XWPFDocument document=null;

        File file=getFile(fileName);
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
        }
    }
}
