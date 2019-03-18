//2.b.i) Query any employee and recursive query all managers (employee’s manager, manager’s manager and so on)

package mvn.ParsingXML;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class RecursionDomXml {

	public static void main(String[] args) {
		   
		   try {
		         File inputFile = new File("company123.xml");
		         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		         Document doc = dBuilder.parse(inputFile);
		         doc.getDocumentElement().normalize();
		         
//need help..I need to use NamedNodeMap? how???(((	
		         
	          		NodeList eList = doc.getElementsByTagName("employee");
	            		for (int i = 0; i < eList.getLength(); i++) {
	            			Node eNode = eList.item(i);
	            			if (eNode.getNodeType() == Node.ELEMENT_NODE) {
	            				Element eElement = (Element) eNode;
	            				NodeList mList = doc.getElementsByTagName("managerId");
	    	            		for (int j = 0; j < mList.getLength(); j++) {
	    	            			Node mNode = mList.item(j);
	    	            			if (mNode.getNodeType() == Node.ELEMENT_NODE) {
	    	            				if (eElement.getAttribute("empId").equals(eElement.getElementsByTagName("managerId").item(j).getTextContent())) {
	            				System.out.println("empId : "+ eElement.getAttribute("empId"));
	    	            		System.out.println("Manager : " + eElement.getElementsByTagName("managerId").item(j).getTextContent());	
	    	            				}
	    	            			}
	    	            		}
		            		}//if
	            		}//for query by empId
		      } catch (Exception e) {
		         e.printStackTrace();
		        }//catch
		  }//main
	}//class