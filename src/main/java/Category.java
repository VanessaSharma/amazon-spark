import org.sql2o.*;
import java.util.List;

public class Category {
  public String name;
  public int id;

  public Category(String name) {
    this.name = name;
    this.save();
  }
  public String getName(){
    return  name;
  }
  public int getId() {
    return id;
  }
  public static List<Category> all() {
    String sql = "SELECT * FROM categories ORDER BY name";
    try(Connection cn = DB.sql2o.open()) {
      return cn.createQuery(sql).executeAndFetch(Category.class);
    }
  }
  public static Category find(int id) {
    try(Connection cn = DB.sql2o.open()) {
      String sql = "SELECT * FROM categories WHERE id=:id";
      Category category = cn.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Category.class);
      return category;
    }
  }


  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO categories (name) VALUES (:name)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .executeUpdate()
        .getKey();
    }
  }

  }
