//2.c) SAX parse

package mvn.ParsingXML;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParseSAX {

   public static void main(String[] args) {

      try {
         File inputFile = new File("company123.xml");
         SAXParserFactory factory = SAXParserFactory.newInstance();
         SAXParser saxParser = factory.newSAXParser();
         UserHandler userhandler = new UserHandler();
         saxParser.parse(inputFile, userhandler);     
      } catch (Exception e) {
         e.printStackTrace();
      }
   }   
}

class UserHandler extends DefaultHandler {
	
   boolean bCompany = false;
   boolean bDepartment = false;
   boolean bEmployee = false;
   boolean bLastName = false;
   boolean bFirstName = false;
   boolean bBirthDate = false;
   boolean bPosition = false;
   boolean bSkills = false;
   boolean bSkill = false;
   boolean bManager = false;

   @Override
   public void startElement(
      String uri, String localName, String qName, Attributes attributes)
      throws SAXException {
 	   
	   if (qName.equalsIgnoreCase("Company")) {
	             bCompany = true;
	  } else if(qName.equalsIgnoreCase("Department")) {
		 System.out.println("Department: ");
	     String name = attributes.getValue("name");
	     System.out.println("name : " + name);
	     String depId = attributes.getValue("depId");
	     System.out.println("depId : " + depId);
	  } else if (qName.equalsIgnoreCase("employee")) {
		 System.out.println("\nEmployee: ");
         String empId = attributes.getValue("empId");
         System.out.println("empId : " + empId);
      } else if (qName.equalsIgnoreCase("Lastname")) {
         bLastName = true;
      } else if (qName.equalsIgnoreCase("Firstname")) {
         bFirstName = true;
      } else if (qName.equalsIgnoreCase("Birth Date")) {
         bBirthDate = true;
      }	else if (qName.equalsIgnoreCase("Position")) {
         bPosition = true;
      }	else if (qName.equalsIgnoreCase("Skills")) {
          bSkills = true;
      }	else if (qName.equalsIgnoreCase("Skill")) {
          bSkill = true;
      }	else if (qName.equalsIgnoreCase("ManagerId")) {
          bManager = true;
         
      }
   }

   @Override
   public void endElement(String uri, 
      String localName, String qName) throws SAXException {
      
      if (qName.equalsIgnoreCase("employee")) {
       	  System.out.println("\nEnd Element :" + qName);
      }
      else if (qName.equalsIgnoreCase("department")) {
          System.out.println("End Element :" + qName);
       }
      else if (qName.equalsIgnoreCase("company")) {
          System.out.println("End Element :" + qName);
       }
   }

   @Override
   public void characters(char ch[], int start, int length) throws SAXException {

	   if (bCompany) {
        System.out.println("Company: " + new String(ch, start, length));
        bCompany = false;
     } else if (bDepartment) {
        System.out.println("Department: " + new String(ch, start, length));
        bDepartment = false;
     } else if (bEmployee) {
         System.out.println("Employee: " + new String(ch, start, length));
         bEmployee = false;
     } else if (bLastName) {
         System.out.println("Last Name: " + new String(ch, start, length));
         bLastName = false;
      } else if (bFirstName) {
          System.out.println("First Name: " + new String(ch, start, length));
          bFirstName = false;
      } else if (bBirthDate) {
         System.out.println("Birth Date: " + new String(ch, start, length));
         bBirthDate = false;
      } else if (bPosition) {
         System.out.println("Position: " + new String(ch, start, length));
         bPosition = false;
      } else if (bSkills) {
          System.out.println("Skills: " + new String(ch, start, length));
          bSkills = false;
      } else if (bSkill) {
          System.out.println("Skill: " + new String(ch, start, length));
          bSkill = false;
      } else if (bManager) {
          System.out.println("ManagerId: " + new String(ch, start, length));
          bManager = false;
      }
   }
}
