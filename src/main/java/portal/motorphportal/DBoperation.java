package portal.motorphportal;


import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import portal.motorphportal.User;


public class DBoperation {
    
    private String file = "C:\\Users\\Abdul-JohariDucusin\\OneDrive - Paynamics Technologies Inc\\Desktop\\MotorPHPortal\\usersdb.csv";
    
    public User LoadUsersData(String usernameInput, String passwordInput){
        BufferedReader CSVreader = null;
        User users = null;
        
        try {
            CSVreader = new BufferedReader(new FileReader(file));
            String header = CSVreader.readLine();
            
            String row;
            while((row = CSVreader.readLine()) != null){
                String[] rowArray = row.split(",");
                int id = Integer.parseInt(rowArray[0].trim()); //Ang .trim() dito ay para tangalin ang whitespaces sa data, mapa unahan or hulihan ng data.
                String firstName = rowArray[1].trim();
                String lastName = rowArray[2].trim();
                String username = rowArray[3].trim();
                String password = rowArray[4].trim();
                String birthday = rowArray[5].trim();
                String address = rowArray[6].trim();
                String phone = rowArray[7].trim();
                String sss = rowArray[8].trim();
                String tin = rowArray[9].trim();
                String pagibig = rowArray[10].trim();
                String status = rowArray[11].trim();
                String designation = rowArray[12].trim();
                String supervisor = rowArray[13].trim();
                String basicSalary = rowArray[14].trim();
                String riceSubsidy = rowArray[15].trim();
                String phoneAllowance = rowArray[16].trim();
                String clothingAllowance = rowArray[17].trim();
                String grossSemiMonthlyRate = rowArray[18].trim();
                String hourlyRate = rowArray[19].trim();
                String philhealth = rowArray[20].trim();
                if(username.equals(usernameInput) && password.equals(passwordInput)){
                    users = new User(id, firstName, lastName, username, password, birthday, address, phone, sss, tin, pagibig, status, designation, supervisor, basicSalary, riceSubsidy, phoneAllowance, clothingAllowance, grossSemiMonthlyRate, hourlyRate, philhealth);
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
        return users;
    }

    
    public boolean LoginUser(String username, String password) {
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
    
}
