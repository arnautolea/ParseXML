//2.c) StAX query (by emp id)

package mvn.ParsingXML;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class QueryStAX {
   public static void main(String[] args) {
	  
	   boolean isRequestEmpId = false;
	   boolean bLastName = false;
	   boolean bFirstName = false;
	   boolean bBirthDate = false;
	   boolean bPosition = false;
	   boolean bSkills = false;
	   boolean bSkill = false;
	   boolean bManager = false;
      
      try {
         XMLInputFactory factory = XMLInputFactory.newInstance();
         XMLEventReader eventReader =
         factory.createXMLEventReader(new FileReader("company123.xml"));

         String requestedEmpId = "001";
         
         while(eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();
               
            switch(event.getEventType()) {
               
               case XMLStreamConstants.START_ELEMENT:
                  StartElement startElement = event.asStartElement();
                  String qName = startElement.getName().getLocalPart();
                
                  if (qName.equalsIgnoreCase("employee")) {
                      Iterator<Attribute> attributes = startElement.getAttributes();
                      String empId = attributes.next().getValue();
                         
                      if(empId.equalsIgnoreCase(requestedEmpId)) {
                         System.out.println("Start Element : employee");
                         System.out.println("empId : " + empId);
                         isRequestEmpId = true;
                      }
           } else if (qName.equalsIgnoreCase("Lastname")) {
              bLastName = true;
           } else if (qName.equalsIgnoreCase("Firstname")) {
              bFirstName = true;
           } else if (qName.equalsIgnoreCase("Birth Date")) {
              bBirthDate = true;
           } else if (qName.equalsIgnoreCase("Position")) {
              bPosition = true;
           } else if (qName.equalsIgnoreCase("Skills")) {
               bSkills = true;
           } else if (qName.equalsIgnoreCase("Skill")) {
               bSkill = true;
           } else if (qName.equalsIgnoreCase("ManagerId")) {
               bManager = true; 
           }
               break;

               case XMLStreamConstants.CHARACTERS:
                  Characters characters = event.asCharacters();
 
               if (bLastName && isRequestEmpId) {
                       System.out.println("Last Name: " + characters.getData());
                       bLastName = false;
                    } 
               if (bFirstName && isRequestEmpId) {
                        System.out.println("First Name: " + characters.getData());
                        bFirstName = false;
                    } 
               if (bBirthDate && isRequestEmpId) {
                       System.out.println("Birth Date: " + characters.getData());
                       bBirthDate = false;
                    } 
               if (bPosition && isRequestEmpId) {
                       System.out.println("Position: " + characters.getData());
                       bPosition = false;
                    } 
               if (bSkills && isRequestEmpId) {
                        System.out.println("Skills: " + characters.getData());
                        bSkills = false;
                    } 
               if (bSkill && isRequestEmpId) {
                        System.out.println("Skill: " + characters.getData());
                        bSkill = false;
                    } 
               if (bManager && isRequestEmpId) {
                        System.out.println("ManagerId: " + characters.getData());
                        bManager = false;
                    }
               break;

               case XMLStreamConstants.END_ELEMENT:
                  EndElement endElement = event.asEndElement();
                  
               if(endElement.getName().getLocalPart().equalsIgnoreCase("employee") && isRequestEmpId) {
                  System.out.println("End Element : employee");
                  System.out.println();
                  isRequestEmpId = false;
               }
               break;
            } 
         }
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (XMLStreamException e) {
         e.printStackTrace();
      }
   }
}