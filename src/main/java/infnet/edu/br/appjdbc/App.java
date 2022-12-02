package infnet.edu.br.appjdbc;

import java.sql.SQLException;

public class App {    
    public static void main( String[] args ) throws SQLException, ClassNotFoundException {
    	JdbcUtil.getConnection();
		  System.out.println("Hello!");
    }
}
