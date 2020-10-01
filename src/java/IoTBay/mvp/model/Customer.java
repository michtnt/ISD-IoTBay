package IoTBay.mvp.model;
/**
 *
 * @author ASUS
 */
public class Customer 
{
    int id;
    String username, password, email, Firstname, Lastname, address;
    boolean active;

    
    public Customer(int id, String username, String Firstname, String Lastname, String address, String email, String password, boolean active) {
        this.id = id;
        this.username = username;
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.password = password;
        this.email = email;
        this.active = active;
        this.address = address;

    }
    public String getId() {
        return Integer.toString(id);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String Firstname) 
    {
        this.Firstname = Firstname;
    }

    public String getLastname() 
    {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }
    
}
