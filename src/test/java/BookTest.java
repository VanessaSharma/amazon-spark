// import org.sql2o.*;
// import org.junit.*;
// import static org.junit.Assert.*;
//
// public class BookTest {
//   private Book book;
//   private Book book2;
//   private Book book3;
//
//   @Before
//   public void setUp() {
//     DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/bookstore_test", null, null);
//     book = new Book("My Little Dragon", "A fantastic story about a little dragon in Narnia.", 1, 2);
//     book2 = new Book("How to Be the Greatest Ever", "Donald Trump narrates how he became the greatest person to ever live.", 2, 100);
//     book3 = new Book("The Cowboy and his Milk Girl", "A lonely cowboy finds himself lost, until a mysterious milk girl saves him from his misery.", 3, 10);
//   }
//
//   @Test
//   public void Book_instantiates_true() {
//     assertEquals(true, book instanceof Book);
//   }
//   // @Test
//   // public void find_returnCorrectBook_true() {
//   //   assertTrue Book.find(book.getId()).equals(book));
//   // }
//   @Test
//   public void all_returnsAllInstances_true() {
//     assertTrue (Book.all().size()>1);
//   }
//   // @Test
//   // public void allByCategory_returnsInstancesByCategory_true() {
//   //   assertTrue Book.allByCategory(3).get(0).getName().equals("The Cowboy and his Milk Girl"));
//   // }
//
//   @After
//   public void tearDown() {
//     try(Connection con = DB.sql2o.open()) {
//       String sql = "DELETE FROM books *;";
//       con.createQuery(sql).executeUpdate();
//     }
//   }
// }
