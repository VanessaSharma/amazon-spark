import org.sql2o.*;
import java.sql.Timestamp;

public class Sale {
 private Timestamp saleDate;
 private int customerId;
 private int bookId;
 private int chocolateId;
 private int wineId;
 private int id;
 private Book book;
 private Wine wine;
 private Chocolate chocolate;
 private Customer customer;

 public Sale(int customerId, int bookId, int chocolateId, int wineId) {
   this.customerId = customerId;
   this.bookId = bookId;
   this.chocolateId= chocolateId;
   this.wineId = wineId;
   this.save();
   book=Book.find(bookId);
   customer=Customer.find(customerId);
   chocolate= Chocolate.find(chocolateId);
   wine=Wine.find(wineId);
}
 public Timestamp getSaleDate() {
   return saleDate;
 }

 public Book getBook() {
   return book;
 }

 public Customer getCustomer() {
   return customer;
 }

 public int getCustomerId() {
   return customerId;
 }

 public int getBookId() {
   return bookId;
 }
 public int getChocolateId() {
   return chocolateId;
 }
 public int getWineId() {
   return wineId;
 }

 public void save() {
   try(Connection con = DB.sql2o.open()) {
     String sql = "INSERT INTO sales (saledate, customerid, bookid, chocolateid, wineid) VALUES (now(), :customerId, :bookId, :chocolateId, :wineId)";
     this.id = (int) con.createQuery(sql, true)
       .addParameter("customerId", this.customerId)
       .addParameter("bookId", this.bookId)
       .addParameter("chocolateId", this.chocolateId)
       .addParameter("wineId", this.wineId)
       .executeUpdate()
       .getKey();
   }
 }

}
