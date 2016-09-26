import org.sql2o.*;

public class Sales {
 public String saleDate;
 public int customerId;
 public int productId;
 public int id;

 public Sales(int customerId, int productId) {
   this.saleDate = saleDate;
   this.customerId = customerId;
   this.productId = productId;
}
 public String getSaleDate() {
   return saleDate;
 }
 public int getCustomerId() {
   return customerId;
 }
 public int getProductId() {
   return productId;
 }
 public void save() {
   try(Connection con = DB.sql2o.open()) {
     String sql = "INSERT INTO sales  (saleDate, customerId, productId) VALUES ( now(), :customerId, :productId)";
     this.id = (int) con.createQuery(sql, true)
       .addParameter("saleDate", this.saleDate)
       .addParameter("customerId", this.customerId)
       .addParameter("productId", this.productId)
       .executeUpdate()
       .getKey();
   }
 }

}
