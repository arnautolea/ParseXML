/*2.d) XPATH
create methods: 
check tag presence, 
check that tag contains children (not simple text node, but nested tags), 
return list of values for specified tag */

package mvn.ParsingXML;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
 
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
 
public class XPathMethods {
	
    public static void main(String[] args) throws Exception {
        // Get DOM Node for XML
        String fileName = "company123.xml";
        Document document = getDocument(fileName);
 
        String xpathExpression = "";
        System.out.println("-----check tag presence------");
        // employee position
        xpathExpression = "/company/department/employee/position";
        System.out.println("Employee has tag position? ");
        System.out.println(checkIfNodeExists(document, xpathExpression));   //true
         
        // employee empId
        xpathExpression = "/company/department/employee/@empId";
        System.out.println("Employee has attribute empId? ");
        System.out.println(checkIfNodeExists(document, xpathExpression));   //true
         
        // employee skill that is child of skills
        xpathExpression = "/company/department/employee/skill";
        System.out.println("Employee has tag skill? ");
        System.out.println(checkIfNodeExists(document, xpathExpression));   //false
        
        //Valid request for nested tag skill
        xpathExpression = "/company/department/employee/skills/skill";
        System.out.println("Employee has tag skills that contains nested tag skill? ");
        System.out.println(checkIfNodeExists(document, xpathExpression));   //true
        
        //Check for text presence
        xpathExpression = "//*[contains(text(),'Second')]";
        System.out.println("If file contains text \"Second\"? ");
        System.out.println(checkIfNodeExists(document, xpathExpression));   //true
 
        System.out.println("\n-----check that tag contains children------");        
        xpathExpression = "//position[*]";
        System.out.println("Position contains children? ");
        System.out.println(checkIfNodeExists(document, xpathExpression));   //false
        
        xpathExpression = "//skills[*]";
        System.out.println("Skills contains children? ");
        System.out.println(checkIfNodeExists(document, xpathExpression));   //true
       
        System.out.println("\n-----return list of values for specified tag/attribute------");
        XPath xPath =  XPathFactory.newInstance().newXPath();
        String expression = "";
        expression = "//position/text()";
        System.out.println(expression);
        NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println(nodeList.item(i).getNodeValue());
        }
        expression = "//@empId";
        System.out.println(expression);
        NodeList eList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
        for (int e = 0; e < eList.getLength(); e++) {
            System.out.println(eList.item(e).getNodeValue()); 
        }
    }
    
    private static boolean checkIfNodeExists(Document document, String xpathExpression) throws Exception
    {
        boolean matches = false;
         
        // Create XPathFactory object
        XPathFactory xpathFactory = XPathFactory.newInstance();
 
        // Create XPath object
        XPath xpath = xpathFactory.newXPath();
 
        try {
            // Create XPathExpression object
            XPathExpression expr = xpath.compile(xpathExpression);
 
            // Evaluate expression result on XML document
            NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
             
            if(nodes != null  && nodes.getLength() > 0) {
                matches = true;
            }
 
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return matches;
    }
     
    private static Document getDocument(String fileName) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(fileName);
        return doc;
    }  
}
