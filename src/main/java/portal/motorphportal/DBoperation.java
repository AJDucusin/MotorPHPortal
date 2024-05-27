package portal.motorphportal;


import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBoperation {
    
    private String file = "C:\\Users\\ducus\\Desktop\\MotorPHPortal\\usersdb.csv";
    
    private final List<User> users = new ArrayList<>();
    
    private void LoadUsersData(){
        List<user> users = new ArrayList<>();
        BufferedReader CSVreader = null;
        
        try {
            CSVreader = new BufferedReader(new FileReader(file));
            String header = CSVreader.readLine();
            
            String row;
            while((row = CSVreader.readLine()) != null){
                String[] rowArray = row.split(",");
                int id = Integer.parseInt(rowArray[0].trim()); //Ang .trim() dito ay para tangalin ang whitespaces sa data, mapa unahan or hulihan ng data.
                String firstName = rowArray[1].trim();
                String lastName = rowArray[2].trim();
                String birthday = rowArray[5].trim();
                
                users.add(new User(id, firstName, lastName, birthday));
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
    }
            
            
            
            
    
    public int SearchColumnNum(String queriedColumn){
        String file = "C:\\Users\\ducus\\Desktop\\MotorPHPortal\\usersdb.csv";
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
                
                if(searchInUsernameColumn.equals(usernameInput) && searchInPasswordColumn.equals(passwordInput)) {
                    try {
                        userID = Integer.parseInt(searchInIDcolumn);
                    } catch(NumberFormatException nfe) {
                        nfe.printStackTrace();
                        userID = -1;
                    }
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
    
    
    public void GetInfo(){
    
    }
    
}
