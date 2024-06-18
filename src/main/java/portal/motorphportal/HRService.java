package portal.motorphportal;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class HRService {
    
    private String file = "C:\\Users\\ducus\\Desktop\\MotorPHPortal\\attendancedb.csv";
    
    /*
    public double ComputeSalary(String idInput, String fromDateInput, String toDateInput){
        double totalSalary = 0.0;
        boolean header = true;
        
        try{
            
            CSVReader csvReader = new CSVReader(new FileReader(file));
            
            // VVV date formater, para same formet ng input at ng nasa CSV file VVV //
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            Date fromDate = dateFormat.parse(fromDateInput);
            Date toDate = dateFormat.parse(toDateInput);
            
            String[] row;
            // VVV Ang while loop sa baba ang mag babasa ng lahat ng row sa CSV file VVV //
            while((row = csvReader.readNext()) != null){
                // VVV Ang if-statement sa baba ang mag sskip ng header ng CSV file VVV //
                if(header){
                    header = false;
                    continue;
                }
                String rowUserID = row[0];
                Date rowDate = dateFormat.parse(row[4]);
                
                // VVV galing sa parameter ng method, ang if-statement sa baba ang mag fifilter ng mga kukunin nyang data sa CSV file. Ang kukunin lang nyang data ay sa userID, fromDate, at toDate VVV //
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
                    
                    // VVV ang if-statement sa baba ay ang pag vavalidate kung naka "res" (restday) si user VVV //
                    if(!rowSchedIn.equals("res") && !rowSchedOut.equals("res") && !rowTimeIn.equals("res") && !rowTimeOut.equals("res")){
                        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                        
                        // VVV ang code sa baba ay ang pag-convert ko ng mga value from db to Date-datatye VVV //
                        Date actualTimeIn = timeFormat.parse(rowTimeIn);
                        Date actualLunchIn = timeFormat.parse(rowLunchIn);
                        Date actualLunchOut = timeFormat.parse(rowLunchOut);
                        Date actualTimeOut = timeFormat.parse(rowTimeOut);
                        
                        // VVV ang code sa baba ay ang pag compute ko ng actual workhours VVV //
                        long workDurationBeforeLunch = actualLunchIn.getTime() - actualTimeIn.getTime();
                        long workDurationAfterLunch = actualTimeOut.getTime() - actualLunchOut.getTime();
                        long totalWorkDuration = workDurationBeforeLunch + workDurationAfterLunch;
                        
                        // VVV ang code sa baba ay kinonvert ko ang milisecons to hours VVV //
                        double hoursWorked = (double) totalWorkDuration / (1000*60*60);

                        double convertedSalary = Double.parseDouble(rowsSalaryPerHour);
                        // VVV dahil kinucompute ang salary per day, kaya '+=' ang ginamit ko VVV //
                        totalSalary += hoursWorked*convertedSalary;
                        
                        String salo = "";
                    }
                    
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return totalSalary;
    }
    */
    
    
    
    
    // Ito ang working na ComputeSalary na mayroong VL
    public double ComputeSalary(String idInput, String fromDateInput, String toDateInput){
        double totalSalary = 0.0;
        boolean header = true;
        
        try{
            
            CSVReader csvReader = new CSVReader(new FileReader(file));
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            Date fromDate = dateFormat.parse(fromDateInput);
            Date toDate = dateFormat.parse(toDateInput);
            
            String[] row;
            
            while((row = csvReader.readNext()) != null){
                
                if(header){
                    header = false;
                    continue;
                }
                String rowUserID = row[0];
                Date rowDate = dateFormat.parse(row[4]);
                
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
                    
                    if(rowSchedIn.equals("vl") && rowSchedOut.equals("vl")) {
                        
                        double convertedSalary = Double.parseDouble(rowsSalaryPerHour);
                        totalSalary += 8*convertedSalary;
                        
                    } else if(!rowSchedIn.equals("res") && !rowSchedOut.equals("res")){
                        
                        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                        
                        if(rowTimeIn == null || rowTimeIn.isEmpty() || rowLunchIn == null || rowLunchIn.isEmpty() ||
                        rowLunchOut == null || rowLunchOut.isEmpty() || rowTimeOut == null || rowTimeOut.isEmpty()) {
                            continue;
                        } else {
                            Date actualTimeIn = timeFormat.parse(rowTimeIn);
                            Date actualLunchIn = timeFormat.parse(rowLunchIn);
                            Date actualLunchOut = timeFormat.parse(rowLunchOut);
                            Date actualTimeOut = timeFormat.parse(rowTimeOut);
                        
                            double workDurationBeforeLunch = actualLunchIn.getTime() - actualTimeIn.getTime();
                            double workDurationAfterLunch = actualTimeOut.getTime() - actualLunchOut.getTime();
                            double totalWorkDuration = workDurationBeforeLunch + workDurationAfterLunch;
                        
                            double hoursWorked = (double) totalWorkDuration / (1000*60*60);
                            double convertedSalary = Double.parseDouble(rowsSalaryPerHour);
                            totalSalary += hoursWorked*convertedSalary;
                        }
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return totalSalary;
    }
    
    
    
    /* // Backup
    public double ComputeSalary(String idInput, String fromDateInput, String toDateInput){
        double totalSalary = 0.0;
        boolean header = true;
        
        try{
            
            CSVReader csvReader = new CSVReader(new FileReader(file));
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            Date fromDate = dateFormat.parse(fromDateInput);
            Date toDate = dateFormat.parse(toDateInput);
            
            String[] row;
            
            while((row = csvReader.readNext()) != null){
                
                if(header){
                    header = false;
                    continue;
                }
                String rowUserID = row[0];
                Date rowDate = dateFormat.parse(row[4]);
                
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
                    
                    if(rowSchedIn.equals("vl") && rowSchedOut.equals("vl")) {
                        
                        double convertedSalary = Double.parseDouble(rowsSalaryPerHour);
                        totalSalary += 8*convertedSalary;
                        
                    } else if(!rowSchedIn.equals("res") && !rowSchedOut.equals("res")){
                        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                        Date actualTimeIn;
                        Date actualLunchIn;
                        Date actualLunchOut;
                        Date actualTimeOut;
                        
                        if(rowTimeIn == null && rowLunchIn == null && rowLunchOut == null && rowTimeOut == null){
                            actualTimeIn = timeFormat.parse("00:00");
                            actualLunchIn = timeFormat.parse("00:00");
                            actualLunchOut = timeFormat.parse("00:00");
                            actualTimeOut = timeFormat.parse("00:00");
                            continue;
                        } else {
                            actualTimeIn = timeFormat.parse(rowTimeIn);
                            actualLunchIn = timeFormat.parse(rowLunchIn);
                            actualLunchOut = timeFormat.parse(rowLunchOut);
                            actualTimeOut = timeFormat.parse(rowTimeOut);
                            
                        }
                        double workDurationBeforeLunch = actualLunchIn.getTime() - actualTimeIn.getTime();
                        double workDurationAfterLunch = actualTimeOut.getTime() - actualLunchOut.getTime();
                        double totalWorkDuration = workDurationBeforeLunch + workDurationAfterLunch;
                        
                        double hoursWorked = (double) totalWorkDuration / (1000*60*60);
                        double convertedSalary = Double.parseDouble(rowsSalaryPerHour);
                        totalSalary += hoursWorked*convertedSalary;
                    
                    }
                    
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return totalSalary;
    }
    */
    
    
    
    public int ComputeWorkedDays(String idInput, String fromDateInput, String toDateInput) {
        boolean header = true;
        int workedDays = 0;
        
        try {
            
            CSVReader csvReader = new CSVReader(new FileReader(file));
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            Date formattedFromDate = dateFormat.parse(fromDateInput);
            Date formattedToDate = dateFormat.parse(toDateInput);
            
            String[] row;
            while((row = csvReader.readNext()) != null) {
                if(header) {
                    header = false;
                    continue;
                }
                String rowUserID = row[0];
                Date rowDate = dateFormat.parse(row[4]);
                
                if(rowUserID.equals(idInput) && !rowDate.before(formattedFromDate) && !rowDate.after(formattedToDate)) {
                    String rowSchedIn = row[5];
                    String rowSchedOut = row[6];

                    if(rowSchedIn.equals("res") && rowSchedOut.equals("res")) {
                        workedDays += 0;
                    } else if (rowSchedIn.equals("vl") && rowSchedOut.equals("vl")) {
                        workedDays += 0;
                    } else {
                        workedDays += 1;
                    }
                    
                }
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        return workedDays;
    }
    
    
    
    
    public int ComputeVL(String idInput, String fromDateInput, String toDateInput) {
        boolean header = true;
        int vacationLeave = 0;
        
        try {
            
            CSVReader csvReader = new CSVReader(new FileReader(file));
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            Date formattedFromDate = dateFormat.parse(fromDateInput);
            Date formattedToDate = dateFormat.parse(toDateInput);
            
            String[] row;
            while((row = csvReader.readNext()) != null) {
                if(header) {
                    header = false;
                    continue;
                }
                String rowUserID = row[0];
                Date rowDate = dateFormat.parse(row[4]);
                
                if(rowUserID.equals(idInput) && !rowDate.before(formattedFromDate) && !rowDate.after(formattedToDate)) {
                    String rowSchedIn = row[5];
                    String rowSchedOut = row[6];

                    if(rowSchedIn.equals("vl") && rowSchedOut.equals("vl")) {
                        vacationLeave += 1;
                    }
                }
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        return vacationLeave;
    }
    
    
    
    
    public double ComputeLateHours(String idInput, String fromDateInput, String toDateInput) {
        boolean header = true;
        double totalLateHrs = 0.0;
        
        try {
            CSVReader csvReader = new CSVReader(new FileReader(file));
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            Date formattedFromDate = dateFormat.parse(fromDateInput);
            Date formattedToDate = dateFormat.parse(toDateInput);
            
            String[] row;
            while((row = csvReader.readNext()) != null) {
                if(header) {
                    header = false;
                    continue;
                }
                String rowUserID = row[0];
                Date rowDate = dateFormat.parse(row[4]);
                
                if(rowUserID.equals(idInput) && !rowDate.before(formattedFromDate) && !rowDate.after(formattedToDate)){
                    String rowLastName = row[1];
                    String rowFirstName = row[2];
                    String rowsSalaryPerHour = row[3];
                    String rowSchedIn = row[5];
                    String rowSchedOut = row[6];
                    String rowTimeIn = row[7];
                    String rowLunchIn = row[8];
                    String rowLunchOut = row[9];
                    String rowTimeOut = row[10];
                    
                    if(rowTimeIn == null || rowTimeIn.isEmpty() || rowLunchIn == null || rowLunchIn.isEmpty() ||
                        rowLunchOut == null || rowLunchOut.isEmpty() || rowTimeOut == null || rowTimeOut.isEmpty()) {
                        continue;
                    } else if(rowSchedIn.equals("vl") && rowSchedOut.equals("vl")) {
                        totalLateHrs += 0.0;
                    } else if(!rowSchedIn.equals("res") && !rowSchedOut.equals("res")){
                        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                        Date actualTimeIn = timeFormat.parse(rowTimeIn);
                        Date actualLunchIn = timeFormat.parse(rowLunchIn);
                        Date actualLunchOut = timeFormat.parse(rowLunchOut);
                        Date actualTimeOut = timeFormat.parse(rowTimeOut);
                        
                        double workDurationBeforeLunch = actualLunchIn.getTime() - actualTimeIn.getTime();
                        double workDurationAfterLunch = actualTimeOut.getTime() - actualLunchOut.getTime();
                        double totalWorkDuration = workDurationBeforeLunch + workDurationAfterLunch;
                        
                        double hoursWorked = (double) totalWorkDuration / (1000*60*60);
                        if(hoursWorked < 8.0) {
                            totalLateHrs += 8.0 - hoursWorked;
                            String salo = "";
                        }
                        //double convertedSalary = Double.parseDouble(rowsSalaryPerHour);
                        //totalLateHrs += hoursWorked*convertedSalary;
                    } else {
                        totalLateHrs += 0.0;
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return totalLateHrs;
    }
    
    
    
    
    public int ComputeAbsences(String idInput, String fromDateInput, String toDateInput) {
        boolean header = true;
        int totalAbsences = 0;
        
        try {
            CSVReader csvReader = new CSVReader(new FileReader(file));
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            Date formattedFromDate = dateFormat.parse(fromDateInput);
            Date formattedToDate = dateFormat.parse(toDateInput);
            
            String[] row;
            while((row = csvReader.readNext()) != null) {
                if(header) {
                    header = false;
                    continue;
                }
                String rowUserID = row[0];
                Date rowDate = dateFormat.parse(row[4]);
                
                if(rowUserID.equals(idInput) && !rowDate.before(formattedFromDate) && !rowDate.after(formattedToDate)){
                    String rowLastName = row[1];
                    String rowFirstName = row[2];
                    String rowsSalaryPerHour = row[3];
                    String rowSchedIn = row[5];
                    String rowSchedOut = row[6];
                    String rowTimeIn = row[7];
                    String rowLunchIn = row[8];
                    String rowLunchOut = row[9];
                    String rowTimeOut = row[10];
                    
                    if(rowTimeIn == null || rowTimeIn.isEmpty() || rowLunchIn == null || rowLunchIn.isEmpty() ||
                        rowLunchOut == null || rowLunchOut.isEmpty() || rowTimeOut == null || rowTimeOut.isEmpty()) {
                        totalAbsences += 1;
                    } else {
                        totalAbsences += 0;
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return totalAbsences;
    }
    
    
    
    
    public List<String[]> GetUserScheduleForMonth(String idInput, int month, int year) {
        List<String[]> filteredSchedule = new ArrayList<>();
        boolean header = true;
        
        try {
            
            CSVReader csvReader = new CSVReader(new FileReader(file));
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            
            String[] row;
            while((row = csvReader.readNext()) != null) {
                if(header) {
                    header = false;
                    String[] headers = {"Date", "Sched In", "Sched Out"};
                    filteredSchedule.add(headers);
                    continue;
                }
                
                String rowUserId = row[0];
                Date rowDate = dateFormat.parse(row[4]);
                int rowMonth = rowDate.getMonth()+1;
                int rowYear = rowDate.getYear()+1900;
                
                if(rowUserId.equals(idInput) && rowMonth == month && rowYear == year) {
                    
                    String[] dataToAdd = new String[3];
                    dataToAdd[0] = row[4];
                    dataToAdd[1] = row[5];
                    dataToAdd[2] = row[6];
                    
                    filteredSchedule.add(dataToAdd);
                }
                
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return filteredSchedule;
    }
    
    
}
