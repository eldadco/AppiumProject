package XmlUtills.Inputs;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class XmlnputsReader {
    List<HashMap> inputs = new ArrayList<>();

    public List<HashMap> getInputsFromXml() {

        try {

            File fXmlFile = new File("src\\main\\resources\\Inputs.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            NodeList tests = doc.getElementsByTagName("test");



            for (int i = 0; i < tests.getLength(); i++) {
                Node node = tests.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) node;
                    HashMap<String, String> temp = new HashMap<>();
                    temp.put("emailAddress", eElement.getElementsByTagName("emailAddress").item(0).getTextContent());
                    temp.put("password", eElement.getElementsByTagName("password").item(0).getTextContent());
                    this.inputs.add(temp);

                }
            }
            return this.inputs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}