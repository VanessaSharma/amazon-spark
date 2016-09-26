import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class SalesTest {
  private Sales sales = new Sales(1, 1);

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/bookstore_test", null, null);
  }

  @Test
  public void Sales_instantiates_true() {
    assertEquals(true, sales instanceof Sales);
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM sales *;";
      con.createQuery(sql).executeUpdate();
    }
  }
}
