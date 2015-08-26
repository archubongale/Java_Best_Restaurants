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


 // //    @Override
 //   public boolean equals(Object otherCuisine) {
 //     if (!(otherCuisine instanceof Cuisines)) {
 //       return false;
 //     } else {
 //       Cuisines newCuisine = (Cuisines) otherCuisine;
 //       return this.getId() == newCuisine.getId() && // == for primitive equality
 //              this.getType().equals(newCuisine.getType()); // .equals for object equality
 //     }
 //   }
 //
 //   public static List<Cuisines> all() {
 //   String sql = "SELECT * FROM cuisines";
 //   try(Connection con = DB.sql2o.open()) {
 //     return con.createQuery(sql).executeAndFetch(Cuisines.class);
 //   }
 //  }
 //
 //   public void save() {
 //   try(Connection con = DB.sql2o.open()) {
 //     String sql = "INSERT INTO cuisines (type) VALUES (:type)";
 //     this.id = (int) con.createQuery(sql, true)
 //       .addParameter("type", type)
 //       .executeUpdate()
 //       .getKey();
 //    }
 // }
 //    public static Cuisines find(int id) {
 //    try(Connection con = DB.sql2o.open()) {
 //      String sql = "SELECT * FROM cuisines where id=:id";
 //      Cuisines cuisine = con.createQuery(sql)
 //        .addParameter("id", id)
 //        .executeAndFetchFirst(Cuisines.class);
 //      return cuisine;
 //    }
 //  }
 //
 //   public static Cuisines first() {
 //     return all().get(0);
 //   }

}
