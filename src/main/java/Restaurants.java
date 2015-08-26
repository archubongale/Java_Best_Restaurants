import java.util.List;
import org.sql2o.*;


public class Restaurants {
  private int id;
  private int address_id;
  private String name;
  private int cuisine_id;
  private String phone;

  public Restaurants(int address_id, String name, int cuisine_id, String phone) {
    this.address_id = address_id;
    this.name = name;
    this.cuisine_id = cuisine_id;
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
     if (!(otherRestaurant instanceof Restaurants)) {
       return false;
     } else {
       Restaurants newRestaurant = (Restaurants) otherRestaurant;
       return this.getId() == newRestaurant.getId() &&
              this.getAddressId() == newRestaurant.getAddressId() && // == for primitive equality
              this.getName().equals(newRestaurant.getName()) &&
              this.getCuisineId() == newRestaurant.getCuisineId() &&
              this.getPhone().equals(newRestaurant.getPhone()); // .equals for object equality
     }
   }

   public static List<Restaurants> all() {
     String sql = "SELECT * FROM restaurants";
      try(Connection con = DB.sql2o.open()) {
        return con.createQuery(sql).executeAndFetch(Restaurants.class);
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
    public static Restaurants find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM restaurants where id=:id";
      Restaurants restaurant = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Restaurants.class);
      return restaurant;
    }
  }

   public static Restaurants first() {
     return all().get(0);
   }

}
