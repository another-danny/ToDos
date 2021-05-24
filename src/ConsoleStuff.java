import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class ConsoleStuff {

    public static void printMenu() {
        System.out.println("==================================================");
        System.out.println("[!] Please choose one of the following:");
        pme("a", "add a new ToDo");
        pme("l", "list all ToDos");
        pme("d", "delete one or more ToDos");
        pme("dd", "delete \"Done\" ToDos");
        pme("c", "change a ToDo");
        pme("cs", "change a ToDo-Status");
        pme("q", "quit the programm");
        System.out.println("==================================================");
    }

    // pme == printMenuEntry, shortcut is the first input, desc is the description entry
    public static void pme(String shortcut, String desc) {
        System.out.println("[*] " + shortcut + " - " + desc);
    }

    public static void listTasks(List<ToDo> todoList) {
        clear();
        int listCount = 1;
        for (ToDo task : todoList) {
            System.out.println("[" + listCount + "] " + task.status + " - " + task.task);
            listCount++;
        }
    }

    public static void clear() {

        System.out.print("\033[H\033[2J");
        System.out.flush();

    }

    public static void printNotValidNumber(){
        Scanner sc = new Scanner(in);
        out.println("[!] This is not a number, please choose a valid number");
        out.println();
        System.out.print("<PRESS ENTER>");
        sc.nextLine();
    }

    public static void printNumberOutOfBound() {
        Scanner sc = new Scanner(in);
        out.println("[!] This is not a number to choose from, please choose a legal object");
        out.println();
        System.out.print("<PRESS ENTER>");
        sc.nextLine();
    }

}
