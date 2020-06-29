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

            File folder = new File(folderToParse + "/");
            File[] listOfFiles = folder.listFiles();

            if(listOfFiles.length == 0){
                System.out.println("No files in directory");
                return;
            }
            System.out.println("Files in directory:");
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }

            Parser parser = new Parser();
            for(int i = 0; i < listOfFiles.length; i++) {
                System.out.println("\n Parsing File " + listOfFiles[i].getName());
                parser.parse(listOfFiles[i]);
                printInfo(parser.getDuplicates(), parser.getFloorsCount(), parser.getCount());
            }
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

        System.out.println();
    }
}

