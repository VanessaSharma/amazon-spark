import org.sql2o.*;
import java.util.List;

public class Customer {
  private int id=0;
  private String firstname;
  private String lastname;
  private String phonenumber;
  private String address;
  private String city;
  private String state;
  private int zip;
  private String email;

  public Customer(String firstname, String lastname, String phone, String street, String city, String state, int zip, String email) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.phonenumber = phone;
    this.address = street;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.email = email;

    try(Connection cn = DB.sql2o.open()) {
      String sql = "INSERT INTO customers (firstname, lastname, phonenumber, address, city, state, zip, email) VALUES (:firstname, :lastname, :phonenumber, :address, :city, :state, :zip, :email)";
      this.id = (int) cn.createQuery(sql, true)
        .addParameter("lastname", this.lastname)
        .addParameter("firstname", this.firstname)
        .addParameter("phonenumber", this.phonenumber)
        .addParameter("address", this.address)
        .addParameter("city", this.city)
        .addParameter("state", this.state)
        .addParameter("zip", this.zip)
        .addParameter("email", this.email)
        .executeUpdate()
        .getKey();
    }

  }

  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstname;
  }

  public void setFirstName(String name) {
    this.firstname=name;
    try(Connection cn = DB.sql2o.open()) {
      String sql = "UPDATE customers SET firstname = :firstname WHERE id = :id";
      cn.createQuery(sql)
        .addParameter("firstname", name)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public String getLastName() {
    return lastname;
  }

  public void setLastName(String name) {
    this.lastname=name;
    try(Connection cn = DB.sql2o.open()) {
      String sql = "UPDATE customers SET lastname = :lastname WHERE id = :id";
      cn.createQuery(sql)
        .addParameter("lastname", name)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public String getPhoneNumber() {
    return phonenumber;
  }

  public void setPhoneNumber(String phone) {
    this.phonenumber=phone;
    try(Connection cn = DB.sql2o.open()) {
      String sql = "UPDATE customers SET phonenumber = :phonenumber WHERE id = :id";
      cn.createQuery(sql)
        .addParameter("phonenumber", phone)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address=address;
    try(Connection cn = DB.sql2o.open()) {
      String sql = "UPDATE customers SET address = :address WHERE id = :id";
      cn.createQuery(sql)
        .addParameter("address", address)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city=city;
    try(Connection cn = DB.sql2o.open()) {
      String sql = "UPDATE customers SET city = :city WHERE id = :id";
      cn.createQuery(sql)
        .addParameter("city", city)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state=state;
    try(Connection cn = DB.sql2o.open()) {
      String sql = "UPDATE customers SET state = :state WHERE id = :id";
      cn.createQuery(sql)
        .addParameter("state", state)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public int getZip() {
    return zip;
  }

  public void setZip(int zip) {
    this.zip=zip;
    try(Connection cn = DB.sql2o.open()) {
      String sql = "UPDATE customers SET zip = :zip WHERE id = :id";
      cn.createQuery(sql)
        .addParameter("zip", zip)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email=email;
    try(Connection cn = DB.sql2o.open()) {
      String sql = "UPDATE customers SET email = :email WHERE id = :id";
      cn.createQuery(sql)
        .addParameter("email", email)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public static Customer find(int id) {
    try(Connection cn = DB.sql2o.open()) {
      String sql = "SELECT * FROM customers WHERE id=:id";
      Customer customer = cn.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Customer.class);
      return customer;
    }
  }

  public static List<Customer> all() {
    String sql = "SELECT * FROM customers ORDER BY lastname, firstname";
    try(Connection cn = DB.sql2o.open()) {
      return cn.createQuery(sql).executeAndFetch(Customer.class);
    }
  }

  public static void delete(int id) {
    try(Connection cn = DB.sql2o.open()) {
      String sql = "DELETE FROM customers WHERE id = :id;";
      cn.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }

}
