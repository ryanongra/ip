package duke.command;

import duke.*;
import duke.io.ResponseManager;
import duke.task.Task;
import duke.task.TaskManager;

/**
 * This class encapsulates the command to add an event type task.
 * It is triggered by the parser and uses the TaskManager, Ui, and Storage.
 */
public class AddEventCommand implements ICommand {

    private final String input;
    private TaskManager tm;
    private ResponseManager responseManager;
    private Storage storage;
    private Task addedEvent;
    private String reply;

    /**
     * Constructor for the command.
     *
     * @param input The user's input which triggered the creation of this command.
     */
    public AddEventCommand(String input) {
        this.input = input;
    }

    /**
     * Adds the event task by interacting with the relevant instances as mentioned above.
     *
     * @param tm The TaskManager object controlling the tasks in Duke.
     * @param responseManager The Ui object managing Duke's user interface.
     * @param storage The Storage object managing the local storing of tasks.
     */
    public void execute(TaskManager tm, ResponseManager responseManager, Storage storage) {
        try {
            Task addedEvent = tm.addEvent(input);
            this.tm = tm;
            this.responseManager = responseManager;
            this.storage = storage;
            this.addedEvent = addedEvent;
            if (addedEvent != null) {
                reply = responseManager.getTaskAdditionMessage(addedEvent, tm.getTasks().size());
                storage.updateSave(tm.getTasks());
            } else {
                throw new DukeException.NoTimeSpecifiedException(
                        "Please use the format YYYY-MM-DD HH:MM when entering when the event is \n"
                                + "E.g. 2021-08-28 18:30");
            }
        } catch (DukeException.NoNameException
                | DukeException.NoTimeSpecifiedException e) {
            reply = responseManager.getErrorMessage(e);
        }
    }

    public String getReply() {
        return reply;
    }
}