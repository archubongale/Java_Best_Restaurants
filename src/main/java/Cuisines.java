import java.util.*;
import org.sql2o.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Cuisines {
  private int id;
  private String type;


  public Cuisines(int id,String type) {
    this.id = id;
    this.type = type;
  }

  public int getId() {
    return id;
  }

  public String getType() {
    return type;
  }
//
//   @Override
//   public boolean equals(Object otherPatient) {
//     if (!(otherPatient instanceof Patient)) {
//       return false;
//     } else {
//       Patient newPatient = (Patient) otherPatient;
//       return this.getPatientName().equals(newPatient.getPatientName()) &&
//              this.getId() == newPatient.getId() &&
//              this.getDob() == newPatient.getDob() &&
//              this.getDoctorId() == newPatient.getDoctorId();
//     }
//   }
//
//   public static List<Patient> all() {
//   String sql = "SELECT * FROM patients";
//   try(Connection con = DB.sql2o.open()) {
//     return con.createQuery(sql).executeAndFetch(Patient.class);
//   }
//  }
//
//   public void save() {
//   try(Connection con = DB.sql2o.open()) {
//     String sql = "INSERT INTO patients (patient_name, doctor_id, dob) VALUES (:patient_name, :doctor_id, :dob)";
//     this.id = (int) con.createQuery(sql, true)
//       .addParameter("patient_name", patient_name)
//       .addParameter("doctor_id", doctor_id)
//       .addParameter("dob", dob)
//       .executeUpdate()
//       .getKey();
//    }
// }
//    public static Patient find(int id) {
//    try(Connection con = DB.sql2o.open()) {
//      String sql = "SELECT * FROM patients where id=:id";
//      Patient patient = con.createQuery(sql)
//        .addParameter("id", id)
//        .executeAndFetchFirst(Patient.class);
//      return patient;
//    }
//  }

}
