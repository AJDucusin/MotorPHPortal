package portal.motorphportal;


public class User {
    
    //ito ang attributes
    private int id;
    private String first_name;
    private String last_name;
    private String birthday;
    
    //ito ang method[?]
    public User(int id, String first_name, String last_name, String birthday){
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birthday = birthday;
    }
    
    //ito ang getter
    public int getId() { return id; }
    public String getFirstName() { return first_name; }
    public String getLastName() { return last_name; }
    public String getBirthday() { return birthday; }
    
}
