//2.c) StAX parse

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

public class ParseStAX {
   public static void main(String[] args) {
	  
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
      
      try {
         XMLInputFactory factory = XMLInputFactory.newInstance();
         XMLEventReader eventReader =
         factory.createXMLEventReader(new FileReader("company123.xml"));

         while(eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();
               
            switch(event.getEventType()) {
               
               case XMLStreamConstants.START_ELEMENT:
                  StartElement startElement = event.asStartElement();
                  String qName = startElement.getName().getLocalPart();

            if (qName.equalsIgnoreCase("Company")) {
     	     System.out.println("Start Element : company");
     	  } else if(qName.equalsIgnoreCase("Department")) {
             System.out.println("Start Element : department");
             Iterator<Attribute> attributes = startElement.getAttributes();
             String name = attributes.next().getValue();
             System.out.println("name : " + name);
             String depId = attributes.next().getValue();
             System.out.println("depId : " + depId);
     	  } else if (qName.equalsIgnoreCase("employee")) {
     		 System.out.println("Start Element : employee");
             Iterator<Attribute> attributes = startElement.getAttributes();
             String empId = attributes.next().getValue();
             System.out.println("empId : " + empId);
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
               if (bCompany) {
                   System.out.println("Company: " + characters.getData());
                   bCompany = false;
                   } 
               if (bDepartment) {
                      System.out.println("Department: " + characters.getData());
                      bDepartment = false;
                   } 
               if (bEmployee) {
                       System.out.println("Employee: " + characters.getData());
                       bEmployee = false;
                   } 
               if (bLastName) {
                       System.out.println("Last Name: " + characters.getData());
                       bLastName = false;
                    } 
               if (bFirstName) {
                        System.out.println("First Name: " + characters.getData());
                        bFirstName = false;
                    } 
               if (bBirthDate) {
                       System.out.println("Birth Date: " + characters.getData());
                       bBirthDate = false;
                    } 
               if (bPosition) {
                       System.out.println("Position: " + characters.getData());
                       bPosition = false;
                    } 
               if (bSkills) {
                        System.out.println("Skills: " + characters.getData());
                        bSkills = false;
                    } 
               if (bSkill) {
                        System.out.println("Skill: " + characters.getData());
                        bSkill = false;
                    } 
               if (bManager) {
                        System.out.println("ManagerId: " + characters.getData());
                        bManager = false;
                    }
               break;

               case XMLStreamConstants.END_ELEMENT:
                  EndElement endElement = event.asEndElement();
                  
               if(endElement.getName().getLocalPart().equalsIgnoreCase("employee")) {
                  System.out.println("End Element : employee");
                  System.out.println();
               }
               if(endElement.getName().getLocalPart().equalsIgnoreCase("department")) {
                   System.out.println("End Element : department");
                   System.out.println();
               }
               if(endElement.getName().getLocalPart().equalsIgnoreCase("company")) {
                   System.out.println("End Element : company");
                   System.out.println();
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