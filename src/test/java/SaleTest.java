import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class SaleTest {
  private Sale sale;

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/bookstore_test", null, null);
    sale = new Sale(1, 1, 1 ,1);
  }

  @Test
  public void Sales_instantiates_true() {
    assertEquals(true, sale instanceof Sale);
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM sales *;";
      con.createQuery(sql).executeUpdate();
    }
  }
}
