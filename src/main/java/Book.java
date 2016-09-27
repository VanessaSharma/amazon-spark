import org.sql2o.*;
import java.util.List;

public class Book extends Product{
  public String brand;
  public String details= "a";
  public String flavor;
  public String ISBN;
  public int count;
  public String type;
  public int typeId=2;


  public Book(String name, String description, int categoryId, float cost, String author, String ISBN, int pageCount, String type ){
    this.name = name;
    this.description = description;
    this.categoryId = categoryId;
    this.cost = cost;
    this.price = cost *2;
    this.brand = author;
    this.ISBN = ISBN;
    this.count = pageCount;
    this.type = type;
    this.save();
}
public static Book find(int id) {
  try(Connection cn = DB.sql2o.open()) {
    String sql = "SELECT * FROM products WHERE id=:id";
    Book book = cn.createQuery(sql)
      .addParameter("id", id)
      // .addColumnMapping("brand", "author")
      .executeAndFetchFirst(Book.class);
    return book;
  }
}

public static List<Book> allByCategory(int id) {
  String sql = "SELECT * FROM products WHERE categoryId=:id";
  try(Connection cn = DB.sql2o.open()) {
    return cn.createQuery(sql)
    .addParameter("id", id)
    .executeAndFetch(Book.class);
  }
}

public void save() {
  try(Connection con = DB.sql2o.open()) {
    String sql = "INSERT INTO products (name, description, categoryId, price, cost, type, typeId, count, brand, details) VALUES (:name, :description, :categoryId, :price, :cost, :type, :typeId, :count, :brand, :details)";
    this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .addParameter("description", this.description)
      .addParameter("categoryId", this.categoryId)
      .addParameter("price", this.price)
      .addParameter("cost", this.cost)
      .addParameter("type", this.type)
      .addParameter("brand", this.brand)
      .addParameter("details", this.details)
      .addParameter("typeId", this.typeId)
      .addParameter("count", this.count)
      .executeUpdate()
      .getKey();
  }
}


}
