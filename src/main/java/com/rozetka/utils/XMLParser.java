package com.rozetka.utils;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Sergii_Stepanov on 10/29/2015.
 */
public class XMLParser {

//    example:
//            System.out.println(XMLParser.getTagTextJDOM("groupId"));
//            System.out.println(XMLParser.getTagTextSAX("groupId"));

    private static List<Element> resultElementstListJDOM =new ArrayList<Element>();
    private static String xmlDocPath=PropertyLoader.loadProperty("xmlDocPath");

    public static List<String> getTagTextSAX(String tagName){
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(false);
        SAXHandler handler=SAXHandler.getInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            File file = new File(xmlDocPath);
            handler.setFindTag(tagName);
            handler.setFindTag(tagName);
            saxParser.parse(file,handler);
        }
        catch(ParserConfigurationException e1) {
        }
        catch(SAXException e1) {
            e1.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        List<String> result=handler.getResultElementstListSAX();
        if (result.size()==0){
            System.out.println(String.format("Tag <%s> is not found!",tagName));
        }
        return result;
    }

    public static List<String> getTagTextJDOM(String tagName){
        List<String> stringList=new ArrayList<String>();
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(xmlDocPath);
        try {
            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            List<Element> list = rootNode.getChildren();
            for(Element element:findElement(list,tagName)){
//                System.out.println(String.format("GroupID: %s",element.getChild("groupId").getText()));
                stringList.add(element.getText());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JDOMException e) {
            e.printStackTrace();
        }
        if (stringList.size()==0){
            System.out.println(String.format("Tag <%s> is not found!",tagName));
        }
        return stringList;
    }

    private static List<Element> findElement(List<Element> elementList, String elementName){
        for(Element element:elementList) {
            if (element.getName().toLowerCase().contains(elementName.toLowerCase())) {
                resultElementstListJDOM.add(element);
            }if (element.getChildren().size()>0){
                findElement(element.getChildren(),elementName);
            }
            }
        return resultElementstListJDOM;
    }
}

class SAXHandler extends DefaultHandler {
    public List<String> getResultElementstListSAX() {
        return resultElementstListSAX;
    }

    private static List<String> resultElementstListSAX =new ArrayList<String>();
    private boolean bFindTag = false;

    public void setFindTag(String findTag) {
        this.findTag = findTag;
    }

    private String findTag=null;
    private static SAXHandler instance=null;

    private SAXHandler(){
    }

    public static SAXHandler getInstance(){
        if (instance==null){
            return new SAXHandler();
        }else return instance;
    }

    @Override
    public void startElement (String uri, String localName, String qName, org.xml.sax.Attributes attributes)
            throws SAXException
    {
        if (qName.equalsIgnoreCase(findTag) ) {
            bFindTag = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {

    }

    @Override
    public void characters(char ch[], int start, int length) {
        if (bFindTag) {
            resultElementstListSAX.add(new String(ch, start, length));
            bFindTag = false;
        }
    }
}