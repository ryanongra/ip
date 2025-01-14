package duke.io;

import duke.Duke;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.net.URL;

/**
 * Controller for MainWindow. Provides the layout for the other controls.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;

    private Duke duke;

    private final Image userImage = new Image(this.getClass().getResourceAsStream("/images/Jesse.jpg"));
    private final Image dukeImage = new Image(this.getClass().getResourceAsStream("/images/Duke.png"));

    /**
     * Creates the main window and filled the dialog container with The Duke's welcome message when the application
     * starts up.
     */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        String welcomeMsg = "Hello I'm The Duke \uD83D\uDE0A \n"
                + "What can I do for you?";
        dialogContainer.getChildren().addAll(
                DukeDialogBox.getDukeDialog(welcomeMsg, dukeImage)
        );
    }

    public void setDuke(Duke d) {
        duke = d;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = duke.getResponse(input);
        dialogContainer.getChildren().addAll(
                UserDialogBox.getUserDialog(input, userImage),
                DukeDialogBox.getDukeDialog(response, dukeImage)
        );
        userInput.clear();
    }

    /**
     * @author Daniel Barral
     * Redirects the user to the project's website and user guide.
     * Reused from https://stackoverflow.com/questions/10967451 with minor modifications.
     */
    @FXML
    private void showHelpMessage() {
        String userGuideUrl = "https://ryanongra.github.io/ip/";
        try {
            Desktop.getDesktop().browse(new URL(userGuideUrl).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //@author
}
