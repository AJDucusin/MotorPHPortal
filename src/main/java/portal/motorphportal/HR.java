package portal.motorphportal;


public class HR {
    
    //Attributes
    private int userID;
    private String lastName;
    private String firstName;
    private String workedDays;
    private String totalHours;
    private String vacationLeave;
    private String undertime;
    
    public HR(int userID, String lastName, String firstName, String workedDays, String totalHours, String vacationLeave, String undertime) {
        
        this.userID = userID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.workedDays = workedDays;
        this.totalHours = totalHours;
        this.vacationLeave = vacationLeave;
        this.undertime = undertime;
        
    }
    
    public int getUserID() { return userID; }
    public String getLastName() { return lastName; }
    public String getFistName() { return firstName; }
    public String getWorkedDays() { return workedDays; }
    public String getTotalHours() { return totalHours; }
    public String getVacationLeave() { return vacationLeave; }
    public String getUndertime() { return undertime; }
    
}
