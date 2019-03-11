//2.b) DOM parse

package mvn.ParsingXML;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class ParseDomXml {

   public static void main(String[] args) {

      try {
         File inputFile = new File("company123.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        
         NodeList dList = doc.getElementsByTagName("department");
         
         System.out.println("----------------------------");
         
         for (int i = 0; i < dList.getLength(); i++) {
            Node dNode = dList.item(i);
            
            System.out.println("\nCurrent Element :" + dNode.getNodeName());
            
            if (dNode.getNodeType() == Node.ELEMENT_NODE) {
         
            	Element dElement = (Element) dNode;
                System.out.println("name : " 
                   + dElement.getAttribute("name"));
                
                dElement = (Element) dNode;
                System.out.println("depId : " 
                   + dElement.getAttribute("depId"));
          
        NodeList nList = dElement.getElementsByTagName("employee");
         
         System.out.println("----------------------------");
         
         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
            	
            	Element nElement = (Element) nNode;
               System.out.println("empId : " 
                  + nElement.getAttribute("empId"));
                nElement = (Element) nNode;
               System.out.println("Last Name : " 
                   + nElement
                   .getElementsByTagName("lastname")
                   .item(0)
                   .getTextContent());
               System.out.println("First Name : " 
                  + nElement
                  .getElementsByTagName("firstname")
                  .item(0)
                  .getTextContent()); 
               System.out.println("Birth Date : " 
                  + nElement
                  .getElementsByTagName("birthDate")
                  .item(0)
                  .getTextContent());
               System.out.println("Position : " 
                  + nElement
                  .getElementsByTagName("position")
                  .item(0)
                  .getTextContent());
                  
                  nElement = (Element) nNode;
               System.out.println("Skills : " 
                  + nElement.getAttribute("skills"));
               
               NodeList sList = nElement.getElementsByTagName("skills");
               for (int s = 0; s < sList.getLength(); s++) {
            	   Node sNode = sList.item(s);
                   Element sElement = (Element) sNode;
                   		if (sNode.getNodeType() == Node.ELEMENT_NODE) {
               				System.out.println("Skill : " 
									+ sElement
									.getElementsByTagName("skill")
									.item(s)
									.getTextContent());
               			}
                }//why this loop do not return ALL elements by tag name skill???(((((
               
               System.out.println("Manager : " 
                  + nElement
                  .getElementsByTagName("managerId")
                  .item(0)
                  .getTextContent()); 
            }
         }   
            }
         }
               
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}