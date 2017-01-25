package edu.ap.xml;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.InputSource;

import java.io.*;

public class XMLParser {
	
	private String INPUTFILE = "/Users/Heidi/Documents/spoedgevallen.xml";
	
	/** Get all spoedgevallen from the xml file and return them 
	 * in html format
	 */
	public String getRaces() {
		File inputFile = new File(INPUTFILE);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
	        doc.getDocumentElement().normalize();
	        String result = "<h2>Spoedgevallen</h2>";
	        
	        NodeList races = doc.getElementsByTagName("spoedgeval");

	        for (int i = 0; i < spoedgevallen.getLength(); i++) {
	        	 Node nNode = spoedgevallen.item(i);
	        	 Element eElement = (Element) nNode;
	        	 
	        	 

	        	 result += "<br/><b>Datum en uur interventie : </b>" + eElement.getAttribute("datum en uur interventie");
	        	 result += "<br/><b>Patientnaam : </b>" + eElement.getAttribute("patientnaam");
	        	 result += "<br/><b>geboortedatum : </b>" + eElement.getAttribute("distance");
	        	 result += "<br/><b>Verpleegkundigenaam : </b>" + eElement.getAttribute("verpleegkundigenaam");
	        	 result += "<br/><b>Diagnose : </b>" + eElement.getAttribute("diagnose");result += "<br/>";
	        }

	        return result;
		} 
		catch (Exception e) {
			return e.getMessage();
		}
	}
	
	/** Get the race with race_id and return them 
	 * in html format
	 */
	public String getRace(String race_id) {
		File inputFile = new File(INPUTFILE);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
	        doc.getDocumentElement().normalize();
	        String result = "<h2>Spoedgeval</h2>";
	        
	        NodeList races = doc.getElementsByTagName("spoedgeval");

	        for (int i = 0; i < spoedgevallen.getLength(); i++) {
	        	
	        	 Node nNode = spoelgevallen.item(i);
	        	 Element eElement = (Element) nNode;
	        	 
	        	 if(eElement.getAttribute("id").equalsIgnoreCase(race_id)) {
	        		
	        		
	        		
	        		 
	        		 result += "<br/><b>Datum en uur interventie : </b>" + eElement.getAttribute("datum en uur interventie");
		        	 result += "<br/><b>Patientnaam : </b>" + eElement.getAttribute("patientnaam");
		        	 result += "<br/><b>geboortedatum : </b>" + eElement.getAttribute("distance");
		        	 result += "<br/><b>Verpleegkundigenaam : </b>" + eElement.getAttribute("verpleegkundigenaam");
		        	 result += "<br/><b>Diagnose : </b>" + eElement.getAttribute("diagnose");
		        	 result += "<br/>";
		       
	        	 }
	        }

	        return result;
		} 
		catch (Exception e) {
			return e.getMessage();
		}
	}
	
	/** Get all spoedgevallen  with spoedgeval_id and return them
	 * in valid html format
	 */
	public String getRunners(String spoedgeval_id) {
		File inputFile = new File(INPUTFILE);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
	        doc.getDocumentElement().normalize();
	        String result = "<h2>patientnames</h2>";
	        
	        NodeList spoedgevallen = doc.getElementsByTagName("spoedgeval");

	        for (int i = 0; i < spoedgevallen.getLength(); i++) {
	        	
	        	 Node spoedgeval = spoedgevallen.item(i);
	        	 Element eElement = (Element)spoedgeval;
	        	 
	        	 if(eElement.getAttribute("id").equalsIgnoreCase(spoedgeval_id)) {
	        		 NodeList patienten = eElement.getElementsByTagName("patient");
	        		 for (int j = 0; j < patienten.getLength(); j++) {
	        			 Node runner = patienten.item(j);
	        			 Element eElement2 = (Element)runner;
	        			 result += "<br/><b>Datum en uur interventie : </b>" + eElement.getAttribute("datum en uur interventie");
			        	 result += "<br/><b>Patientnaam : </b>" + eElement.getAttribute("patientnaam");
			        	 result += "<br/><b>geboortedatum : </b>" + eElement.getAttribute("distance");
			        	 result += "<br/><b>Verpleegkundigenaam : </b>" + eElement.getAttribute("verpleegkundigenaam");
			        	 result += "<br/><b>Diagnose : </b>" + eElement.getAttribute("diagnose");
			        	 result += "<br/>";
	        		 }
	        	 }
	        }

	        return result;
		} 
		catch (Exception e) {
			return e.getMessage();
		}
	}
	
	/** Delete the spoedgeval with spoedgeval_id and return all spoedgevallen in 
	 * valid format
	 */
	public String deleteRace(String race_id) {
		File inputFile = new File(INPUTFILE);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
	        doc.getDocumentElement().normalize();
	        
	        NodeList spoedgevallen = doc.getElementsByTagName("spoedgeval");

	        for (int i = 0; i < spoedgevallen.getLength(); i++) {
	        	
	        	 Node nNode = spoedgevallen.item(i);
	        	 Element eElement = (Element)nNode;
	        	 
	        	 if(eElement.getAttribute("id").equalsIgnoreCase(spoedgeval_id)) {
	        		 eElement.getParentNode().removeChild(eElement);
	        		 Transformer transformer = TransformerFactory.newInstance().newTransformer();
	                 DOMSource source = new DOMSource(doc);
	                 StreamResult result = new StreamResult(new StringWriter());
	                 transformer.transform(source, result);
	        	 }
	        }

	        return this.getSpoedgevallen();
		} 
		catch (Exception e) {
			return e.getMessage();
		}
	}
	
	/**
	 * Add a spoedgeval and return all spoedgevallen in
	 * html format
	 */
	public String addSpoedgeval(String xml) {
		File inputFile = new File(INPUTFILE);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        // set validating false to enable copying
        // node from one document to another
        dbFactory.setValidating(false);
        DocumentBuilder dBuilder;
        
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc1 = dBuilder.parse(inputFile);
	        Document doc2 = dBuilder.parse(new InputSource(new StringReader(xml)));
	        Element element = (Element) doc2.getDocumentElement();
	        // imports a node from doc2 document to doc1, without altering
	        // or removing the source node from the original document
	        Node copiedNode = doc1.importNode(element, true);
	        // adds the node to the end of the list of children of this node
	        doc1.getDocumentElement().appendChild(copiedNode);
	        
	        /*FileWriter fw = new FileWriter(INPUTFILE);
	        fw.write(doc1.toString());
	        fw.close();*/
	        // write the new document to file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc1);
			StreamResult result = new StreamResult(new File(INPUTFILE));
			transformer.transform(source, result);
	        
	        return this.getSpoedgevallen();
		} 
		catch (Exception e) {
			return e.getMessage();
		}
	}

	/**
	 * Add a runner to race with race_id and 
	 * return all races in html format
	 */
	public String addRunner(String spoedgeval_id, String xml) {
		
		// implementation left to students
		
		return this.getSpoedgevallen();
	}
	
	/**
	 * Utility method to print xml document
	 */
	public String prettyPrint(Document xml) throws Exception {
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		Writer out = new StringWriter();
		tf.transform(new DOMSource(xml), new StreamResult(out));
		return out.toString();
	}
}
