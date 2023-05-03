package Service;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Service {
    public void createNewFile(String newFileName){
        File file = new File(newFileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    public List<String> readFile(String FileName){
        List<String> list = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(FileName))) {
            String s;
            while((s = reader.readLine()) != null){
                list.add(s);
            }
        }catch (Exception e){
            e.fillInStackTrace();
        }
        return list;
    }
    public void writeFile(String FileName,List<String> ObjectsList){
        List<String> list = ObjectsList;
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FileName))) {
            for(String s : list){
                writer.write(s);
                writer.newLine();
            }
        }catch (IOException e){
            e.fillInStackTrace();
        }
    }
    public void toUpperCaseFileText(String fileName){
        List<String> list = readFile(fileName);
        System.out.println(list.stream().map(String::toUpperCase).collect(Collectors.toList()));
    }
    public void copyToOtherFile(String fileNameInitial, String newFileName){
        createNewFile(newFileName);
        List<String> list = readFile(fileNameInitial);
        writeFile(newFileName, list);
        System.out.println("Successful copied to " + newFileName);
    }

}
