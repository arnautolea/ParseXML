//2.b) DOM  - query (by emp id)

package mvn.ParsingXML;

import java.io.File;
//import java.util.Scanner;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class QueryDomXml {

   public static void main(String[] args) {
	   
//	System.out.print("Enter employee Id: "); 
//   	Scanner input = new Scanner(System.in);
//   	String emp = input.nextLine();
//   	input.close();
	   try {
	         File inputFile = new File("company123.xml");
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();
	         
	         NodeList nList = doc.getElementsByTagName("employee");
	         for (int temp = 0; temp < nList.getLength(); temp++) {
	            Node nNode = nList.item(temp);
            	Element nElement = (Element) nNode;
	               if (nElement.getAttribute("empId").equals("003")) { //for scanner input .equals(emp)
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
	                }//for
	               System.out.println("Manager : " 
	                  + nElement
	                  .getElementsByTagName("managerId")
	                  .item(0)
	                  .getTextContent()); 
	               }//if
	         }//for    
	 }//try 
	   		catch (Exception e) {
	         e.printStackTrace();
	        }
   }//main
}//class