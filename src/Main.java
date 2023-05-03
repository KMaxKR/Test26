import Service.Service;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Service serv = new Service();

        serv.createNewFile("test.txt");

        List<String> list = new ArrayList<>();
        list.add("First Name");
        list.add("Second Name");
        list.add("Third Name");
        list.add("Fourth Name");

        serv.writeFile("test.txt", list);

        System.out.println(serv.readFile("test.txt"));
        serv.toUpperCaseFileText("test.txt");

        serv.copyToOtherFile("test.txt", "final.txt");
        serv.copyToOtherFile("final.txt", "last.txt");
    }
}