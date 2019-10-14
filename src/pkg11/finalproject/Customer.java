package pkg11.finalproject;
import java.io.Serializable;
/**
 * @author Rich Smith at ZenOfProgramming.com
 */
public class Customer implements Serializable
{
   private String firstName;
   private String lastName;
   private String address;
   private String phoneNumber;
   private String email;

   private String type;
   private String make;
   private String model;
   private String subModel;
   private int year;
   private String colour;
   private int mileage;
   private String liscensePlate;
   private String vin;

   public Customer (String firstName, String lastName, String phoneNumber, int year, String make, String model, String liscensePlate, String vin, int mileage)
   {
      //will break if year and/or mileage not an int
      this.firstName = firstName;
      this.lastName = lastName;
      this.phoneNumber = phoneNumber;
      this.year = year;
      this.make = make;
      this.model = model;
      this.liscensePlate = liscensePlate;
      this.vin = vin;
      this.mileage = mileage;

   }


   public String getFirstName ()
   {
      return firstName;
   }

   public void setFirstName (String firstName)
   {
      this.firstName = firstName;
   }

   public String getLastName ()
   {
      return lastName;
   }

   public void setLastName (String lastName)
   {
      this.lastName = lastName;
   }

   public String getAddress ()
   {
      return address;
   }

   public void setAddress (String address)
   {
      this.address = address;
   }

   public String getPhoneNumber ()
   {
      return phoneNumber;
   }

   public void setPhoneNumber (String phoneNumber)
   {
      this.phoneNumber = phoneNumber;
   }

   public String getEmail ()
   {
      return email;
   }

   public void setEmail (String email)
   {
      this.email = email;
   }

   public String getType ()
   {
      return type;
   }

   public void setType (String type)
   {
      this.type = type;
   }

   public String getMake ()
   {
      return make;
   }

   public void setMake (String make)
   {
      this.make = make;
   }

   public String getModel ()
   {
      return model;
   }

   public void setModel (String model)
   {
      this.model = model;
   }

   public String getSubModel ()
   {
      return subModel;
   }

   public void setSubModel (String subModel)
   {
      this.subModel = subModel;
   }

   public int getYear ()
   {
      return year;
   }

   public void setYear (int year)
   {
      this.year = year;
   }

   public String getColour ()
   {
      return colour;
   }

   public void setColour (String colour)
   {
      this.colour = colour;
   }

   public int getMileage ()
   {
      return mileage;
   }

   public void setMileage (int mileage)
   {
      this.mileage = mileage;
   }

   public String getLiscensePlate ()
   {
      return liscensePlate;
   }

   public void setLiscensePlate (String liscensePlate)
   {
      this.liscensePlate = liscensePlate;
   }

   public String getVin ()
   {
      return vin;
   }

   public void setVin (String vin)
   {
      this.vin = vin;
   }


   public String toString (int size)
   {
      String output = "";
      output = Integer.toString(size) + ", " + this.firstName + " " + this.lastName + " , " + this.phoneNumber + " , " + Integer.toString(this.year) + " , " + this.make + " , " + this.model + " , " + this.liscensePlate + " , " + this.vin + " , " + Integer.toString(this.mileage);
      return output;
   }

}
