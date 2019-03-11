//2.b) JDOM2 parse

package mvn.ParsingXML;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class ParseJDomXml {
	public static void main(String[] args) {

		  SAXBuilder builder = new SAXBuilder();
		  File xmlFile = new File("company123.xml");

		try {
			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			System.out.println(document.getRootElement());
			
			List<Element> list = rootNode.getChildren("department");
			for (int i = 0; i < list.size(); i++) {
			Element node = (Element) list.get(i);
			   System.out.println("name : " + node.getAttribute("name"));
			   System.out.println("depId : " + node.getAttribute("depId"));
			   System.out.println("-----------");
			   		   
			List<Element> elist = node.getChildren("employee");
		    for (int e = 0; e < elist.size(); e++) {
		    Element enode = (Element) elist.get(e);
			   System.out.println("empId : " + enode.getAttribute("empId"));
			   System.out.println("Last Name : " + enode.getChildText("lastname"));
			   System.out.println("First Name : " + enode.getChildText("firstname"));
			   System.out.println("Birth Date : " + enode.getChildText("birthDate"));
			   System.out.println("Position : " + enode.getChildText("position"));
			   System.out.println("Skills : ");
			   
		    List<Element> slist = enode.getChildren("skills");
		    for (int s = 0; s < slist.size(); s++) {
			Element snode = (Element) slist.get(s);
			    System.out.println("Skill : " + snode.getValue());
			}//for skill
			}//for employee
			}//for department
	   }//try
		catch (IOException io) {
			System.out.println(io.getMessage());
		  } 
		catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		  }
		}//maim
}//class
