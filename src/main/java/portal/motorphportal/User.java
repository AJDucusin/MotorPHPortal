package portal.motorphportal;


public class User {
    
    //ito ang attributes
    private int id;
    private String first_name;
    private String last_name;
    private String username;
    private String password;
    private String birthday;
    private String address;
    private String phone;
    private String sss;
    private String tin;
    private String pagibig;
    private String status;
    private String designation;
    private String supervisor;
    private String basic_salary;
    private String rice_subsidy;
    private String phone_allowance;
    private String clothing_allowance;
    private String gross_semi_monthly_rate;
    private String hourly_rate;
    private String philhealth;
    
    
    public User(int id, String first_name, String last_name, String username, String password, String birthday, String address, String phone, String sss, String tin, String pagibig, String status, String designation, String supervisor, String basic_salary, String rice_subsidy, String phone_allowance, String clothing_allowance, String gross_semi_monthly_rate, String hourly_rate, String philhealth){
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
        this.sss = sss;
        this.tin = tin;
        this.pagibig = pagibig;
        this.status = status;
        this.designation = designation;
        this.supervisor = supervisor;
        this.basic_salary = basic_salary;
        this.rice_subsidy = rice_subsidy;
        this.phone_allowance = phone_allowance;
        this.clothing_allowance = clothing_allowance;
        this.gross_semi_monthly_rate = gross_semi_monthly_rate;
        this.hourly_rate = hourly_rate;
        this.philhealth = philhealth;
    }
    
    //ito ang getter
    public int getId() { return id; }
    public String getFirstName() { return first_name; }
    public String getLastName() { return last_name; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getBirthday() { return birthday; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public String getSss() { return sss; }
    public String getTin() { return tin; }
    public String getPagibig() { return pagibig; }
    public String getStatus() { return status; }
    public String getDesignation() { return designation; }
    public String getSupervisor() { return supervisor; }
    public String getBasicSalary() { return basic_salary; }
    public String getRiceSubsidy() { return rice_subsidy; }
    public String getPhoneAllowance() { return phone_allowance; }
    public String getClothingAllowance() { return clothing_allowance; }
    public String getGrossSemiMonthlyRate() { return gross_semi_monthly_rate; }
    public String getHourlyRate() { return hourly_rate; }
    public String getPhilhealth() { return philhealth; }
    
}
