/*
 * Created by Denis Zvyagintsev on 28.06.2020
 */

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    private static final String folderToParse = "filesToParse";
    private static final String fileToParse = "address.xml";

    public static void main(String[] args) {
        try {
            System.out.println("Openning File " + fileToParse);
            File fxmlFile = new File(folderToParse + "/" + fileToParse);
            System.out.println("File opened! Parsing..");
            Parser parser = new Parser();
            parser.parse(fxmlFile);
            printInfo(parser.getDuplicates(), parser.getFloorsCount(), parser.getCount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printInfo(ArrayList<Item> duplicates, ArrayList<Integer> floors, HashMap<Item, Integer> count) {
        System.out.println("duplicates count: " + duplicates.size());
        for (int i = 0; i < duplicates.size(); i++) {
            System.out.println(duplicates.get(i) + " " + count.get(duplicates.get(i)) + " duplicates");
        }

        System.out.println("Building floors:");

        for (int i = 1; i < 6; i++) {
            System.out.println(i + " - floors building count: " + floors.get(i));
        }
    }
}

