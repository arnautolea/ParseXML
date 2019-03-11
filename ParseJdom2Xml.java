//2.b) JDOM2 parse

package mvn.ParsingXML;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class ParseJdom2Xml {

   public static void main(String[] args) {

      try {
         File inputFile = new File("company123.xml");
         SAXBuilder saxBuilder = new SAXBuilder();
         Document document = saxBuilder.build(inputFile);
         System.out.println("Root element :" + document.getRootElement().getName());
         Element classElement = document.getRootElement();

         List<Element> departmentList = classElement.getChildren();
         System.out.println("----------------------------");

         for (int temp = 0; temp < departmentList.size(); temp++) {    
            Element department = departmentList.get(temp);
            System.out.println("\nCurrent Element :" 
               + department.getName());
            Attribute attribute =  department.getAttribute("name");
            System.out.println("name : " 
               + attribute.getValue() );
            Attribute attribute1 =  department.getAttribute("depId");
            System.out.println("depId : " 
               + attribute1.getValue() );
 
         List<Element> employeeList = department.getChildren();
 
         System.out.println("----------------------------");
 
         for (int i = 0; i < employeeList.size(); i++) {    
            Element employee = employeeList.get(i);
            Attribute attribute2 =  employee.getAttribute("empId");
            System.out.println("\nemployee empId : " + attribute2.getValue() );
            System.out.println("Last Name : " + employee.getChildText("lastname"));
            System.out.println("First Name : " + employee.getChildText("firstname"));
            System.out.println("Birth Date : " + employee.getChildText("birthDate"));
            System.out.println("Position : " + employee.getChildText("position"));
            System.out.println("Skills : ");
     
            List<Element> skills = employee.getChildren("skills");
            for (Element skill : skills) {
                System.out.println("Skill : "+ skill.getValue());
            }

//            List<Element> skills = employee.getChildren("skills");
//            for (Element skill : skills) {
//            if (skill.getName().equals("skills")) {
//            	System.out.println("Skill: " + skill.getChildText("skill"));
//            }
//            } //output only first child          
            
//            List<Element> skillList = employee.getChildren();
//          for (int s = 0; s < skillList.size(); s++) {
//            Element skill = skillList.get(s);
//            if(skill.getName().equals("skills")) {
//            System.out.println("Skill : " + skill.getChildText("skill"));
//           
//            }
//            }//output only first child 
            
         System.out.println("Manager : " + employee.getChild("managerId").getText());
         }
      }         
      } catch(JDOMException e) {
         e.printStackTrace();
      } catch(IOException ioe) {
         ioe.printStackTrace();
      }
   }
}