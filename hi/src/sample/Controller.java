package sample;

import javafx.fxml.FXML;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void handleButtonAction(ActionEvent e) {
        if (e.getSource() == ) {
            JOptionPane.showMessageDialog(null, "This works, wow!");
        }
    }

}
