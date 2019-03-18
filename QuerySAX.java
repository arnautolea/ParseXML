//2.c) SAX query (by emp id)

package mvn.ParsingXML;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class QuerySAX {

   public static void main(String[] args) {

      try {
         File inputFile = new File("company123.xml");
         SAXParserFactory factory = SAXParserFactory.newInstance();
         SAXParser saxParser = factory.newSAXParser();
         UserHandler2 userhandler = new UserHandler2();
         saxParser.parse(inputFile, userhandler);     
      } catch (Exception e) {
         e.printStackTrace();
      }
   }   
}

class UserHandler2 extends DefaultHandler {
	
   boolean bLastName = false;
   boolean bFirstName = false;
   boolean bBirthDate = false;
   boolean bPosition = false;
   boolean bSkills = false;
   boolean bSkill = false;
   boolean bManager = false;
   String empId = null;
   
   @Override
   public void startElement(
      String uri, String localName, String qName, Attributes attributes)
      throws SAXException {

	      if (qName.equalsIgnoreCase("employee")) {
	    	  empId = attributes.getValue("empId");
	       }
	       if(("001").equals(empId) && qName.equalsIgnoreCase("employee")) {
	          System.out.println("Start Element :" + qName); 
	          System.out.println("EmpId: " + empId);
	       }  
    if (qName.equalsIgnoreCase("Lastname")) {
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
      
	   if (qName.equalsIgnoreCase("employee") && ("001").equals(empId)) {
	            System.out.println("End Element :" + qName);
	      }
	   }
   @Override
   public void characters(char ch[], int start, int length) throws SAXException {

      if (bLastName && ("001").equals(empId)) {
         System.out.println("Last Name: " + new String(ch, start, length));
         bLastName = false;
      } else if (bFirstName && ("001").equals(empId)) {
          System.out.println("First Name: " + new String(ch, start, length));
          bFirstName = false;
      } else if (bBirthDate && ("001").equals(empId)) {
         System.out.println("Birth Date: " + new String(ch, start, length));
         bBirthDate = false;
      } else if (bPosition && ("001").equals(empId)) {
         System.out.println("Position: " + new String(ch, start, length));
         bPosition = false;
      } else if (bSkills && ("001").equals(empId)) {
          System.out.println("Skills: " + new String(ch, start, length));
          bSkills = false;
      } else if (bSkill && ("001").equals(empId)) {
          System.out.println("Skill: " + new String(ch, start, length));
          bSkill = false;
      } else if (bManager && ("001").equals(empId)) {
          System.out.println("ManagerId: " + new String(ch, start, length));
          bManager = false;
      }
   }
}
