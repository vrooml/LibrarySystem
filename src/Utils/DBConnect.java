package Utils;
/*
数据库连接类
连接数据库，并实现各项功能实现的接口（如登录：Login,录入新书本信息：AddBooks------
*/
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DBConnect {
    // database URL
    static final String DATABASE_URL = "jdbc:mysql://47.101.217.136/librarysystem?useUnicode = true & characterEncoding = utf-8 & useSSL = false & &serverTimezone = GMT";
    static private Connection connection = null; // manages connection
    static private Statement statement = null; // query statement
    static private ResultSet resultSet = null; // manages results
    static final public Integer BORROW_BOOK_NUM_LIMITS = new Integer(5);   //常量，借书最大数


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


    /*
    检验读者ID是否存在函数
    传入参数：ID字符串
    返回值： 存在返回true，反之返回false
     */
    public boolean isReaderIdExist(String ID) throws SQLException {
        String cnt = new String();
        String sql = "select count(*) from userlogin where readerId = \"" + ID + "\";";   //构建sql语句，查询ID是否存在
        resultSet = statement.executeQuery(sql);
        while(resultSet.next())
            cnt = resultSet.getObject(1).toString();
        return cnt.equals("1");
    }

    /*
    检验管理员ID是否存在函数
    传入参数：ID字符串
    返回值： 存在返回true，反之返回false
    */
    public boolean isAdminIdExist(String ID) throws SQLException {
        String cnt = new String();
        String sql = "select count(*) from adminlogin where adminId = \"" + ID + "\";";   //构建sql语句，查询ID是否存在
        resultSet = statement.executeQuery(sql);
        while(resultSet.next())
            cnt = resultSet.getObject(1).toString();
        return cnt.equals("1");
    }


    /*
    读者登录函数
    传入参数为：ID和密码的字符串
    返回值：int 0（登录成功） 1（账号不存在） 2 （账号与密码不匹配）
     */
    public int readerLogin(String ID, String password) throws SQLException {
        String sql = new String();
        String result = new String();
        int ret = 1;
        if(isReaderIdExist(ID)){
            sql = "select count(*) from userlogin where readerId = \"" + ID + "\" and readerPassword = \"" + password + "\";";
            resultSet = statement.executeQuery(sql);   //sql语句执行
            while(resultSet.next())
                result = resultSet.getObject(1).toString();    //获取查询结果
            if(result.equals("0"))   //账号与密码不匹配，查询结果为0
                ret = 2;
            else                     //登录成功
                ret = 0;
        }
        return ret;
    }


    /*
    管理员登录函数
    传入参数为：ID和密码的字符串
    返回值：int 0（登录成功） 1（账号不存在） 2 （账号与密码不匹配）
     */
    public int adminLogin(String ID, String password) throws SQLException {
        String sql = new String();
        String result = new String();
        int ret = 1;
        if(isAdminIdExist(ID)){
            sql = "select count(*) from adminlogin where adminId = \"" + ID + "\" and adminPassword = \"" + password + "\";";
            resultSet = statement.executeQuery(sql);   //sql语句执行
            while(resultSet.next())
                result = resultSet.getObject(1).toString();    //获取查询结果
            if(result.equals("0"))   //账号与密码不匹配，查询结果为0
                ret = 2;
            else                     //登录成功
                ret = 0;
        }
        return ret;
    }

    /*
    读者更改密码函数
    传入参数：读者ID、旧密码、新密码 （均为字符串）
    返回值：int ： 0（修改密码成功） 1（账号不存在） 2（账号与密码不匹配）
     */
    public int readerChgPsw(String ID, String oldPsw, String newPsw) throws SQLException {
        int ret = readerLogin(ID, oldPsw);  //调用登陆函数，建议旧密码与账号是否匹配
        if(ret == 0){   //新旧密码匹配，成功修改密码
            String sql = new String("update userLogin set readerPassword = \"" + newPsw + "\" where readerId = \"" + ID + "\";");
            System.out.println(sql);
            statement.execute(sql);
        }
        return ret;
    }

    /*
    管理员更改密码函数
    传入参数：管理员ID、旧密码、新密码 （均为字符串）
    返回值：int ： 0（修改密码成功） 1（账号不存在） 2（账号与密码不匹配）
    */
    public int adminChgPsw(String ID, String oldPsw, String newPsw) throws SQLException {
        int ret = adminLogin(ID, oldPsw);  //调用登陆函数，建议旧密码与账号是否匹配
        if(ret == 0){   //新旧密码匹配，成功修改密码
            String sql = new String("update adminLogin set adminPassword = \"" + newPsw + "\" where adminId = \"" + ID + "\";");
            statement.execute(sql);
        }
        return ret;
    }


    /*
    读者注册函数
    传入参数：Map<String,Object> map (包含注册信息的map）
    map应当包含的信息
    key            value类型
    readerId       String
    readerPassword       String
    name           String
    address        String
    phoneNumber    String

    返回参数: int 0 注册成功 1 账号已存在 2 系统错误
     */
    public int readerRegist(Map<String,Object> map) throws SQLException {
        int ret = 1;
        try {
            connection.setAutoCommit(false);  //关闭connection的自动提交
            if (!isReaderIdExist(map.get("readerId").toString())) {
                //将账号密码插入到userLogin表的sql
                String sql1 = String.format("insert into userLogin values(\"%s\",\"%s\");",map.get("readerId").toString(),map.get("readerPassword"));
                //将用户信息插入到用户信息表reader当中的sql
                String sql2 = String.format("insert into reader(readerId,name,address,phoneNumber,limits) values(\"%s\",\"%s\",\"%s\",\"%s\",\"%s\");",
                        map.get("readerId").toString(),
                        map.get("name").toString(),
                        map.get("address").toString(),
                        map.get("phoneNumber").toString(),
                        DBConnect.BORROW_BOOK_NUM_LIMITS.toString()
                        );

                //开启事务，防止出现直插入到账号密码表，而未插入到用户基础信息表的情况出现
                statement.execute(sql1);
                statement.execute(sql2);  //执行两条sql语句
                connection.commit();  //提交事务
                connection.setAutoCommit(true);   //重新开启connection自动提交
                ret = 0;  //注册成功
            }
        }
        catch (Exception e){  //发生错误注册失败
            e.printStackTrace();
            connection.rollback();   //回滚事务
            connection.setAutoCommit(true);  //重新开启connection自动提交
            ret = 2; //表示注册过程中发生了系统错误，注册失败
         }
        return ret;
    }

    /*
    检索书本信息接口
    输入参数： 检索条件（String）
    输出参数： vector<Map<String,Object>>   map数组，每一个map存放一个字段
    每个map中包含以下信息
    key    value
    ISBN   String
    title  String
    authors String
    cover ImageIcon
     */
    Vector<Map<String,Object>> selectBooksInf(String selectRequire) throws SQLException {
        Vector<Map<String,Object>> booksMes = new Vector<Map<String, Object>>();
        String sql = String.format(
                "select ISBN,title,authors,cover from bookinformation " +
                        "where title like \'%%%s%%\' or ISBN = \'%s\' or authors like \'%%%s%%\' " +
                "order by length(replace(title,\'%s\',\'\'))/length(title);"
                ,selectRequire,selectRequire,selectRequire,selectRequire);   //构建sql语句

        System.out.print(sql);
        resultSet = statement.executeQuery(sql);   //执行语句
        ResultSetMetaData metaData = resultSet.getMetaData();
        int numberOfColumns = metaData.getColumnCount();   //获得列数
        while(resultSet.next()){
            Map<String, Object> map = new HashMap<String, Object>();
            for(int i = 1; i <= numberOfColumns; i++){
                if(metaData.getColumnName(i).toString().equals("cover")){   //将数据库中存放的封面解码转化为ImageIcon并添加到map中
                    Base64.Decoder decoder = Base64.getDecoder();
                    byte[] imageBytes = decoder.decode(resultSet.getObject(i).toString());  //base64解码
                    ImageIcon icon = new ImageIcon((imageBytes));
                    icon.setImage(icon.getImage());
                    map.put(metaData.getColumnName(i).toString(),icon);
                }
                else
                    map.put(metaData.getColumnName(i).toString(),resultSet.getObject(i).toString());
            }
            booksMes.add(map);
        }
        return booksMes;
    }






    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DBConnect db = new DBConnect();
    }

} // end class DisplayAuthors






