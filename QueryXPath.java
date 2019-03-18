//2.d) XPath Query ))) 
package mvn.ParsingXML;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class QueryXPath {

   public static void main(String[] args) {
      
      try {
         File inputFile = new File("company123.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder;

         dBuilder = dbFactory.newDocumentBuilder();

         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();

         XPath xPath =  XPathFactory.newInstance().newXPath();

         String expression = "/company/department/employee[@empId = '003']";
         NodeList nList = (NodeList) xPath.compile(expression).evaluate(
            doc, XPathConstants.NODESET);
        
         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            
            System.out.println("Current Element :" + nNode.getNodeName());
            
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
               System.out.println("Skills : " 
                  + nElement.getAttribute("skills"));
               for (int s = 0; s < nElement.getElementsByTagName("skill").getLength(); s++) {
  				System.out.println("Skill : " 
			      + nElement
				  .getElementsByTagName("skill")
				  .item(s)
				  .getTextContent());
                }
               
               System.out.println("Manager : " 
                  + nElement
                  .getElementsByTagName("managerId")
                  .item(0)
                  .getTextContent()); 
            }
         }   
      } catch (ParserConfigurationException e) {
         e.printStackTrace();
      } catch (SAXException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (XPathExpressionException e) {
         e.printStackTrace();
      }
   }
}