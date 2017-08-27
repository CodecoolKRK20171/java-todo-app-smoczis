/**
 * Class representing the TodoApp application.
 * It is the main entry point for this program.
 */
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.IndexOutOfBoundsException;

public class App{

    private static TodoList tasksList = new TodoList();

    public static void main(String[] args)
    {
        while(true)
        {
            try
            {
                printMenu();
                handleMainMenu();
            }
            catch(InputMismatchException e)
            {
                System.out.println("Wrong choose");
            }
        }
    }

    public static void printMenu()
    {
          System.out.println("\nChoose option:");
          System.out.println("(1) Show all tasks");
          System.out.println("(2) Add new task");
          System.out.println("(3) Archive tasks");
          System.out.println("(0) Exit\n");
    }

    public static int handleOption() throws InputMismatchException
    {
        InputMismatchException wrongInput = new InputMismatchException();
        Scanner choose = new Scanner(System.in);
        int choice = 0;
        if(choose.hasNextInt()) choice = choose.nextInt();
        else throw wrongInput;
        return choice;
    }

    public static void handleMainMenu()
    {
        int choice;
        do {
            choice = handleOption();
            if(choice == 1) handleTaskOption();
            else if(choice == 2) addNewItem();
            else if(choice == 3) tasksList.archiveTasks();
            else if(choice == 0) System.exit(0);
            else System.out.println("Wrong choice!");
        } while (true);
    }

    public static void handleTaskOption()
    {
        int option;
        do
        {
            tasksList.listTasks();
            System.out.println();
            printItemMenu();
            option = handleOption();
            if(option == 1) markItem();
            else if(option == 2) unmarkItem();
            else if(option == 0) break;
            else System.out.println("Wrong choice");;

        } while (true);
    }

    public static void markItem()
    {
        int option;
        do {
            System.out.println("Choose item to mark");
            option = handleOption();
            if(option >0 && option <= tasksList.getListSize())
            {
                tasksList.getItem(option-1).mark();
            }

            if(option == 0) break;
            else System.out.println("Wrong choice");;

        } while (true);
    }

    public static void unmarkItem()
    {
        int option;
        do {
            System.out.println("Choose item to unmark");
            option = handleOption();
            if(option > 0 && option <= tasksList.getListSize())
            {
                tasksList.getItem(option-1).unmark();
            }
            if(option == 0) break;
            else System.out.println("Wrong choice");;

        } while (true);
    }

    public static void printItemMenu()
    {
        System.out.println("\n(1) Mark item");
        System.out.println("(2) Unmark item");
        System.out.println("(0) Back\n");
    }

    public static void addNewItem()
    {
        Scanner newDescr = new Scanner(System.in);
        System.out.println("Type description to new item:");
        TodoItem newItem = new TodoItem(newDescr.nextLine());
        tasksList.addItem(newItem);
    }
}
