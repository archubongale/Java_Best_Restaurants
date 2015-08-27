import java.util.List;
import org.sql2o.*;


public class Address {
  private int id;
  private int restaurant_id;
  private int street_number;
  private String street_name;
  private String city;
  private String state;
  private int zip;

  public Address(int street_number, String street_name, String city, String state, int zip) {
    this.street_number = street_number;
    this.street_name = street_name;
    this.city = city;
    this.state = state;
    this.zip = zip;
  }

  public int getStreetNumber() {
    return street_number;
  }

  public String getStreetName() {
    return street_name;
  }

  public String getCity() {
     return city;
  }


  public String getState() {
    return state;
  }

  public int getZip() {
     return zip;
  }

  public int getId() {
    return id;
  }

  public int getRestaurantId() {
    return restaurant_id;
  }

  @Override
  public boolean equals(Object otherAddress) {
    if (!(otherAddress instanceof Address)) {
      return false;
    } else {
      Address newAddress = (Address) otherAddress;
      return this.getId() == newAddress.getId() &&
             this.getRestaurantId() == newAddress.getRestaurantId() &&
             this.getStreetNumber() == newAddress.getStreetNumber() &&
             this.getStreetName().equals(newAddress.getStreetName()) &&
             this.getCity().equals(newAddress.getCity()) &&
             this.getState().equals(newAddress.getState()) &&
             this.getZip() == newAddress.getZip();
    }
  }

  public static List<Address> all() {
    String sql = "SELECT * FROM addresses";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Address.class);
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO addresses (street_number, street_name, city, state, zip) VALUES (:street_number, :street_name, :city, :state, :zip)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("street_number", street_number)
        .addParameter("street_name", street_name)
        .addParameter("city", city)
        .addParameter("state", state)
        .addParameter("zip", zip)
        .executeUpdate()
        .getKey();
    }
  }

  public static Address find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM addresses WHERE id=:id";
      Address address = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Address.class);
      return address;
    }
  }

  public static Address first() {
    return all().get(0);
  }

}
