import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.lang.Character;

public class ProjectUI {
    public static void main (String [] args){

    // Variables
    int userInput, userInput2, userInput3;
    
    // Objects Created
    int size = 100;
    Scanner keyboard = new Scanner(System.in);

    ArrayList<Listing> listings = new ArrayList<Listing>();
    ArrayList<Application> applications = new ArrayList<Application>();

    Hash_Owner ownerDataBase = new Hash_Owner(size);
    Hash_Student studentDataBase = new Hash_Student(size);
    Owner owners = null;
    Owner fetch;
    Student students = null;
    Student studentFetch;
    Admin admins = null;

    String  userID, listingID, appID, stdID;

    String schedule, location, buildingType,furnished,
            price, bed, bath, sqft, status;

    String major, graduationDate, 
            aboutMe;

    String firstName, lastName, email, phoneNo; // For Owner
    String fName, lName, em, ph; //For Student
      
    char gender;

    String fetchedID;

    String [] dummyData  = new String [30];
    

    // Insert Data to to Student and Owner Hash
    try {
        // Ask for user preference on listings to return?
        File file = new File("listings.csv");
        Scanner scanner = new Scanner(file);


        while ( scanner.hasNextLine()) {


            String fileData = scanner.nextLine();
            dummyData = fileData.split(",");


            //Insert Owner
            price =dummyData [0];
            schedule =dummyData [1];
            location =dummyData [2];
            buildingType = dummyData [3];
            bed =dummyData [4];
            bath =dummyData [5];
            sqft = dummyData [6];
            furnished = dummyData [7];
            status = dummyData [8];
            userID = dummyData [9];
            firstName =dummyData [10];
            lastName =dummyData [11];
            email = dummyData [12];
            phoneNo = dummyData [13];
            listingID= dummyData [14];
            //Insert Student
            stdID = dummyData [15];
            fName = dummyData [16];
            lName = dummyData [17];
            em = dummyData [18];
            ph =dummyData [19];
            major =dummyData [20];
            email = dummyData [21];
            graduationDate = dummyData [22];
            aboutMe = dummyData[23];
            appID = dummyData[24];
            gender = dummyData [25].charAt(0);


            // Insert File Owners and Their Listing
            Application anApplication1 = new Application (appID); //(Admin.newID('a')); 
            Admin.setAppID(appID); // set most recently used application ID

            applications.add(anApplication1);
            Listing alisting = new Listing(listingID,price,schedule,location,buildingType,bed,bath,sqft,furnished,status,(ArrayList<Application>)applications.clone()); //(Admin.newID('l'));
            Admin.setListingID(listingID); // set most recently used listing ID
            listings.add(alisting);
            owners = new Owner(userID,firstName,lastName, email,phoneNo, (ArrayList<Listing>)listings.clone()); // Admin.newID('u')
            Admin.setUserID(userID); // set most recently used user ID
            ownerDataBase.insert(owners);
            listings.clear();

            //Insert File Students and their Applications
            students = new Student(stdID,fName,lName,em,ph,major,graduationDate,gender,aboutMe,(ArrayList<Application>)applications.clone()); // Admin.newID('u')
            Admin.setUserID(stdID); // set most recently used user ID
            studentDataBase.insert(students);
            applications.clear();

        } System.out.println("CHNT System Ready\n");
        scanner.close();
    } catch (FileNotFoundException e) {
        System.out.println("File not found\n");
    }

    // End Insert to hash


    do{
        System.out.println(
                " WELCOME TO CHNT - Enter: \n"+
                        " 1. Login as Owner\n" +
                        " 2. Login as Admin \n"+
                        " 3. Login as Student\n"+
                        " 0. Exit Program \n"
        );
        userInput = keyboard.nextInt();
        keyboard.nextLine();
        switch(userInput){

            case 1:
                //Login as Owner
                do{
                    System.out.println(
                            "\n WELCOME TO CHNT - OWNER VIEW - Enter: \n"+
                                    " 1. Register Account\n" +
                                    " 2. Account Login\n" +
                                    " 0. Exit Owner View \n"
                    );
                    userInput2 = keyboard.nextInt();
                    keyboard.nextLine();
                    switch(userInput2){
                        case 1:
                            System.out.println("Enter Your First Name");
                            firstName = keyboard.nextLine();
                            System.out.println("Enter Your Last Name");
                            lastName  = keyboard.nextLine();
                            System.out.println("Enter Your Email");
                            email = keyboard.nextLine();
                            System.out.println("Enter Your Phone");
                            phoneNo  = keyboard.nextLine();

                            System.out.println("\nHow Many Listings do you have?");
                            int count = keyboard.nextInt();
                            keyboard.nextLine();
                            for(int i = 0; i < count; i++ ){
                                System.out.println("Listing Price");
                                price  = keyboard.nextLine();
                                System.out.println("Price Schedule ( Monthly, Weekly, Yearly)");
                                schedule  = keyboard.nextLine();
                                System.out.println("Location");
                                location  = keyboard.nextLine();
                                System.out.println("Building Type");
                                buildingType  = keyboard.nextLine();
                                System.out.println("How Many Beds");
                                bed = keyboard.nextLine();
                                System.out.println("How Many Baths");
                                bath = keyboard.nextLine();
                                System.out.println("SQFT");
                                sqft  = keyboard.nextLine();
                                System.out.println("Furnished? (Yes or No)");
                                furnished = keyboard.nextLine();
                                System.out.println("Status");
                                status = keyboard.nextLine();

                                listingID = String.valueOf(randomNumber());
                                Listing alisting = new Listing(Admin.newID('l') /*listingID*/,price,schedule,location,buildingType,bed,bath,sqft,furnished,status,(ArrayList<Application>)applications.clone());
                                listings.add(alisting);

                            } // end for listings

                            //userID = String.valueOf(randomNumber());
                            owners = new Owner (Admin.newID('u') /*userID*/,firstName,lastName,email,phoneNo,(ArrayList<Listing>)listings.clone());
                            ownerDataBase.insert(owners);
                            System.out.println(owners.toString());
                            listings.clear();
                        case 2:
                            //After Registration: New Owner Prompt
                            int ownerInput;
                            do{
                                System.out.println(
                                    "\n MENU – OWNER CHNT\n"+
                                        " 1. Create Listing\n" +
                                        " 2. View My Profile\n"+
                                        " 3. Edit My Profile\n"+
                                        " 0. Exit \n"
                                );
                                ownerInput = keyboard.nextInt();
                                keyboard.nextLine();
                                switch(ownerInput){
                                    case 1:
                                        // owner create new listing
                                        System.out.println("Enter Your Account ID");
                                        fetchedID = keyboard.nextLine();
                                        fetch = ownerDataBase.fetch(fetchedID);
                                        System.out.println("Listing Price");
                                        price  = keyboard.nextLine();
                                        System.out.println("Price Schedule ( Monthly, Weekly, Yearly)");
                                        schedule  = keyboard.nextLine();
                                        System.out.println("Location");
                                        location  = keyboard.nextLine();
                                        System.out.println("Building Type");
                                        buildingType  = keyboard.nextLine();
                                        System.out.println("How Many Beds");
                                        bed = keyboard.nextLine();
                                        System.out.println("How Many Baths");
                                        bath = keyboard.nextLine();
                                        System.out.println("SQFT");
                                        sqft  = keyboard.nextLine();
                                        System.out.println("Furnished? (Yes or No)");
                                        furnished = keyboard.nextLine();
                                        System.out.println("Status");
                                        status = keyboard.nextLine();

                                        listingID = String.valueOf(randomNumber());
                                        Listing alisting = new Listing(Admin.newID('l') /*listingID*/,price,schedule,location,buildingType,bed,bath,sqft,furnished,status,(ArrayList<Application>)applications.clone());
                                        fetch.addListing(alisting);
                                        break;

                                    case 2:
                                        // owner view profile
                                        try{
                                            System.out.println("Enter Your Account ID");
                                            fetchedID = keyboard.nextLine();
                                            fetch = ownerDataBase.fetch(fetchedID);
                                            System.out.println(fetch.toString());
                                        }catch(NullPointerException e){
                                            System.out.println("**** Owner Account Not Found ****");
                                        }
                                        break;
                                        
                                    case 3:
                                        // 
                                        System.out.println(
                                        "\n MENU – EDIT OWNER PROFILE CHNT\n"+
                                            " 1. Update Email\n" +
                                            " 2. Update Phone Number\n"+
                                            " 0. Exit \n"
                                        );
                                        
                                        int ownerUpdate = keyboard.nextInt();
                                        keyboard.nextLine();
                                        try{
                                            System.out.println("Enter Your Account ID");
                                            fetchedID = keyboard.nextLine();
                                            fetch = ownerDataBase.fetch(fetchedID);
                                            
                                            switch (ownerUpdate) {
                                                case 1:
                                                    System.out.println("Enter New Email");
                                                    String e = keyboard.nextLine();
                                                    fetch.setemail(e);
                                                    ownerDataBase.update(fetchedID, fetch);
                                                    break;
                                                case 2:
                                                    System.out.println("Enter New Phone Number");
                                                    String p = keyboard.nextLine();
                                                    fetch.setphone(p);
                                                    ownerDataBase.update(fetchedID, fetch);
                                                    break;
                                                default:
                                                    break;
                                            } // end switch profile updates
                                        }catch(NullPointerException e){
                                            System.out.println("**** Owner Account Not Found ****");
                                        }
                                        break;
                                } // end switch owner input
                            } while(ownerInput != 0);
                            break;
                    } // end switch user input 2
                }while(userInput2 != 0);
                break;

            case 2:
                //Login as Admin
                do{
                    System.out.println(
                            "\n WELCOME TO CHNT - ADMIN VIEW - Enter: \n"+
                                    " 1. Register Account\n" +
                                    " 2. Account Login\n" +
                                    " 0. Exit Admin View \n"
                    );
                    userInput2 = keyboard.nextInt();
                    keyboard.nextLine();
                    switch(userInput2){
                        case 1:
                            // new admin registration
                            System.out.println("Enter Your First Name");
                            firstName = keyboard.nextLine();
                            System.out.println("Enter Your Last Name");
                            lastName  = keyboard.nextLine();
                            System.out.println("Enter Your Email");
                            email = keyboard.nextLine();
                            System.out.println("Enter Your Phone");
                            phoneNo  = keyboard.nextLine();

                            userID = Admin.newID('u'); //String.valueOf(randomNumber());
                            admins = new Admin(userID,firstName,lastName,email,phoneNo);

                        case 2:
                            //admin operations
                            int adminInput;
                            do{
                                System.out.println(
                                        "\n MENU – ADMIN CHNT\n"+
                                                " 1. Delete Listings\n" +
                                                " 2. Remove Owner \n"+
                                                " 3. Remove Student\n"+
                                                " 0. Exit \n"
                                );
                                adminInput = keyboard.nextInt();
                                keyboard.nextLine();
                                switch(adminInput){
                                    case 1:
                                        // admin delete listing
                                        System.out.println("Enter Owner ID");
                                        fetchedID = keyboard.nextLine();
                                        fetch = ownerDataBase.fetch(fetchedID);
                                        System.out.println("Enter Listing ID for Deletion:");
                                        fetchedID = keyboard.nextLine();
                                        fetch.removeListing(fetchedID);
                                        ownerDataBase.showAll();
                                        break;

                                    case 2: //Admin Removes Owner Here
                                        System.out.println("Enter Owner ID:");
                                        ownerDataBase.delete(keyboard.nextLine());
                                        ownerDataBase.showAll();
                                        break;

                                    case 3: //Admin Removes Student Here
                                        System.out.println("Enter Student ID:");
                                        studentDataBase.delete(keyboard.nextLine());
                                        studentDataBase.showAll();
                                        break;
                                }
                            } while(adminInput != 0);
                            break;
                    }

                }while(userInput2 != 0);
                break;

            case 3:
                //Login as Student
                do{
                    System.out.println(
                                // add option to login?
                                "\n WELCOME TO CHNT - STUDENT VIEW - Enter: \n"+
                                    " 1. Register Account\n" +
                                    " 2. Student Login\n" +
                                    " 0. Exit Student View \n"
                    );
                    userInput2 = keyboard.nextInt();
                    keyboard.nextLine();
                    switch(userInput2){
                        case 1:
                            // student registration
                            System.out.println("Enter Your First Name");
                            firstName = keyboard.nextLine();
                            System.out.println("Enter Your Last Name");
                            lastName  = keyboard.nextLine();
                            System.out.println("Enter Your Email");
                            email = keyboard.nextLine();
                            System.out.println("Enter Your Phone");
                            phoneNo  = keyboard.nextLine();
                            System.out.println("Enter Your Major");
                            major = keyboard.nextLine();
                            System.out.println("Enter Your Graduation Date");
                            graduationDate = keyboard.nextLine();
                            System.out.println("Enter Your Gender (F/M/N)");
                            gender = keyboard.nextLine().charAt(0);
                            System.out.println("Enter A Brief Personal Description");
                            aboutMe = keyboard.nextLine();

                            userID = String.valueOf(randomNumber());
                            students = new Student (Admin.newID('u') /*userID*/, firstName, lastName, email,  phoneNo, major, graduationDate,gender, 
                                                    aboutMe, null);
                            studentDataBase.insert(students);
                            System.out.println(students.toString());
                            
                        case 2:
                            //student operations
                            int studentInput;
                            do{
                                System.out.println(
                                        "\n MENU – STUDENT CHNT\n"+
                                                " 1. View Profile & Applications\n" +
                                                " 2. Search Listings\n"+
                                                " 3. Apply for listings\n"+
                                                " 4. Edit profile\n"+
                                                " 0. Exit \n"
                                );
                                studentInput = keyboard.nextInt();
                                keyboard.nextLine();
                                switch(studentInput){
                                    case 1:
                                        // view profile
                                        try{
                                            System.out.println("Enter StudentAccount ID");
                                            fetchedID = keyboard.nextLine();
                                            studentFetch = studentDataBase.fetch(fetchedID);
                                            System.out.println(studentFetch.deepCopy().toString());
                                        }catch(NullPointerException e){
                                            System.out.println("**** Profile Not Found ****");
                                        }
                                        break;

                                    case 2:
                                        // view listings
                                        ownerDataBase.showAll();
                                        break;

                                    case 3:
                                        // apply to listing
                                        try{
                                            System.out.println("Enter Student Account ID");
                                            fetchedID = keyboard.nextLine();
                                            studentFetch = studentDataBase.fetch(fetchedID);
                                            System.out.println(studentFetch.deepCopy().toString());

                                            System.out.println("Enter Listing ID");
                                            listingID = keyboard.nextLine();
                                            System.out.println(studentFetch.applyToListing(listingID));
                                        }catch(NullPointerException e){
                                            System.out.println("**** Profile Not Found ****");
                                        }// retrieving ends here
                                        break;

                                    case 4:
                                        //retrieve Student into Student Fetch
                                        try{
                                            System.out.println("Enter Student Account ID");
                                            fetchedID = keyboard.nextLine();
                                            studentFetch = studentDataBase.fetch(fetchedID);
                                            System.out.println(studentFetch.deepCopy().toString());

                                            System.out.println(
                                            "\n MENU – EDIT STUDENT PROFILE CHNT\n"+
                                                    " 1. Update Email\n" +
                                                    " 2. Update Phone Number\n"+
                                                    " 3. Update Major\n"+
                                                    " 4. Update Graduation Date\n"+
                                                    " 5. Update Personal Description\n"+
                                                    " 0. Exit \n"
                                            );
                                            studentInput = keyboard.nextInt();
                                            keyboard.nextLine();
                                            switch(studentInput){
                                                case 1:
                                                    System.out.println("Enter New Email");
                                                    studentFetch.setemail(keyboard.nextLine());
                                                    studentDataBase.update(fetchedID, studentFetch);
                                                    break;
                                                case 2:
                                                    System.out.println("Enter New Phone Number");
                                                    studentFetch.setphone(keyboard.nextLine());
                                                    studentDataBase.update(fetchedID, studentFetch);
                                                    break;
                                                case 3:
                                                    System.out.println("Enter New Major");
                                                    studentFetch.setMajor(keyboard.nextLine());
                                                    studentDataBase.update(fetchedID, studentFetch);
                                                    break;
                                                case 4:
                                                    System.out.println("Enter Your Graduation Date");
                                                    studentFetch.setGradDate(keyboard.nextLine());
                                                    studentDataBase.update(fetchedID, studentFetch);
                                                    break;
                                                case 5:
                                                    System.out.println("Enter A Brief Personal Description");
                                                    studentFetch.setAboutMe(keyboard.nextLine());
                                                    studentDataBase.update(fetchedID, studentFetch);
                                                    break;
                                        } // end if update aboutMe
                                        }catch(NullPointerException e){
                                            System.out.println("**** Profile Not Found ****");
                                        }// retrieving ends here
                                        break;
                                }
                            } while(studentInput != 0);
                            break;
                    }

                }while(userInput2 != 0);
                break;

        } // end main login switch
    }while(userInput != 0);
    keyboard.close();
    System.out.println("Thank you. The System is terminating.......\n");

}
public static int randomNumber(){
    Random random = new Random();
    return random.nextInt(10000000);
}


}
