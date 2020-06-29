/*
 * Created by Denis Zvyagintsev on 28.06.2020
 */

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

public class Parser {
    private final static int maxFloors = 1023;
    private final static String tagToFind = "item";

    private ArrayList<Integer> floorsCount = new ArrayList<Integer>(maxFloors);
    private ArrayList<Item> duplicates = new ArrayList<>();
    private HashMap<Item, Integer> count = new HashMap<Item, Integer>();

    public Parser() {
        for (int i = 0; i < maxFloors; i++) {
            floorsCount.add(0);
        }
    }

    public void parse(File file) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodes = doc.getElementsByTagName(tagToFind);

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);

                //Проверяем что узел является элементом
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    Item item = new Item(element);

                    int itemCount = count.getOrDefault(item, 0) + 1;
                    count.put(item, itemCount);

                    //Добавляем дубикат ровно один раз
                    if (itemCount == 2) {
                        duplicates.add(item);
                    }
                    int floor = item.getFloor();
                    //System.out.println(floor);
                    floorsCount.set(floor, floorsCount.get(floor) + 1);
                }
            }

        }
        catch (SAXParseException e){
            System.out.println("Can't parse file");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Item> getDuplicates() {
        return duplicates;
    }

    public ArrayList<Integer> getFloorsCount() {
        return floorsCount;
    }

    public HashMap<Item, Integer> getCount() {
        return count;
    }
}
