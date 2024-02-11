/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.StringTokenizer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jaark
 */
public class Week6Controller implements Initializable {

    @FXML
    private Button btnDisplayPhoneNumbers;
    @FXML
    private Button btnExit;
    @FXML
    private TextArea taDisplay;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnSave;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void exitClick() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to Close?");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                Platform.exit();
            }
        });
    }
    @FXML
    private void clear() {
    taDisplay.clear();
    }
    @FXML
    void readDataFileAndDisplay() {
        int count = 0;            // number of entries
        String allPhone = "";     // to store all name and phone as single value

        try {
            Scanner in = new Scanner(new FileReader("C:\\Users\\sombe\\OneDrive\\Documents\\NetBeansProjects\\mavenproject1\\src\\main\\resources\\com\\mycompany\\mavenproject1\\staffphone.txt"));//open file
            String myEntry = "";
            String name = "";
            String phone = "";

            while (in.hasNextLine()) {

                myEntry = in.nextLine();
                StringTokenizer st = new StringTokenizer(myEntry, ",");

                while (st.hasMoreTokens()) {
                    name = st.nextToken();
                    phone = st.nextToken();
                }

                allPhone = allPhone + name + "  " + phone + "\n";
                count++;
            }// end of while loop
            in.close();//close file
        } catch (ArrayIndexOutOfBoundsException ex) {
            showAlert("ArrayOutOfBoundsException", ex.getMessage());
        } catch (IOException ex) {
            showAlert("File Reading Error", ex.getMessage());
        }
        //to display the values in the text area having the fx:id taDisplay
        taDisplay.setText(allPhone + "\n" + "Total number of phone entry is: " + count);

    }//end of readDataFileAndDisplay method
    @FXML
    private void showAlert(String title, String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
        @FXML
      private void showNewNumber() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("week62.fxml"));
        Parent root = loader.load();
//get the controller from loader
        
        Stage aStage = new Stage();
        Scene aScene = new Scene(root);
        aStage.setScene(aScene);
        aStage.initModality(Modality.APPLICATION_MODAL);
        aStage.show();
    }


}
