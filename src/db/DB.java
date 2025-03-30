package db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Connection conn = null;

    public static Connection getConnection() throws FileNotFoundException, SQLException {
        if(conn == null){

            try {
                Properties props = loadPropeties();
                String url = props.getProperty("dburl");
                String user = props.getProperty("user");
                String password = props.getProperty("password");
                conn = DriverManager.getConnection(url, user, password);
            } catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    public static void closeConnection() {

        try {
            if (conn != null) {
                conn.close();
            }
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
    }

    private static Properties loadPropeties() throws FileNotFoundException{
        try{
            FileInputStream fs = new FileInputStream("db.propeties");
            Properties props = new Properties();
            props.load(fs);

            return props;
        }
        catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void closeStatment(Statement st) {
        if(st != null){
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}
