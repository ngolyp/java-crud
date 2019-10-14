package pkg11.finalproject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 * @author Rich Smith at ZenOfProgramming.com
 */
public class CustomerList
{
    protected ArrayList<Customer> cList = new ArrayList();

    public CustomerList ()
    {
        this.cList = getDataFromCustomerList();
        //set ArrayList with data from customerlist.data
    }

    public void addCustomerToCustomerList (Customer customer)
    {
        cList.add(customer); //add customer to arraylist
        saveCustomerToFile(); //update the data file

    }

    public void addCustomerToCustomerList (int index, Customer customer)
    {
        cList.add(index, customer); //add customer to arraylist at the specific index in the array
        saveCustomerToFile(); //update the data file

    }

    public void removeCustomerFromCustomerList (int index)
    {
        cList.remove(index); //take out customer from arraylist at specific index
        saveCustomerToFile(); //update the file

    }



    public ArrayList<Customer> getDataFromCustomerList ()
    {
        //declare variable for getting data from data file
        File inFile = new File("customerlist.data");
        FileInputStream fStream;
        ObjectInputStream oStream;

        //if file doesn't exist, will make a new blank data file
        if (!inFile.exists()) {
            saveCustomerToFile();
        }

        try {
            //convert data file to bytes then to an object

            //inFile = new File("customerlist.data");
            fStream = new FileInputStream(inFile);
            oStream = new ObjectInputStream(fStream);

            //delcare ArrayList variable and add data to arraylist
            ArrayList<Customer> cList;
            cList = (ArrayList<Customer>) oStream.readObject();
            return cList;
        }
        catch (IOException e) {
            System.out.println(e);
        }
        catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public void saveCustomerToFile ()
    {
        //for (int i = 0; i < cList.size(); i++) {

        //declare variables to save data file
        File outFile;
        FileOutputStream fStream;
        ObjectOutputStream oStream;

        try {
            //instantiate objects
            outFile = new File("customerlist.data");
            fStream = new FileOutputStream(outFile);
            oStream = new ObjectOutputStream(fStream);

            //write the object to byte then to data file
            oStream.writeObject(cList);

            oStream.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
        //}

//        try {
//            File outfile = new File("customerlist.txt");
//            FileWriter fw = new FileWriter(outfile);
//            BufferedWriter bw = new BufferedWriter(fw);
//
//
//            for (int i = 0; i < cList.size(); i++) {
//
//                String firstName = cList.get(i).getFirstName();
//                String lastName = cList.get(i).getLastName();
//                String phoneNumber = cList.get(i).getAddress();
//                String year = Integer.toString(cList.get(i).getYear());
//                String make = cList.get(i).getMake();
//                String model = cList.get(i).getModel();
//                String liscensePlate = cList.get(i).getLiscensePlate();
//                String vin = cList.get(i).getLiscensePlate();
//                String mileage = Integer.toString(cList.get(i).getMileage());
//
//
//                String output = firstName + ", " + lastName + ", " + phoneNumber + ", " + year + ", " + make + ", " + model + ", " + liscensePlate + ", " + vin + ", " + mileage + "\n";
//
//                bw.write(output);
//            }
//            bw.close();

//        }
//        catch (IOException e) {
//            System.out.println("Error writing to file: " + e);
//        }
    }

    public ArrayList<Customer> getcList ()
    {
        return cList;
    }

    public void setcList (ArrayList<Customer> cList)
    {
        this.cList = cList;
    }



}
