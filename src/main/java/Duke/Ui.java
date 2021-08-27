package Duke;

import java.util.ArrayList;

public class Ui {

    private final String LINEBREAK = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";

    public void introduceYourself() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello I'm\n" + logo + "What can I do for you?");
        System.out.println(LINEBREAK);
    }

    public void printByeMessage() {
        System.out.println(LINEBREAK);
        System.out.println("Duke says: Bye. Hope to see you again soon!");
        System.out.println(LINEBREAK);
    }

    public void printTasks(ArrayList<Task> tasks) {
        System.out.println(LINEBREAK);
        System.out.println("Duke says: Here is your list of tasks :)");
        if (tasks.size() == 0) {
            System.out.println("Looks like you don't have any pending tasks! Must be nice (-_-;)");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i + 1 + "."
                        + tasks.get(i).toString());
            }
        }
        System.out.println(LINEBREAK);
    }

    public void printTaskAddition(Task task, int numTasks) {
        System.out.println(LINEBREAK);
        System.out.println("Duke says: I've added the task: ");
        System.out.println("     " + task.toString());
        System.out.println("You now have " + numTasks + " tasks, jiayouz!");
        System.out.println(LINEBREAK);
    }

    public void printTaskDeletion(Task task, int numTasks) {
        System.out.println(LINEBREAK);
        System.out.println("Duke says: I've deleted the task: ");
        System.out.println("     " + task.toString());
        System.out.println("You now have " + numTasks + " tasks, jiayouz!");
        System.out.println(LINEBREAK);
    }

    public void printTaskCompletion(Task task, int numTasks) {
        System.out.println(LINEBREAK);
        System.out.println("Duke says: You've completed the task: ");
        System.out.println("     " + task.toString() + "Well done!");
        System.out.println("You now have " + numTasks + " tasks, jiayouz!");
        System.out.println(LINEBREAK);
    }

    public void printErrorMessage(Exception msg) {
        System.out.println(LINEBREAK);
        System.out.println(msg.getMessage());
        System.out.println(LINEBREAK);
    }

    public void printUnknownCommandMessage() {
        System.out.println(LINEBREAK);
        System.out.println("Duke says: Sorry I don't understand what that means");
        System.out.println(LINEBREAK);
    }

    public void printInvalidIndexMessage() {
        System.out.println(LINEBREAK);
        System.out.println("Duke says: You don't have that many tasks!");
        System.out.println(LINEBREAK);
    }
}