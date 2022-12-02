package infnet.edu.br.appjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class JdbcUtil {

    private static Logger logger = LoggerFactory.getLogger(JdbcUtil.class);
    
    public static Connection getConnection() {
        logger.info("Starting database connection");
        String password = "root";
        String user= "root";
        String url = "jdbc:mysql://localhost:3366/jdbcapp?createDatabaseIfNotExist=true";
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            logger.error("Connection error", e);
            throw new RuntimeException(e);
        }
    }
}
