package Utils;
/*
数据库连接类
连接数据库，并实现各项功能实现的接口（如登录：Login,录入新书本信息：AddBooks------
*/
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DBConnect {
    // database URL
    static final String DATABASE_URL = "jdbc:mysql://47.101.217.136/librarysystem?useUnicode = true & characterEncoding = utf-8 & useSSL = false & &serverTimezone = GMT";
    static private Connection connection = null; // manages connection
    static private Statement statement = null; // query statement
    static private ResultSet resultSet = null; // manages results
    static int READER = 0;  //登录函数中选择登录人的身份
    static int ADMIN = 1;

    public DBConnect() throws ClassNotFoundException, SQLException {   //构造函数
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DATABASE_URL, "root", "password");
            statement = connection.createStatement();
        }
        catch (SQLException | ClassNotFoundException sqlException ) {
            sqlException.printStackTrace();
        } // end catch
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new DBConnect();
    }

} // end class DisplayAuthors






