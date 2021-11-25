import java.util.List;
import java.util.ArrayList;

public class Admin extends User{

  private static int userID;
  private static int listingID;
  private static int appID;

  Admin () {super();}
  Admin(String userID, String firstName, String lastName, String email, String phoneNo){
    super (userID, firstName, lastName, email, phoneNo);
  }// end constructor
  
  /* Commenting out unused methods
  public void deleteUser(User u){
    u = null;
  }
  
  public void deleteListing(Listing l){
    l = null;
  }
  
  public void approveListing(Listing l){
    l.setStatus("true");
  }
  
  public void rejectListing(Listing l){
    l.setStatus("false");
  } */
  
  // user, listing, and app ID setters & getters
  public static void setUserID(String prev)
  {
    userID = Integer.parseInt(prev);
  } // end set user id
  public static void setListingID(String prev)
  {
    listingID = Integer.parseInt(prev);
  } // end set listing id
  public static void setAppID(String prev)
  {
    appID = Integer.parseInt(prev);
  } // end set app id

  //public static String getUserID()
  //{
  //  return Integer.valueOf(userID).toString();
  //} // end get user id
 // public static String getListingID()
  //{
  //  return Integer.valueOf(listingID).toString();
  //} // end get listing id
  //public static String getAppID()
  //{
 //   return Integer.valueOf(appID).toString();
  //} // end get app id

  // get new user id ******************************************
  public static String newID(char type)
  {
    Integer newID;

    switch (type){
      // new ID for user
      case 'u':
        newID = userID + 1;
        setUserID(newID.toString());
        return newID.toString();
      // new ID for listing
      case 'l':
        newID = listingID + 1;
        setListingID(newID.toString());
        return newID.toString();
      // new ID for application
      case 'a':
        newID = appID + 1;
        setAppID(newID.toString());
        return newID.toString();
      default:
        break;
    }

    return "Unable to perform ID operation";
  } // end get new user id
}

