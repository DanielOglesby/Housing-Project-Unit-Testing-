import java.io.*;
/**
 * Data Structure to Hold Accounts of Owners
 *
 * @author Abimbola
 * @version 4/22/2021
 */
public class Hash_Owner
{
           int N;
           int n = 0;
           int defaultQuotient = 9967;
           double loadingFactor = 0.75;
           Owner deleted;
           private Owner [] data;
           
   
           public Hash_Owner(int lenght)
           {
               int pct = (int)((1.0/loadingFactor - 1) *100.0);
               N = fourKPlus3(lenght, pct);
               data = new Owner[N];
               deleted = new Owner (" "," "," "," "," ", null);
               for(int i = 0; i < N; i++)
                    data[i] = null;
               
           }
   
      public boolean insert(Owner newOwner)
      {
       boolean noError;
       
       boolean hit = false;
       int pass, q, offset, ip;
       int pk = stringToInt(newOwner.getKey());
       if((((double) n) / N) < loadingFactor)
        {
            pass = 0;
            q = pk / N;
            offset = q;
            ip = pk % N;
            if (q % N == 0)
                offset = defaultQuotient;
            while(pass < N)
            {
                if(data[ip] == null || data[ip] == deleted)
                    {
                        hit = true;
                        break;
                    }
                ip = (ip + offset) % N;
                pass = pass + 1;
            }// end while
            if (hit == true) // insert the node
            {
                data[ip] = newOwner.deepCopy();
                n++;          
                return noError = true;
            }
            else
                return noError = false;
            }
            else // Structure full to loading factor, insert not performed
                return noError = false;
            } // End of insert Method
           
            public Owner fetch(String targetKey)
            {  
                boolean noError;
                boolean hit = false;
                int pass, q, offset, ip;
                int pk = stringToInt(targetKey); // Preprocess Key
                pass = 0;
                q = pk / N;
                offset = q;
                ip = pk % N;
                if(q % N == 0)
                    offset = defaultQuotient;
                while(pass < N)
                { if(data[ip] == null) // Not not in the structure
                    break;
                  if(data[ip].compareTo(targetKey) == 0) // node found
                  {
                     
                     hit = true;
                     break;
                   }
                   ip = (ip + offset) % N; // collision occured
                   pass = pass + 1;
                }// End While
                 if(hit == true) { // return deep copy of the node
                    System.out.println("\n********** Owner Found **********\n");
                    return data[ip].deepCopy();
                     }
                    else{
                   
                    return null;
                }
            }// end of fecth method
           
            public boolean delete(String targetKey)
            {
               boolean noError;
               boolean hit = false;
               int pass, q, offset, ip;
               int pk = stringToInt(targetKey); // preprocess the key
               pass = 0;
               q = pk / N;
               offset = q;
               ip = pk % N;
               if(q % N == 0)
                   offset = defaultQuotient;
               while(pass < N)
               {
                   if(data[ip] == null)// Node not in Structure
                   break;
                   if(data[ip].compareTo(targetKey) == 0)// Node found
                   {
                       hit= true;
                       break;
                   }
                   ip = (ip + offset) % N; // Collision occured
                   pass = pass + 1;
                }
               if(hit == true) // Delete the Node
                {
                      data[ip] = deleted;
                      n--;
                      System.out.println("Request Completed.");
                      return noError = true;
                }
               else{
                    System.out.println("Owner Not Deleted.");
                    return noError = false;
                }
            }// End of delete method
           
            public boolean update(String targetKey,  Owner newOwner)
            {
                if(delete(targetKey) == false)
                    return false;
                else if(insert(newOwner) == false)
                    return false;
                    {
                    System.out.println("Update Sucessful.\n");
                     return true;
            }
            }// End of Update method
           
            
            
            public void showAll()
            {
                for(int i = 0; i < N; i++)
                    if(data[i] != null && data[i] != deleted)
                        System.out.println(data[i].toString());
            }//End Show all
           
            public void toFile(String file){
             try{
                 PrintWriter nodes = new PrintWriter(file);
                 
                 for(int i = 0; i < N; i++)
                 {
                    if(data[i] != null && data[i] != deleted)
                    nodes.println(data[i].toFile());
                 }
                 System.out.println("Ownwers have been writen to the file (LQ HASHED STRUCTURE).");
                 nodes.close();
                }catch(IOException e){
                    System.out.println(e);
                   System.out.println("Writing Failed.");
                    }
               
                }
           
           

            public static int fourKPlus3(int n, int pct)
               {
                    boolean fkp3 = false;
                    boolean aPrime = false;
                    int prime, highDivisor, d;
                    double pctd = pct;
                    prime = (int)(n * (1.0 +( pctd / 100.0)));
                   
                  if(prime % 2 == 0)
                    prime = prime + 1;
                  while(fkp3 == false)// not a 4k + 3 prime
                     {   while(aPrime == false)// not a prime
                            { highDivisor = (int)(Math.sqrt(prime) + 0.5);
                                for(d = highDivisor; d > 1; d--)
                                    {
                                        if(prime % d == 0)
                                            break;
                                    }
                                  if(d != 1)// Prime not found
                                    prime = prime + 2;
                                  else
                                    aPrime = true;
                                }//End of the prime search loop
                                if((prime - 3 ) % 4 == 0)
                                    fkp3 = true;
                                else{
                                    prime = prime +2;
                                    aPrime = false;
                                }
                            }//End of 4k + 3 prime search loop
                            return prime;
                        }// End of fourK plus search method
             
             public static int stringToInt(String aKey)
           {
               int pseudoKey = 0;
               int n = 1;
               int cn = 0;
               char c[] = aKey.toCharArray();
               int grouping = 0;
               while(cn < aKey.length())// Still more characters in the Key
               {
                 grouping = grouping << 8;// pack next 4 characters
                 grouping = grouping + c[cn];
                 cn = cn + 1;
                 if (n == 4 || cn == aKey.length())// 4 Characters are processed or no more characters
                 {
                     pseudoKey = pseudoKey + grouping; // add grouping to pseudoKey
                     n = 0;
                     grouping = 0;
                 }
                 n = n + 1;
                }// End While
               return Math.abs(pseudoKey);  
           }// End StringToInt Method

}// End class Hash_Data
