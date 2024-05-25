package portal.motorphportal;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBoperation {
    
    
    public int SearchColumnNum(String queriedColumn){
        String file = "C:\\Users\\ducus\\Desktop\\MotorPHPortal\\usersdb.csv";
        String fileTest = "C:\\Users\\ducus\\Desktop\\MotorPHPortal\\testdb.csv";
        BufferedReader CSVreader = null;
        String row = "";
        int columnIndex = -1;
        
        try {
            
            CSVreader = new BufferedReader(new FileReader(file));
            
            String readHeader = CSVreader.readLine();
            String[] splittedHeader = readHeader.split(",");
            
            for(int i = 0; i < splittedHeader.length; i++){
                if(splittedHeader[i].equals(queriedColumn)){
                    columnIndex = i;
                    System.out.println(columnIndex);
                    break;
                }
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                CSVreader.close();
            } catch (IOException ex) {
                Logger.getLogger(DBoperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(columnIndex == -1){
            System.out.println("No matching cloumn found.");
        }
        return columnIndex;
    }
    
    public boolean LoginUser(String username, String password) {
        String file = "C:\\Users\\ducus\\Desktop\\MotorPHPortal\\usersdb.csv";
        String fileTest = "C:\\Users\\ducus\\Desktop\\MotorPHPortal\\testdb.csv";
        BufferedReader CSVreader = null;
        String row = "";
        
        String usernameInput = username;
        String passwordInput = password;
        
        boolean ret = false;
        
        try {
            
            CSVreader = new BufferedReader(new FileReader(file));
            
            while((row = CSVreader.readLine()) != null) {
                String[] rowArray = row.split(",");
                
                String searchInUsernameColumn = rowArray[3];
                String searchInPasswordColumn = rowArray[4];
                
                if(searchInUsernameColumn.equals(username) && searchInPasswordColumn.equals(password)){
                    ret = true;
                    break;
                }
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                CSVreader.close();
            } catch (IOException ex) {
                Logger.getLogger(DBoperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return ret;
    }
    
    public int GetIDbyUsernamePassword(String username, String password) {
        String file = "C:\\Users\\ducus\\Desktop\\MotorPHPortal\\usersdb.csv";
        String fileTest = "C:\\Users\\ducus\\Desktop\\MotorPHPortal\\testdb.csv";
        BufferedReader CSVreader = null;
        String row = "";
        
        String usernameInput = username;
        String passwordInput = password;
        
        int userID = -1;
        
        try {
            
            CSVreader = new BufferedReader(new FileReader(file));
            
            while((row = CSVreader.readLine()) != null) {
                String[] rowArray = row.split(",");
                
                String searchInUsernameColumn = rowArray[3];
                String searchInPasswordColumn = rowArray[4];
                String searchInIDcolumn = rowArray[0];
                
                String salo = "testLine";
                
                if(searchInUsernameColumn.equals(usernameInput) && searchInPasswordColumn.equals(passwordInput)) {
                    try {
                        userID = Integer.parseInt(searchInIDcolumn);
                    } catch(NumberFormatException nfe) {
                        nfe.printStackTrace();
                        userID = -1;
                    }
                    String salo2 = "testLine";
                    break;
                }
                
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                CSVreader.close();
            } catch (IOException ex) {
                Logger.getLogger(DBoperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return userID;
    }
    
}
