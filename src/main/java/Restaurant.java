import java.util.List;
import org.sql2o.*;


public class Restaurant {
  private int id;
  private int address_id;
  private String name;
  private int cuisine_id;
  private String phone;

  public Restaurant(String name, String phone) {
    this.name = name;
    this.phone = phone;
  }

  public int getId() {
    return id;
  }

  public int getAddressId() {
    return address_id;
  }

  public String getName() {
    return name;
  }

  public int getCuisineId() {
    return cuisine_id;
  }

  public String getPhone() {
    return phone;
  }


  @Override
   public boolean equals(Object otherRestaurant) {
     if (!(otherRestaurant instanceof Restaurant)) {
       return false;
     } else {
       Restaurant newRestaurant = (Restaurant) otherRestaurant;
       return this.getId() == newRestaurant.getId() &&
              this.getAddressId() == newRestaurant.getAddressId() &&
              this.getName().equals(newRestaurant.getName()) &&
              this.getCuisineId() == newRestaurant.getCuisineId() &&
              this.getPhone().equals(newRestaurant.getPhone());
     }
   }

  public static List<Restaurant> all() {
    String sql = "SELECT * FROM restaurants";
    try(Connection con = DB.sql2o.open()) {
       return con.createQuery(sql).executeAndFetch(Restaurant.class);
    }
  }

   public void save() {
   try(Connection con = DB.sql2o.open()) {
     String sql = "INSERT INTO restaurants (name,phone) VALUES (:name,:phone)";
     this.id = (int) con.createQuery(sql, true)
       .addParameter("name", this.name)
       .addParameter("phone", this.phone)
       .executeUpdate()
       .getKey();
    }
 }
    public static Restaurant find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM restaurants where id=:id";
      Restaurant restaurant = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Restaurant.class);
      return restaurant;
    }
  }

   public static Restaurant first() {
     return all().get(0);
   }

}
