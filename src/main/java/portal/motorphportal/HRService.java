package portal.motorphportal;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;


public class HRService {
    
    private String file = "C:\\Users\\ducus\\Desktop\\MotorPHPortal\\attendancedb.csv";
    
    public double ComputeSalary(String idInput, String fromDateInput, String toDateInput){
        double totalSalary = 0.0;
        boolean header = true;
        
        try{
            
            CSVReader csvReader = new CSVReader(new FileReader(file));
            
            /* VVV date formater, para same formet ng input at ng nasa CSV file VVV */
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            Date fromDate = dateFormat.parse(fromDateInput);
            Date toDate = dateFormat.parse(toDateInput);
            
            String[] row;
            /* VVV Ang while loop sa baba ang mag babasa ng lahat ng row sa CSV file VVV */
            while((row = csvReader.readNext()) != null){
                /* VVV Ang if-statement sa baba ang mag sskip ng header ng CSV file VVV */
                if(header){
                    header = false;
                    continue;
                }
                String rowUserID = row[0];
                Date rowDate = dateFormat.parse(row[4]);
                
                /* VVV galing sa parameter ng method, ang if-statement sa baba ang mag fifilter ng mga kukunin nyang data sa CSV file. Ang kukunin lang nyang data ay sa userID, fromDate, at toDate VVV */
                if(rowUserID.equals(idInput) && !rowDate.before(fromDate) && !rowDate.after(toDate)){
                    String rowLastName = row[1];
                    String rowFirstName = row[2];
                    String rowsSalaryPerHour = row[3];
                    String rowSchedIn = row[5];
                    String rowSchedOut = row[6];
                    String rowTimeIn = row[7];
                    String rowLunchIn = row[8];
                    String rowLunchOut = row[9];
                    String rowTimeOut = row[10];
                    
                    /* VVV ang if-statement sa baba ay ang pag vavalidate kung naka "res" (restday) si user VVV */
                    if(!rowSchedIn.equals("res") && !rowSchedOut.equals("res") && !rowTimeIn.equals("res") && !rowTimeOut.equals("res")){
                        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                        
                        /* VVV ang code sa baba ay ang pag-convert ko ng mga value from db to Date-datatye VVV */
                        Date actualTimeIn = timeFormat.parse(rowTimeIn);
                        Date actualLunchIn = timeFormat.parse(rowLunchIn);
                        Date actualLunchOut = timeFormat.parse(rowLunchOut);
                        Date actualTimeOut = timeFormat.parse(rowTimeOut);
                        
                        /* VVV ang code sa baba ay ang pag compute ko ng actual workhours VVV */
                        long workDurationBeforeLunch = actualLunchIn.getTime() - actualTimeIn.getTime();
                        long workDurationAfterLunch = actualTimeOut.getTime() - actualLunchOut.getTime();
                        long totalWorkDuration = workDurationBeforeLunch + workDurationAfterLunch;
                        
                        /* VVV ang code sa baba ay kinonvert ko ang milisecons to hours VVV */
                        double hoursWorked = (double) totalWorkDuration / (1000*60*60);

                        double convertedSalary = Double.parseDouble(rowsSalaryPerHour);
                        
                        /* VVV dahil kinucompute ang salary per day, kaya '+=' ang ginamit ko VVV */
                        totalSalary += hoursWorked*convertedSalary;
                    }
                    
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return totalSalary;
    }
    
}
