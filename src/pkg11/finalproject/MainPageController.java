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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author STEVEN
 */
public class MainPageController implements Initializable
{

    @FXML
    private ListView<String> listView;

    @FXML
    private TextField customerName;

    //private boolean editable;

    @FXML
    private void addCustomerButtonPressed (ActionEvent event) throws IOException
    {
        System.out.println("go to add customer page");

        Parent mainPageParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml")); //Load FXML page into root
        Scene mainPageScene = new Scene(mainPageParent); //Instantiate new scene and pass mainPageParent 

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow(); //use the same stage as previous

        window.setScene(mainPageScene); //set scene to stage
        window.show(); // display stage

    }

    @FXML
    private void editCustomerButtonPressed (ActionEvent event) throws IOException
    {


        System.out.println("editing customer!");
        try {
            String selected = listView.getSelectionModel().getSelectedItem(); //get the selected item from listview and store it as a string called selected
            String[] output = selected.split(","); //split the string into an array called output by delimter ","
            int index = Integer.parseInt(output[0]); //store the first number of the string which is the same as the index number of the customer is the arraylist

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("EditCustomerPage.fxml"));
            try {
                loader.load(); //load fxml page into FXMLLoader
            }
            catch (IOException ex) {
                System.out.println(ex);
            }

            EditCustomerPageController editPage = loader.getController(); //instantiate controller
            editPage.setText(index); //call method setText and pass index number

            Parent p = loader.getRoot();

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow(); // use same stage as previous

            window.setScene(new Scene(p)); //pass scene to stage
            window.show(); //diplay stage
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please select a record!");
        }

    }


    @FXML
    private void deleteCustomerButtonPressed (ActionEvent event) throws IOException
    {
        //need to select on viewList first
        System.out.println("deleting customer!");
        try {
            String selected = listView.getSelectionModel().getSelectedItem(); //get the selected item from listview and store it as a string called selected
            String[] output = selected.split(","); //split the string into an array called output by delimter ","
            int index = Integer.parseInt(output[0]);//store the first number of the string which is the same as the index number of the customer is the arraylist
            CustomerList cList = new CustomerList(); //instantiate a CustomerList object
            cList.removeCustomerFromCustomerList(index); //pass index to the method
            JOptionPane.showMessageDialog(null, "Customer successfully deleted");

            //load the the main page
            Parent mainPageParent = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
            Scene mainPageScene = new Scene(mainPageParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(mainPageScene);
            window.show();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please select a record!");
        }

    }

    @FXML
    private void searchButtonPressed (ActionEvent event) throws IOException
    {
        String output = "";
        String name = this.customerName.getText().toLowerCase();
        CustomerList c1 = new CustomerList();
        for (int i = 0; i < c1.cList.size(); i++) {
            if (c1.cList.get(i).getFirstName().toLowerCase().contains(name) || c1.cList.get(i).getLastName().toLowerCase().contains(name)) {
                output += i + ",";
            }
        }
        if (output.equals("")) {
            JOptionPane.showMessageDialog(null, "customer not found!");
        }
        else {
            System.out.println("passing output");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("SearchCustomerPage.fxml"));
            try {
                loader.load(); //load fxml page into FXMLLoader
            }
            catch (IOException ex) {
                System.out.println(ex);
            }

            SearchCustomerPageController searchPage = loader.getController(); //
            searchPage.setText(output);

            Parent p = loader.getRoot();

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(new Scene(p));
            window.show();



//         Stage stage = new Stage();
//         stage.setTitle("Search Customer");
//         Scene scene = new Scene(root);
//
//         stage.setScene(scene);
//         stage.show();
        }

    }



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize (URL url, ResourceBundle rb)
    {
        CustomerList c1 = new CustomerList();
        for (int i = 0; i < c1.cList.size(); i++) {
            listView.getItems().add(c1.cList.get(i).toString(i));
        }
    }

}
