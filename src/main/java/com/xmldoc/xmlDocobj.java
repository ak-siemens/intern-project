package com.xmldoc;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class xmlDocobj {
	public String finstring() {
		File file = new File("src/main/java/com/samplexml/sample1.xml");  
		
		//an instance of factory that gives a document builder  
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
		//an instance of builder to parse the specified xml file  
		
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();  
			Document doc = db.parse(file);  
			xmlstring s= new xmlstring();
			String res= s.toXmlString(doc);
			System.out.println(res);
			return res;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
