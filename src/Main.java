import javax.crypto.spec.PSource;
import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);


        // create List for ToDos -> In new version write it in a file
        List<ToDo> todoList = new ArrayList<>();

        // This generates the choosing Menu
        while (true) {
            ConsoleStuff.clear();
            ConsoleStuff.printMenu();
            out.println();
            System.out.print("[?] ");
            String choose = sc.nextLine();


            // look at console Stuff to read the menu items Doku
            switch (choose) {
                case "a":
                    ConsoleStuff.clear();
                    System.out.println("[!] Enter new todo:");
                    System.out.print("[?] ");
                    ToDo newTask = new ToDo(ToDo.Status.New);
                    newTask.task = sc.nextLine();
                    todoList.add(newTask);
                    break;

                case "l":
                    // List items in list
                    ConsoleStuff.listTasks(todoList);
                    out.println();
                    System.out.print("<PRESS ENTER>");
                    sc.nextLine();
                    break;

                case "q":
                    // Quit
                    System.out.println("[*] Bye!");
                    exit(0);

                case "c":

                    // Check if todos exist
                    if (todoList.size() == 0) {
                        out.println("[!] There is nothing to change yet!");
                        out.println();
                        System.out.print("<PRESS ENTER>");
                        sc.nextLine();
                        break;
                    }

                    // Change the Taskname

                    // Call the method to choose from a legal number, if number == -1: illegal number -> break
                    int toChange = checkListValue(todoList);
                    if (toChange == -1) {
                        break;
                    }

                    out.println();
                    out.println("[!] Please Enter the new Value:");
                    out.print("[?] ");
                    todoList.get(toChange).task = sc.nextLine();
                    break;

                case "cs":
                    if (todoList.size() == 0) {
                        out.println("[!] There is nothing to change yet!");
                        out.println();
                        System.out.print("<PRESS ENTER>");
                        sc.nextLine();
                        break;
                    }
                    int toChangeStatus = checkListValue(todoList);
                    if (toChangeStatus == -1) {
                        break;
                    }
                    out.println();
                    out.println("[!] Please choose a new Status");
                    out.println("[1] New");
                    out.println("[2] Ongoing");
                    out.println("[3] Done");
                    out.println();
                    out.print("[?] ");

                    // Switch case for the different statuses
                    try {
                        switch (sc.nextInt()) {
                            case 1:
                                sc.nextLine();
                                todoList.get(toChangeStatus).status = ToDo.Status.New;
                                ConsoleStuff.listTasks(todoList);
                                out.println();
                                System.out.print("<PRESS ENTER>");
                                sc.nextLine();
                                break;
                            case 2:
                                sc.nextLine();
                                todoList.get(toChangeStatus).status = ToDo.Status.Ongoing;
                                ConsoleStuff.listTasks(todoList);
                                out.println();
                                System.out.print("<PRESS ENTER>");
                                sc.nextLine();
                                break;
                            case 3:
                                sc.nextLine();
                                todoList.get(toChangeStatus).status = ToDo.Status.Done;
                                ConsoleStuff.listTasks(todoList);
                                out.println();
                                System.out.print("<PRESS ENTER>");
                                sc.nextLine();
                                break;
                            default:
                                ConsoleStuff.printNumberOutOfBound();
                                break;

                        }
                    } catch (Exception e) {
                        ConsoleStuff.printNotValidNumber();
                    }
                    break;

                case "d":
                    // Call the method to choose from a legal number, if number == -1: illegal number -> break
                    int toDelete = checkListValue(todoList);
                    if (toDelete == -1) {
                        break;
                    }
                    todoList.remove(toDelete);
                    break;

                case "dd":
                    ConsoleStuff.clear();
                    out.println("[!] Really delete all Done-ToDos? (y/n)");
                    out.print("[?] ");
                    if ("y".equals(sc.nextLine())) {
                        for (int i = 0; i < todoList.size(); i++) {
                            if (todoList.get(i).status == ToDo.Status.Done) {
                                todoList.remove(i);
                            }
                        }
                    }
                    ConsoleStuff.listTasks(todoList);
                    out.println();
                    System.out.print("<PRESS ENTER>");
                    sc.nextLine();
                    break;
            }
        }
    }

    private static int checkListValue(List<ToDo> todoList) {
        Scanner sc = new Scanner(in);
        ConsoleStuff.listTasks(todoList);
        out.println();
        out.println("[!] Please choose which item:");
        out.print("[?] ");
        int toCheck = -1;

        // Check if input == integer
        try {
            toCheck = sc.nextInt();
            sc.nextLine();
        } catch (Exception e) {
            // Close sc.nextInt()
            sc.nextLine();
            ConsoleStuff.printNotValidNumber();
            return -1;
        }

        // Since User != Programmer: Let them choose from 1 - EndOfList instead of 0-EndOfList
        toCheck--;

        // Check if Value in List
        if (toCheck > (todoList.size() - 1) || toCheck < 0) {
            ConsoleStuff.printNumberOutOfBound();
            return -1;
        }
        return toCheck;
    }
}

