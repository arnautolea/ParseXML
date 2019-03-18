//2.a) Create an XML file

package mvn.ParsingXML;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;

public class CreateDomXML {

   public static void main(String[] args) {

      try {
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.newDocument();
         
         // root element
         Element rootElement = doc.createElement("company");
         doc.appendChild(rootElement);

         // department element
         Element department = doc.createElement("department");
         rootElement.appendChild(department);
         
         // setting attribute to element
         Attr name = doc.createAttribute("name");
         name.setValue("Development");
         department.setAttributeNode(name);
         
         Attr depid = doc.createAttribute("depId");
         depid.setValue("1");
         department.setAttributeNode(depid);
                   
         Element employee = doc.createElement("employee");
         department.appendChild(employee);
         
         Attr empid1 = doc.createAttribute("empId");
         empid1.setValue("001");
         employee.setAttributeNode(empid1);
         
         //lastname element
         Element lastname1 = doc.createElement("lastname");
         lastname1.appendChild(doc.createTextNode("Washington"));
         employee.appendChild(lastname1);
         
         //firstname element
         Element firstname1 = doc.createElement("firstname");
         firstname1.appendChild(doc.createTextNode("George"));
         employee.appendChild(firstname1);

         //birthDate element
         Element birthDate1 = doc.createElement("birthDate");
         birthDate1.appendChild(doc.createTextNode("February 22, 1732"));
         employee.appendChild(birthDate1);

         //position element
         Element position1 = doc.createElement("position");
         position1.appendChild(doc.createTextNode("First US President"));
         employee.appendChild(position1);
         
         Element skills1 = doc.createElement("skills");
         employee.appendChild(skills1);
         
         Element skill1 = doc.createElement("skill");
         skill1.appendChild(doc.createTextNode("Powers of persuasion"));
         skills1.appendChild(skill1);
         
         Element skill2 = doc.createElement("skill");
         skill2.appendChild(doc.createTextNode("Ability to unify"));
         skills1.appendChild(skill2);
  
         Element skill3 = doc.createElement("skill");
         skill3.appendChild(doc.createTextNode("Empowering others"));
         skills1.appendChild(skill3);
 
         
         Element managerId = doc.createElement("managerId");
         managerId.appendChild(doc.createTextNode("0"));
         employee.appendChild(managerId);
         
         Element employee2 = doc.createElement("employee");
         department.appendChild(employee2);
         
         Attr empid2 = doc.createAttribute("empId");
         empid2.setValue("002");
         employee2.setAttributeNode(empid2);
         
         //lastname element
         Element lastname2 = doc.createElement("lastname");
         lastname2.appendChild(doc.createTextNode("Adams"));
         employee2.appendChild(lastname2);
         
         //firstname element
         Element firstname2 = doc.createElement("firstname");
         firstname2.appendChild(doc.createTextNode("John"));
         employee2.appendChild(firstname2);

         //birthDate element
         Element birthDate2 = doc.createElement("birthDate");
         birthDate2.appendChild(doc.createTextNode("October 30, 1735"));
         employee2.appendChild(birthDate2);

         //position element
         Element position2 = doc.createElement("position");
         position2.appendChild(doc.createTextNode("Second US President"));
         employee2.appendChild(position2);
         
         Element skills2 = doc.createElement("skills");
         employee2.appendChild(skills2);
         
         Element skill4 = doc.createElement("skill");
         skill4.appendChild(doc.createTextNode("A great communicator"));
         skills2.appendChild(skill4);
         
         Element skill5 = doc.createElement("skill");
         skill5.appendChild(doc.createTextNode("Successful lawyer"));
         skills2.appendChild(skill5);

         
         Element managerId2 = doc.createElement("managerId");
         managerId2.appendChild(doc.createTextNode("1"));
         employee2.appendChild(managerId2);
     
         // write the content into xml file
         TransformerFactory transformerFactory = TransformerFactory.newInstance();
         Transformer transformer = transformerFactory.newTransformer();
         DOMSource source = new DOMSource(doc);
         StreamResult result = new StreamResult(new File("kompashka.xml"));
         transformer.transform(source, result);
         
         // Output to console for testing
         StreamResult consoleResult = new StreamResult(System.out);
         transformer.transform(source, consoleResult);
     
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}