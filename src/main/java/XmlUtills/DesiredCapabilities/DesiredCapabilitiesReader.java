package XmlUtills.DesiredCapabilities;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.HashMap;

public class DesiredCapabilitiesReader {
    HashMap <String,String> inputs = new HashMap();

    public HashMap getInputsFromXml() {

        try {

            File fXmlFile = new File("src\\main\\resources\\DesiredCapabilities.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            NodeList capabilities = doc.getElementsByTagName("desiredCapabillities");


             Node node = capabilities.item(0);
                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) node;
                    this.inputs.put("deviceName", eElement.getElementsByTagName("deviceName").item(0).getTextContent());
                    this.inputs.put("platformName", eElement.getElementsByTagName("platformName").item(0).getTextContent());
                    this.inputs.put("platformVersion", eElement.getElementsByTagName("platformVersion").item(0).getTextContent());
                }

            return this.inputs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}