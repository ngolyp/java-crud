/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg11.finalproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author STEVEN
 */
public class EditCustomerPageController implements Initializable
{

    private int index;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField yearField;

    @FXML
    private TextField makeField;

    @FXML
    private TextField modelField;

    @FXML
    private TextField liscensePlateField;

    @FXML
    private TextField vinField;

    @FXML
    private TextField mileageField;


    @FXML
    private void doneButtonPressed (ActionEvent event) throws IOException
    {
//        System.out.println("finish editing customer!");
//        String firstName = this.firstNameField.getText();
//        String lastName = this.lastNameField.getText();
//        String phoneNumber = this.phoneNumberField.getText();
//        int year = Integer.parseInt(this.yearField.getText());
//        String make = this.makeField.getText();
//        String model = this.modelField.getText();
//        String liscensePlate = this.liscensePlateField.getText();
//        String vin = this.vinField.getText();
//        int mileage = Integer.parseInt(this.mileageField.getText());

        String output = "";
        String firstName = this.firstNameField.getText();
        if (!firstName.matches(".+")) {
            output += "ERROR: first name field invalid \n";
        }
        String lastName = this.lastNameField.getText();
        if (!lastName.matches(".+")) {
            output += "ERROR: last name field invalid \n";
        }
        String phoneNumber = this.phoneNumberField.getText();
        if (!phoneNumber.matches("[0-9]+")) {
            output += "ERROR: phone number field invalid \n";
        }
        int year = 0;
        try {
            year = Integer.parseInt(this.yearField.getText());
        }
        catch (Exception e) {
            output += "ERROR: year field invalid \n";
        }
        String make = this.makeField.getText();
        if (!make.matches("[A-Za-z]+")) {
            output += "ERROR: make field invalid \n";
        }
        String model = this.modelField.getText();
        if (!model.matches("[A-Za-z0-9]+")) {
            output += "ERROR: model field invalid \n";
        }
        String liscensePlate = this.liscensePlateField.getText();
        if (!liscensePlate.matches(".+")) {
            output += "ERROR: liscense plate field invalid \n";
        }
        String vin = this.vinField.getText();
        if (!vin.matches("[A-Za-z0-9]+")) {
            output += "ERROR: vin field invalid \n";
        }
        int mileage = 0;
        try {
            mileage = Integer.parseInt(this.mileageField.getText());
        }
        catch (Exception e) {
            output += "ERROR: mileage field invalid \n";
        }

        if (output.equals("")) {
            Customer c1 = new Customer(firstName, lastName, phoneNumber, year, make, model, liscensePlate, vin, mileage);
            CustomerList cList = new CustomerList();
            cList.removeCustomerFromCustomerList(this.index);
            cList.addCustomerToCustomerList(this.index, c1);
            JOptionPane.showMessageDialog(null, "Customer successfully edited");

            Parent mainPageParent = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
            Scene mainPageScene = new Scene(mainPageParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(mainPageScene);
            window.show();
        }
        else {
            JOptionPane.showMessageDialog(null, output);
        }
    }


    @FXML
    private void customerListButtonPressed (ActionEvent event) throws IOException
    {
        System.out.println("go back to customer list!");
        Parent mainPageParent = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        Scene mainPageScene = new Scene(mainPageParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(mainPageScene);
        window.show();
    }


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize (URL url, ResourceBundle rb)
    {

//        CustomerList c1 = new CustomerList();
//        firstNameField.setText(c1.cList.get(this.index).getFirstName());
//        lastNameField.setText(c1.cList.get(this.index).getLastName());
//        phoneNumberField.setText(c1.cList.get(this.index).getPhoneNumber());
//        yearField.setText(Integer.toString(c1.cList.get(this.index).getYear()));
//        makeField.setText(c1.cList.get(this.index).getMake());
//        modelField.setText(c1.cList.get(this.index).getModel());
//        liscensePlateField.setText(c1.cList.get(this.index).getLiscensePlate());
//        vinField.setText(c1.cList.get(this.index).getVin());
//        mileageField.setText(Integer.toString(c1.cList.get(this.index).getMileage()));
    }

    public void setText (int index)
    {
        this.index = index;
        CustomerList c1 = new CustomerList();
        firstNameField.setText(c1.cList.get(index).getFirstName());
        lastNameField.setText(c1.cList.get(index).getLastName());
        phoneNumberField.setText(c1.cList.get(index).getPhoneNumber());
        yearField.setText(Integer.toString(c1.cList.get(index).getYear()));
        makeField.setText(c1.cList.get(index).getMake());
        modelField.setText(c1.cList.get(index).getModel());
        liscensePlateField.setText(c1.cList.get(index).getLiscensePlate());
        vinField.setText(c1.cList.get(index).getVin());
        mileageField.setText(Integer.toString(c1.cList.get(index).getMileage()));
    }
}
