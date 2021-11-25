import java.util.*;

public class Owner extends User{
        private ArrayList<Listing> listings;
        private Listing aListing;
    
       
        
     /**
     *  No Arg Constructor for objects of class Owner
     *  
     */    
    public Owner(){
        super();
    }

    /**
     *  Parameterized Constructor for objects of class Owner
     *
     */
    public Owner (String userID, String firstName, String lastName, String email, String phoneNo, ArrayList<Listing> ownerListings) {
        super(userID,firstName,lastName,email,phoneNo);
        if(!(ownerListings == null))
            listings = ownerListings;
    }

    /**
     *  Add a Listing for Owner
     *
     */
     public void addListing( Listing aListing){
         listings.add(aListing);
     }

     /**
     *  Get last Listing for Owner
     *
     */
     public Listing getListing()
     {
         return listings.get(0);
     }

    /**
     *  Remove a Listing for owner
     *
     */
    public boolean removeListing(String targetKey){
            boolean deleted = false;
            Listing temp;
            String name;
            for (int i = 0; i < listings.size(); i++)
            {
                temp = listings.get(i);
                name = temp.getListingID();
                if (name.equals(targetKey)){
                    listings.remove(i);
                    deleted = true;
                    i = listings.size();

                }
            }
            return deleted;
    }

    /**
     *  Remove a Listing for owner
     *
     */
    /*public boolean editListing(String targetKey, String price){
        boolean edited = false;
        Listing temp;
        String name;
        for (int i = 0; i < listings.size(); i++)
        {
            temp = listings.get(i);
            name = temp.getListingID();
            if (name.equals(targetKey)){
                listings.get(i).setPrice(price);
                edited = true;
                i = listings.size();

            }
        }
        return edited;
    }*/

    /**
     *  Method to set Target Key
     */
    public String getKey()
    {
        return userID;

    }

    /**
     * Method to Compare Target Key
     */
    public int compareTo(String targetKey)
    {
        return(userID.compareTo(targetKey));

    }

    /**
     * Method for Data Encapsulation
     */
    public Owner deepCopy(){

        Owner clone = new Owner (userID,firstName, lastName, email,  phoneNo, listings);
        return clone;

    }
    /**
     * Method to Print Owners to File
     */
    public String toFile (){
        return (userID + "," + firstName + "," + lastName + "," + email + "," + phoneNo + "," + aListing.toString());
    }

    /**
     * toString Method 
     *
     */
    public String toString() {

            String str;
               str = "*********************************\n" +
                     "********* Owner Profile *********\n" +
                     "*********************************\n" +
                        "User ID: " + userID + "\n" +
                        "First Name: " + firstName + "\n" +
                        "Last Name: " + lastName + "\n" +
                        "Email: " + email + "\n" +
                        "Phone: " + phoneNo + "\n" ;
            for (int i = 0; i < listings.size(); i++)
                str = str+listings.get(i).toString() + "\n";
            return str;
              
    }

    /**
     * View Listings Method
     *
     */
    public String viewListings() {

        String str;
        str =
        "**********************************\n" +
        "********* Owner Listings *********\n" +
        "**********************************\n";
        for (int i = 0; i < listings.size(); i++)
            str = str+listings.get(i).toString() + "\n";
        return str;

    }
        
    //public void setEmail(String e){
    //    email = e;
    //}
  
    //public void setPhoneNo(String p){
    //    phoneNo = p;
    //}

  

}
