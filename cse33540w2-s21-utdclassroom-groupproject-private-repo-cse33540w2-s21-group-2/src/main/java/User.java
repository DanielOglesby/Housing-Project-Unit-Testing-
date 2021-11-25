import java.util.List;
import java.util.ArrayList;

public class User{
  //all data assigned to user class
   protected String userID;
  protected String firstName;
  protected String lastName;
  protected String email;
  protected String phoneNo;
  
  User(){}

  User(String userID, String firstName, String lastName, String email, String phoneNo){
    //constructor
    this.userID = userID;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNo = phoneNo;
  }
  
  //setters
  public void setID(String ID){
    userID = ID;
  }
  
  public void setfirst(String first){
    firstName = first;
  }
  
  public void setlast(String last){
    lastName = last;
  }
  
  public void setemail(String mail){
    email = mail;
  }
  
  public void setphone(String phone){
    phoneNo = phone;
  }
  
  //getters
  public String getID(){
    return userID;
  }
  
  public String getfirst(){
    return firstName;
  }
  
  public String getlast(){
    return lastName;
  }
  
  public String getemail(){
    return email;
  }
  
  public String getphone(){
    return phoneNo;
  }
}
    
