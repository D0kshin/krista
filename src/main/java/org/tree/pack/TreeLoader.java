package org.tree.pack;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.List;


public class TreeLoader {
    static public void printTreeInHTML(String treeString){
        //выгрузить переданную строку дерева в HTML файл
        try {
            File file = new File("example.html");
            file.createNewFile();
            FileWriter writer = new FileWriter("example.html", false);
            writer.write("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<body>\n" +
                    "<pre>" +
                    treeString + "</pre>\n" +
                    "</body>\n" +
                    "</html>");
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка при во время записи");
            e.printStackTrace();
        }
    }
    static public void saveTreeInFile(Tree tree, String fileName){
        //выгрузить переданный обьект дерева в JSON файл
        ObjectMapper mapper = new ObjectMapper();
        try{
            String jsonTreeString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(tree);
            File file = new File(fileName + ".json");
            file.createNewFile();
            FileWriter writer = new FileWriter(fileName + ".json", false);
            writer.write(jsonTreeString);
            writer.close();
        }
        catch (JsonParseException e) { e.printStackTrace();}
        catch (IOException e) { e.printStackTrace(); }
    }

    static public Tree loadTreeFromJSONFile(String filePath) {
        //выгрузить из указанного файла обьект дерева
        ObjectMapper mapper = new ObjectMapper();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            List<String> lines = reader.lines().toList();
            String treeLine = "";
            for(String line : lines){
                treeLine += line;
            }
            Tree tree = mapper.readValue(treeLine, Tree.class);
            reader.close();
            return tree;
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
