
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection implements InterfaceDBConnection {
	   
		String BDD = "library_books";
		String url = "jdbc:mysql://localhost:3306/" + BDD;
		String user = "root";
		String passwd = "";
		
	    private Connection conn;
	    private static DBConnection db;
	    
	   
	   private DBConnection() { }
	   
	   public static DBConnection getInstance(){
			if(db == null){
				            db = new DBConnection(); 
				            System.out.println("Nouvelle connexion"); //une nouvelle connexion a été effectuer avec succés 
			               } else {
				                  System.out.println("Existe deja");
                                   }
			               return db; 
		                                      }
		
	    public Connection getConn() {
			return conn;
                                    }
}