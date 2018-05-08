import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class GUIController implements Initializable {

    private Recursive mRec = new Recursive();
    private Iterative mIte = new Iterative();

    private JFrame TreeGUI;

    public JFXTextField txtInput;
    public RadioMenuItem mnuRec;
    public RadioMenuItem mnuIte;
    public RadioMenuItem mnuFac;
    public RadioMenuItem mnuFib;
    public RadioMenuItem mnuSum;
    public RadioMenuItem mnuExp;
    public RadioMenuItem mnuGCD;
    public RadioMenuItem mnuRev;
    public RadioMenuItem mnuPal;
    public RadioMenuItem mnufBin;
    public RadioMenuItem mnutBin;
    public RadioMenuItem mnuBTree;
    public RadioMenuItem mnuBTreeM;
    public RadioMenuItem mnuCTree;
    public RadioMenuItem mnuCTreeM;

    public JFXTextField txtOperation;
    public JFXTextField txtType;
    public JFXTextField txtOutput;
    public JFXButton btnClear;
    public JFXButton btnCalc;

    private ToggleGroup tgType = new ToggleGroup();
    private ToggleGroup tgOperation = new ToggleGroup();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mnuRec.setSelected(true);
        txtType.setText("Recursion");
        txtOperation.setText("Select From Menu");
        txtInput.requestFocus();
        txtOperation.setFocusTraversable(false);
        txtType.setFocusTraversable(false);
        txtOutput.setFocusTraversable(false);
        setButtonGroups();
    }

    @FXML
    private void handleButtonAction(ActionEvent e) {
        if (e.getSource() == mnuRec) {
            txtType.setText("Recursion");
        }
        else if (e.getSource() == mnuIte) {
            txtType.setText("Iteration");
        }
        else if (e.getSource() == mnuFac) {
            softReset();
            txtInput.setPromptText(Operations.TOOLTIPS[0]);
            txtOperation.setText(Operations.OPERATIONS[0]);
        }
        else if (e.getSource() == mnuFib) {
            softReset();
            txtInput.setPromptText(Operations.TOOLTIPS[1]);
            txtOperation.setText(Operations.OPERATIONS[1]);
        }
        else if (e.getSource() == mnuSum) {
            softReset();
            txtInput.setPromptText(Operations.TOOLTIPS[2]);
            txtOperation.setText(Operations.OPERATIONS[2]);
        }
        else if (e.getSource() == mnuExp) {
            softReset();
            txtInput.setPromptText(Operations.TOOLTIPS[3]);
            txtOperation.setText(Operations.OPERATIONS[3]);
        }
        else if (e.getSource() == mnuRev) {
            softReset();
            txtInput.setPromptText(Operations.TOOLTIPS[4]);
            txtOperation.setText(Operations.OPERATIONS[4]);
        }
        else if (e.getSource() == mnuPal) {
            softReset();
            txtInput.setPromptText(Operations.TOOLTIPS[5]);
            txtOperation.setText(Operations.OPERATIONS[5]);
        }
        else if (e.getSource() == mnufBin) {
            softReset();
            txtInput.setPromptText(Operations.TOOLTIPS[6]);
            txtOperation.setText(Operations.OPERATIONS[6]);
        }
        else if (e.getSource() == mnutBin) {
            softReset();
            txtInput.setPromptText(Operations.TOOLTIPS[7]);
            txtOperation.setText(Operations.OPERATIONS[7]);
        }
        else if (e.getSource() == mnuGCD) {
            softReset();
            txtInput.setPromptText(Operations.TOOLTIPS[8]);
            txtOperation.setText(Operations.OPERATIONS[8]);
        }
        else if (e.getSource() == mnuBTree) {
            softReset();
            txtInput.setPromptText(Operations.TOOLTIPS[9]);
            txtOperation.setText(Operations.OPERATIONS[9]);
        }
        else if (e.getSource() == mnuCTree) {
            softReset();
            txtInput.setPromptText(Operations.TOOLTIPS[10]);
            txtOperation.setText(Operations.OPERATIONS[10]);
        }
        else if (e.getSource() == mnuBTreeM) {
            softReset();
            txtInput.setPromptText(Operations.TOOLTIPS[11]);
            txtOperation.setText(Operations.OPERATIONS[11]);
        }
        else if (e.getSource() == mnuCTreeM) {
            softReset();
            txtInput.setPromptText(Operations.TOOLTIPS[12]);
            txtOperation.setText(Operations.OPERATIONS[12]);
        }
        else if (e.getSource() == btnClear) {
            mnuFac.setSelected(false);
            mnuFib.setSelected(false);
            mnuSum.setSelected(false);
            mnuExp.setSelected(false);
            mnuRev.setSelected(false);
            mnuPal.setSelected(false);
            mnufBin.setSelected(false);
            mnutBin.setSelected(false);
            mnuGCD.setSelected(false);
            txtInput.setText(null);
            txtOutput.setText(null);
            txtInput.setPromptText(null);
            txtType.setText("Recursion");
            txtOperation.setText("Select From Menu");
            txtInput.requestFocus();
        }
        else if (e.getSource() == btnCalc) {
            String tOp = txtOperation.getText();
            for (int i = 0; i < Operations.OPERATIONS.length; i++) {
                if (tOp.equals(Operations.OPERATIONS[i])) {
                    try {
                        handleOperations(i);
                        break;
                    } catch (Exception ie) {
                        Alert aInput = new Alert(Alert.AlertType.WARNING);
                        aInput.setTitle("Invalid Input Warning");
                        aInput.setHeaderText("Invalid Input");
                        aInput.setContentText("Please enter valid input.");
                        Stage aStage = (Stage) aInput.getDialogPane().getScene().getWindow();
                        aStage.setAlwaysOnTop(true);
                        aInput.showAndWait();
                        break;
                    }
                }
            }
        }
    }

    public void handleOperations(int oIndex) {
        boolean isRec = txtType.getText().equals("Recursion");
        switch (oIndex) {
            case 0:
                txtOutput.setText(String.valueOf((isRec) ? mRec.Factorial(Integer.parseInt(txtInput.getText())) : mIte.Factorial(Integer.parseInt(txtInput.getText()))));
                break;
            case 1:
                txtOutput.setText(String.valueOf((isRec) ? mRec.Fibonacci(Integer.parseInt(txtInput.getText())) : mIte.Fibonacci(Integer.parseInt(txtInput.getText()))));
                break;
            case 2:
                txtOutput.setText(String.valueOf((isRec) ? mRec.Summation(Integer.parseInt(txtInput.getText())) : mIte.Summation(Integer.parseInt(txtInput.getText()))));
                break;
            case 3:
                txtOutput.setText(String.valueOf((isRec) ? mRec.Exponentiation(Integer.parseInt(txtInput.getText().split(",")[0]), Integer.parseInt(txtInput.getText().split(",")[1])) : mIte.Exponentiation(Integer.parseInt(txtInput.getText().split(",")[0]), Integer.parseInt(txtInput.getText().split(",")[1]))));
                break;
            case 4:
                txtOutput.setText((isRec) ? mRec.Reverse(txtInput.getText()) : mIte.Reverse(txtInput.getText()));
                break;
            case 5:
                txtOutput.setText(String.valueOf((isRec) ? mRec.Palindrome(txtInput.getText().replaceAll("\\s+","").replaceAll("[^a-zA-Z0-9'\\s]+","").toLowerCase()) : mIte.Palindrome(txtInput.getText().replaceAll("\\s+","").replaceAll("[^a-zA-Z0-9'\\s]+","").toLowerCase())));
                break;
            case 6:
                txtOutput.setText(String.valueOf((isRec) ? mRec.fromBinary(txtInput.getText()) : mIte.fromBinary(txtInput.getText())));
                break;
            case 7:
                txtOutput.setText((isRec) ? mRec.toBinary(Integer.parseInt(txtInput.getText())) : mIte.toBinary(Integer.parseInt(txtInput.getText())));
                break;
            case 8:
                txtOutput.setText(String.valueOf((isRec) ? mRec.GCD(Integer.parseInt(txtInput.getText().split(",")[0]), Integer.parseInt(txtInput.getText().split(",")[1])) : mIte.GCD(Integer.parseInt(txtInput.getText().split(",")[0]), Integer.parseInt(txtInput.getText().split(",")[1]))));
                break;
            case 9:
                txtOutput.setText("Check Panel");
                TreeGUI = new JFrame();
                TreeGUI.setTitle("Binary Tree");
                TreeGUI.setExtendedState(JFrame.MAXIMIZED_BOTH);
                TreeGUI.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                TreePanel CPB = new TreePanel(Recursive.WHITE_TREE, Integer.parseInt(txtInput.getText()),false);
                TreeGUI.add(CPB);
                TreeGUI.setLocationRelativeTo(null);
                TreeGUI.setVisible(true);
                break;
            case 10:
                txtOutput.setText("Check Panel");
                TreeGUI = new JFrame();
                TreeGUI.setTitle("Rainbow Binary Tree");
                TreeGUI.setExtendedState(JFrame.MAXIMIZED_BOTH);
                TreeGUI.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                TreePanel CPC = new TreePanel(Recursive.RAINBOW_TREE, Integer.parseInt(txtInput.getText()),false);
                TreeGUI.add(CPC);
                TreeGUI.setLocationRelativeTo(null);
                TreeGUI.setVisible(true);
                break;
            case 11:
                txtOutput.setText("Check Panel");
                TreeGUI = new JFrame();
                TreeGUI.setTitle("Binary Tree Mirrored");
                TreeGUI.setExtendedState(JFrame.MAXIMIZED_BOTH);
                TreeGUI.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                TreePanel CPBM = new TreePanel(Recursive.WHITE_TREE, Integer.parseInt(txtInput.getText()),true);
                TreeGUI.add(CPBM);
                TreeGUI.setLocationRelativeTo(null);
                TreeGUI.setVisible(true);
                break;
            case 12:
                txtOutput.setText("Check Panel");
                TreeGUI = new JFrame();
                TreeGUI.setTitle("Rainbow Binary Tree Mirrored");
                TreeGUI.setExtendedState(JFrame.MAXIMIZED_BOTH);
                TreeGUI.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                TreePanel CPCM = new TreePanel(Recursive.RAINBOW_TREE, Integer.parseInt(txtInput.getText()),true);
                TreeGUI.add(CPCM);
                TreeGUI.setLocationRelativeTo(null);
                TreeGUI.setVisible(true);
                break;
        }
    }

    public void softReset() {
        txtInput.setText(null);
        txtOutput.setText(null);
    }

    public void setButtonGroups() {
        mnuRec.setToggleGroup(tgType);
        mnuIte.setToggleGroup(tgType);
        mnuFac.setToggleGroup(tgOperation);
        mnuFib.setToggleGroup(tgOperation);
        mnuSum.setToggleGroup(tgOperation);
        mnuExp.setToggleGroup(tgOperation);
        mnuGCD.setToggleGroup(tgOperation);
        mnuRev.setToggleGroup(tgOperation);
        mnuPal.setToggleGroup(tgOperation);
        mnufBin.setToggleGroup(tgOperation);
        mnutBin.setToggleGroup(tgOperation);
        mnuBTree.setToggleGroup(tgOperation);
        mnuBTreeM.setToggleGroup(tgOperation);
        mnuCTree.setToggleGroup(tgOperation);
        mnuCTreeM.setToggleGroup(tgOperation);
    }
}
