import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadXmlDomParser {

    private static final String FILENAME = "src/eurofxref-daily.xml";
    private List<Exchange> exchangeList;
    private DefaultListModel listModel;


    public ReadXmlDomParser() {

        listModel = new DefaultListModel<>();
        exchangeList = ReadXmlDomParser.getExchange();
        int i = 0;
        for (Exchange e : exchangeList) {
            listModel.add(i, e);
            i++;
        }

    }


    public DefaultListModel getListModel() {
        return listModel;
    }


    public static List<Exchange> getExchange() {

        List<Exchange> exchangeList1 = new ArrayList<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {

            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(FILENAME));
            doc.getDocumentElement().normalize();


            NodeList list = doc.getElementsByTagName("Cube");

            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;
                    if (element.hasAttribute("currency") && element.hasAttribute("rate")) {
                        exchangeList1.add(new Exchange(element.getAttribute("currency"), element.getAttribute("rate")));
                    }

                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }


        return exchangeList1;
    }

}
