/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.net.URL;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * FXML Controller class
 *
 * @author sombe
 */

public class Week62Controller implements Initializable {

    @FXML
    private TextField taNewName;
    @FXML
    private TextField taNewNumber;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnExit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
    }
    

    ArrayList<String> list = new ArrayList<>();

// Your class declarations and other methods...


@FXML
void add1() {
    System.out.println("Button pressed");
    String number = taNewNumber.getText();
    String name = taNewName.getText();
    // Prepare the text to append
    String entry = System.lineSeparator()+ name + ", " + number; 

    // Clear the text fields
    taNewNumber.clear();
    taNewName.clear();
    System.out.println("clearing fields");
    // Append mode to write to the file
    try (FileWriter fileWriter = new FileWriter("C:\\Users\\sombe\\OneDrive\\Documents\\NetBeansProjects\\mavenproject1\\src\\main\\resources\\com\\mycompany\\mavenproject1\\staffphone.txt", true);
         PrintWriter printWriter = new PrintWriter(fileWriter)) {
        printWriter.print(entry);
            System.out.println("writing to the file");// Append the text to the file
    } catch (IOException e) {
            System.out.println("Writing failed");
        e.printStackTrace(); // Handle potential IOException
    }
}



    @FXML
    void add2() {
        String number = taNewNumber.getText();
        String name = taNewName.getText();
        list.add(name + ", " + number);
        taNewNumber.clear();
        taNewName.clear();
        System.out.println(list.toString());
        System.out.println(list.get(0));
           int x = 0;
         while (x < list.size()){
           System.out.println(list.get(x));
        x++;
        
        
    }}

    }
