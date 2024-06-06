package portal.motorphportal;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class UserService {
    
    private String file = "C:\\Users\\ducus\\Desktop\\MotorPHPortal\\usersdb.csv";
    
    public User LoadUsersDataByID(String userID){
        User users = null;
        boolean header = true;
        
        try {
            CSVReader csvReader = new CSVReader(new FileReader(file));
            String[] row;
            while((row = csvReader.readNext()) != null){
                if(header){
                    header = false;
                    continue;
                }
                String empId = row[0];
                if(empId.equals(userID)){
                    int id = Integer.parseInt(row[0]);
                    String firstName = row[1];
                    String lastName = row[2];
                    String username = row[3];
                    String password = row[4];
                    String birthday = row[5];
                    String address = row[6];
                    String phone = row[7];
                    String sss = row[8];
                    String tin = row[9];
                    String pagibig = row[10];
                    String status = row[11];
                    String designation = row[12];
                    String supervisor = row[13];
                    String basicSalary = row[14];
                    String riceSubsidy = row[15];
                    String phoneAllowance = row[16];
                    String clothingAllowance = row[17];
                    String grossSemiMonthlyRate = row[18];
                    String hourlyRate = row[19];
                    String philhealth = row[20];
                    users = new User(id, firstName, lastName, username, password, birthday, address, phone, sss, tin, pagibig, status, designation, supervisor, basicSalary, riceSubsidy, phoneAllowance, clothingAllowance, grossSemiMonthlyRate, hourlyRate, philhealth);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return users;
    }
    
    public User LoadUsersData(String usernameInput, String passwordInput){
        User users = null;
        boolean header = true;
        
        try {
            CSVReader csvReader = new CSVReader(new FileReader(file));
            String[] row;
            while((row = csvReader.readNext()) != null){
                if(header){
                    header = false;
                    continue;
                }
                int id = Integer.parseInt(row[0]);
                String firstName = row[1];
                String lastName = row[2];
                String username = row[3];
                String password = row[4];
                String birthday = row[5];
                String address = row[6];
                String phone = row[7];
                String sss = row[8];
                String tin = row[9];
                String pagibig = row[10];
                String status = row[11];
                String designation = row[12];
                String supervisor = row[13];
                String basicSalary = row[14];
                String riceSubsidy = row[15];
                String phoneAllowance = row[16];
                String clothingAllowance = row[17];
                String grossSemiMonthlyRate = row[18];
                String hourlyRate = row[19];
                String philhealth = row[20];
                if(username.equals(usernameInput) && password.equals(passwordInput)){
                    users = new User(id, firstName, lastName, username, password, birthday, address, phone, sss, tin, pagibig, status, designation, supervisor, basicSalary, riceSubsidy, phoneAllowance, clothingAllowance, grossSemiMonthlyRate, hourlyRate, philhealth);
                    break;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return users;
    }
    
    
    // VVV Ang behavior ng method na ito sa baba ay; ireread nya lahat ng row sa table, ilalagay nya sa array list, i-skip nya ang row na buburahin, irere-write nya ulit ang buong csv file.
    public void DeleteUserData(String idToDelete) {
        List<String[]> allDataInRows = new ArrayList<>(); // <<< ito ang array na paglalagyan ng lahat ng data galing sa csv.
        boolean header = true;
        
        try {
            CSVReader csvReader = new CSVReader(new FileReader(file));
            
            String[] row;    
            while((row = csvReader.readNext()) != null){
                if(header){ // <<< ang if-statement na ito ay para i-skip nya ang header. Pinag iisipan kong burahin ang part na ito.
                    header = false;
                    allDataInRows.add(row);
                    continue;
                }
                String id = row[0];
                if(!id.equals(idToDelete)){ // <<< ito ang part na dinadagdag nya lahat ng rows of data sa loob ng array list. Dito rin sa part na ito sya nag sskip ng buburahing data.
                    allDataInRows.add(row);
                }
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        // VVV  ito ang part na nirere-write na nya ulit ang lahat ng data sa CSV file.
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(file))) {
            csvWriter.writeAll(allDataInRows);
        } catch(IOException e){
            e.printStackTrace();
        }
    
    }
    
    
    /*
    public void UpdateUserData(String idToUpdate, String firstName, String lastName, String username, String password, String birthday, String address, String phone, String sss, String tin, String pagibig, String status, String designation, String supervisor, String basicSalary, String riceSubsidy, String phoneAllowance, String clothingAllowance, String grossSemiMonthlyRate, String hourlyRate, String philhealth) {
        
    }
    */
    
    
    public void UpdateUserData(String idToUpdate, String[] updatedData){
        List<String[]> allData = new ArrayList<>();
        boolean header = true;
        
        try {
            CSVReader csvReader = new CSVReader(new FileReader(file));
            String[] row;
            while((row = csvReader.readNext()) != null){
                if(header) {
                    header = false;
                    allData.add(row);
                    continue;
                }
                String id = row[0];
                if(id.equals(idToUpdate)){
                    allData.add(updatedData);
                } else {
                    allData.add(row);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(file));) {
            csvWriter.writeAll(allData);
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
    
    public boolean LoginUser(String usernameInput, String passwordInput){
        boolean header = true;
        boolean allowLogin = false;
        
        try {
            CSVReader csvReader = new CSVReader(new FileReader(file));
            String[] row;
            while((row = csvReader.readNext()) != null){
                if(header){
                    header = false;
                    continue;
                }
                String username = row[3];
                String password = row[4];
                if(username.equals(usernameInput) && password.equals(passwordInput)){
                    allowLogin = true;
                    break;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return allowLogin;
    }
    
}
