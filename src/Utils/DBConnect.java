package Utils;
/*
数据库连接类
连接数据库，并实现各项功能实现的接口（如登录：Login,录入新书本信息：AddBooks------
*/
import Beans.Book;
import Beans.Reader;
import Beans.Record;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
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
//        try {
////            Class.forName("com.mysql.cj.jdbc.Driver");
////            connection = DriverManager.getConnection(DATABASE_URL, "root", "password");
//            statement = connection.createStatement();
//        }
//        catch (SQLException sqlException ) {
//            sqlException.printStackTrace();
//        } // end catch
    }


    private void connect() throws SQLException{
        connection=DriverManager.getConnection(DATABASE_URL,"root","password");
    }



    /*
   检验读者ID是否存在函数
   传入参数：ID字符串
   返回值： 存在返回true，反之返回false
    */
    public boolean isReaderIdExist(String ID){
        String cnt = new String();
        try {
            connect();
            String sql = "select count(*) from userlogin where readerId = \"" + ID + "\";";   //构建sql语句，查询ID是否存在
            resultSet = statement.executeQuery(sql);
            while(resultSet.next())
                cnt = resultSet.getObject(1).toString();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return cnt.equals("1");
    }

    /*
    检验管理员ID是否存在函数
    传入参数：ID字符串
    返回值： 存在返回true，反之返回false
    */
    public boolean isAdminIdExist(String ID){
        String cnt = new String();
        try{
            connect();
            String sql = "select count(*) from adminlogin where adminId = \"" + ID + "\";";   //构建sql语句，查询ID是否存在
            resultSet = statement.executeQuery(sql);
            while(resultSet.next())
                cnt = resultSet.getObject(1).toString();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return cnt.equals("1");
    }


    /*
    读者登录函数
    传入参数为：ID和密码的字符串
    返回值：int 0（登录成功） 1（账号不存在） 2 （账号与密码不匹配）
     */
    public int readerLogin(String ID, String password){
        String sql = new String();
        String result = new String();
        int ret = 1;
        try{
            connect();
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
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return ret;
    }


    /*
    管理员登录函数
    传入参数为：ID和密码的字符串
    返回值：int 0（登录成功） 1（账号不存在） 2 （账号与密码不匹配）
     */
    public int adminLogin(String ID, String password){
        String sql = new String();
        String result = new String();
        int ret = 1;
        try {
            connect();
            if (isAdminIdExist(ID)) {
                sql = "select count(*) from adminlogin where adminId = \"" + ID + "\" and adminPassword = \"" + password + "\";";
                resultSet = statement.executeQuery(sql);   //sql语句执行
                while (resultSet.next())
                    result = resultSet.getObject(1).toString();    //获取查询结果
                if (result.equals("0"))   //账号与密码不匹配，查询结果为0
                    ret = 2;
                else                     //登录成功
                    ret = 0;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return ret;
    }


    /*
    读者注册函数
    传入参数：Map<String,Object> map (包含注册信息的map）
    map应当包含的信息
    key            value类型
    readerPassword       String
    name           String
    address        String
    phoneNumber    String

    返回参数: int 生成的id值
     */
    public int readerRegist(Map<String,Object> map){
        int id = 0;
        try {
            connect();
            connection.setAutoCommit(false);  //关闭connection的自动提交
            //将账号密码插入到userLogin表的sql
            String sql1 = String.format("insert into userLogin values(null,\"%s\");", map.get("readerPassword"));
            statement.executeUpdate(sql1, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();

            //获取自增长在主键生成的id
            if (rs.next()) {
                id = rs.getInt(1);

                //将用户信息插入到用户信息表reader当中的sql
                String sql2 = String.format("insert into reader(readerId,name,address,phoneNumber,limits) values(\"%s\",\"%s\",\"%s\",\"%s\",\"%s\");",
                        id,
                        map.get("name").toString(),
                        map.get("address").toString(),
                        map.get("phoneNumber").toString(),
                        DBConnect.BORROW_BOOK_NUM_LIMITS.toString()
                );

                //开启事务，防止出现直插入到账号密码表，而未插入到用户基础信息表的情况出现

                statement.execute(sql2);  //执行两条sql语句
                connection.commit();  //提交事务
            }
        }
        catch (Exception e){  //发生错误注册失败
            try {
                e.printStackTrace();
                connection.rollback();   //回滚事务
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
        finally {
            try{
                connection.setAutoCommit(true);  //重新开启connection自动提交
                connection.close();
            }
            catch (Exception exc){
                exc.printStackTrace();
            }
        }
        return id;
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
    Vector<Map<String,Object>> selectBooksInf(String selectRequire){
        Vector<Map<String,Object>> booksMes = new Vector<Map<String, Object>>();
        try {
            connect();
            String sql = String.format(
                    "select ISBN,title,authors,cover from bookinformation " +
                            "where title like \'%%%s%%\' or ISBN = \'%s\' or authors like \'%%%s%%\' " +
                            "order by length(replace(title,\'%s\',\'\'))/length(title);"
                    , selectRequire, selectRequire, selectRequire, selectRequire);   //构建sql语句

            System.out.print(sql);
            resultSet = statement.executeQuery(sql);   //执行语句
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();   //获得列数
            while (resultSet.next()) {
                Map<String, Object> map = new HashMap<String, Object>();
                for (int i = 1; i <= numberOfColumns; i++) {
                    if (metaData.getColumnName(i).toString().equals("cover")) {   //将数据库中存放的封面解码转化为ImageIcon并添加到map中
                        Base64.Decoder decoder = Base64.getDecoder();
                        byte[] imageBytes = decoder.decode(resultSet.getObject(i).toString());  //base64解码
                        ImageIcon icon = new ImageIcon((imageBytes));
                        icon.setImage(icon.getImage());
                        map.put(metaData.getColumnName(i).toString(), icon);
                    } else
                        map.put(metaData.getColumnName(i).toString(), resultSet.getObject(i).toString());
                }
                booksMes.add(map);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }
            catch (Exception exc){
                exc.printStackTrace();
            }
        }
        return booksMes;
    }

    /*
    添加新书接口
    输入参数： Book包含(`ISBN`, `title`, `authors`, `publisher`, `publicationDate`,`cover`),int 添加数量
    输出参数： int 0--成功 1--操作异常 2--系统出错
     */
    public int addNewBook(Book aBook,int bookCount){
        int result=0;
        try {
            connect();

            PreparedStatement preparedStatement=connection.prepareStatement(
                    "select count(*) from bookinformation where isbn=?"
            );
            preparedStatement.setObject(1,aBook.getISBN());

            ResultSet resultSet=preparedStatement.executeQuery();
            int count=0;
            while(resultSet.next()){
                count=resultSet.getInt(1);
            }
            connection.setAutoCommit(false);
            if(count==0) {
                //图书馆中先前没有的书添加信息
                PreparedStatement preparedStatement1 = connection.prepareStatement(
                        "insert into bookinformation(`ISBN`, `title`, `authors`, `publisher`, `publicationDate`,`cover`)" +
                                "values(?,?,?,?,?,?);"
                );
                preparedStatement1.setObject(1, aBook.getISBN());
                preparedStatement1.setObject(2, aBook.getTitle());
                preparedStatement1.setObject(3, aBook.getAuthors());
                preparedStatement1.setObject(4, aBook.getPublisher());
                preparedStatement1.setObject(5, aBook.getPublishDate());
                preparedStatement1.setObject(6,aBook.getCover());

                preparedStatement1.executeUpdate();
            }
            for(int i=0;i<bookCount;i++) {
                PreparedStatement preparedStatement2 = connection.prepareStatement(
                        "insert into bookid(`ISBN`) " +
                                "values(?);"
                );
                preparedStatement2.setObject(1, aBook.getISBN());
                preparedStatement2.executeUpdate();
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            result=1;
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
                result=1;
            }
        }finally {
            try {
                connection.setAutoCommit(true);
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                result=1;
            }
        }
        return result;
    }

    /*
    借书接口
    输入参数：Record(bookid,readerid,borrowingdate,returndate)务必传入未借阅图书记录
    输出参数：int 0--借阅成功 1--当前用户可借阅数量不足 2--系统出错
     */
    public int borrowBook(Record record){
        int result=1;
        try {
            connect();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement=connection.prepareStatement(
                    "update reader set limits=limits-1 " +
                            "where readerid=? and limits>0;"
            );
            preparedStatement.setObject(1,record.getReaderId());
            int influenced=preparedStatement.executeUpdate();
            preparedStatement.close();
            if(influenced == 1){
                //读者可借数量满足条件
                //添加借书记录
                result=0;
                preparedStatement=connection.prepareStatement(
                        "insert into record(`bookid`,`readerid`,`borrowingdate`,`returndate`) " +
                                "values(?,?,?,?);"
                );
                preparedStatement.setObject(1,record.getBookId());
                preparedStatement.setObject(2,record.getReaderId());
                preparedStatement.setObject(3,record.getBorrowDate());
                preparedStatement.setObject(4,record.getReturnDate());
                preparedStatement.executeUpdate();
                preparedStatement.close();
                //标记为已被借阅
                preparedStatement=connection.prepareStatement(
                        "upadte bookid set bookid.isBorrowed=1 where bookid.bookId=?;"
                );
                preparedStatement.setObject(1,record.getBookId());
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            result=2;
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
                result=2;
            }
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                result=2;
            }
        }
        return result;
    }
    /*
        还书接口
        输入参数：Record需包含(bookid,readerid)务必传入已借阅图书记录
        输出参数：int 0--还书成功 1--传入信息有误或数据库信息异常 2--系统出错
         */
    public int returnBook(Record record){
        int result=0;
        try {
            connect();
            connection.setAutoCommit(false);
            //删除record记录
            PreparedStatement statement=connection.prepareStatement(
                    "delete from record where bookId=?;"
            );
            statement.setObject(1,record.getBookId());
            int temp=statement.executeUpdate();
            statement.close();
            if(temp!=1)result=1;
            //更新bookid中的借阅状态
            statement=connection.prepareStatement(
                    "update bookid set isBorrowed=0 where bookId=?;"
            );
            statement.setObject(1,record.getBookId());
            temp=statement.executeUpdate();
            statement.close();
            if(temp!=1)result=1;
            //更新读者可借阅数量
            statement=connection.prepareStatement(
                    "update reader set limits=limits+1 " +
                            "where readerId=?;"
            );
            statement.setObject(1,record.getReaderId());
            temp=statement.executeUpdate();
            statement.close();
            if(temp!=1)result=1;
            connection.commit();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            result=2;
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }finally {
            try {
                connection.setAutoCommit(true);
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                result=2;
            }
        }
        return result;
    }

    /*
        查询读者借阅信息接口
        输入参数：Reader需包含readerId
        输出参数：Vector<Record> 包含借阅记录的Record向量
                其中的向量元素Record仅包含（bookName,bookId,borrowDate,returnDate）
                其他变量无意义
         */
    public Vector<Record> queryReaderBorrowingRecord(Reader reader){
        Vector<Record> recordVector=new Vector<>();
        try {
            connect();
            PreparedStatement preparedStatement=connection.prepareStatement(
                    "select bookinformation.title,record.bookId,record.borrowingDate,record.returnDate " +
                            "from record,bookid,bookinformation  " +
                            "where readerId =? " +
                            "and record.bookId=bookid.bookId " +
                            "and bookid.isbn=bookinformation.isbn;"
            );
            preparedStatement.setObject(1,reader.getReaderId());
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                recordVector.add(new Record(
                        0,
                        resultSet.getInt(2),
                        0,
                        resultSet.getString(1),
                        resultSet.getString(3),
                        resultSet.getString(4)
                ));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return recordVector;
    }
    /*
        查询读者信息接口
        输入参数：int 读者ID
        输出参数：Reader包含(读者ID,姓名,null,地址,手机号,借阅限制)
                若返回reader的readerId为-1则查询失败
         */
    public Reader queryReaderInformation(int readerId){
        Reader reader=new Reader(-1,null,null,null,null,0);
        try {
            connect();
            PreparedStatement preparedStatement=connection.prepareStatement(
                    "select * from reader where readerid=?;"
            );
            preparedStatement.setObject(1,readerId);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                reader.setReaderId(resultSet.getInt("readerId"));
                reader.setName(resultSet.getString("name"));
                reader.setAddress(resultSet.getString("address"));
                reader.setPhoneNumber(resultSet.getString("phoneNumber"));
                reader.setLimits(resultSet.getInt("limits"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return reader;
    }
    /*
            修改读者信息接口
            输入参数：Reader需包含(readerId,name,address,phoneNumber)
            输出参数：int
                    0--修改成功 1--传入信息有误 2--系统异常
             */
    public int modifyReaderInformation(Reader reader){
        int result=0;
        try {
            connect();
            PreparedStatement statement=connection.prepareStatement(
                    "update reader " +
                            "set name=?,address=?,phoneNumber=? " +
                            "where readerId=?;"
            );
            statement.setObject(1,reader.getName());
            statement.setObject(2,reader.getAddress());
            statement.setObject(3,reader.getPhoneNumber());
            statement.setObject(4,reader.getReaderId());
            int temp=statement.executeUpdate();
            if(temp!=1)result=1;
            statement.close();
        } catch (SQLException throwables) {
            result=2;
            throwables.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                result=2;
            }
        }
        return result;
    }
    /*
        删除已借阅图书接口
        输入参数：Record 需包含(readerId,bookId)
        输出参数：int
                0--修改成功 1--系统异常
         */
    public int deleteBorrowedBook(Record record){
        int result=0;
        try {
            connect();
            connection.setAutoCommit(false);
            PreparedStatement statement=connection.prepareStatement(
                    "delete from bookid where bookid.bookId=?;"
            );
            statement.setObject(1,record.getBookId());
            statement.executeUpdate();//删除bookid记录，相应的借阅记录被级联删除
            statement.close();

            statement=connection.prepareStatement(
                    "update reader set limits=limits+1 " +
                            "where readerId=?;"
            );
            statement.setObject(1,record.getReaderId());
            statement.executeUpdate();//原借阅人借书限制数加一
            statement.close();

            connection.commit();
        } catch (SQLException throwables) {
            result=1;
            throwables.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }finally {
            try {
                connection.setAutoCommit(true);
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                result=1;
            }
        }
        return result;
    }
    /*
        删除已借阅图书接口
        输入参数：int 为图书的bookId
        输出参数：int
                0--修改成功 1--系统异常
         */
    public int  deleteAvailableBook(int bookid){
        int result=0;
        try {
            connect();
            PreparedStatement statement=connection.prepareStatement(
                    "delete from bookid where bookid.bookId=?;"
            );
            statement.setObject(1,bookid);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException throwables) {
            result=1;
            throwables.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                result=1;
            }
        }
        return result;
    }
    /*
        查询已借阅图书记录接口
        输入参数：String 为图书的isbn
        输出参数：Vector<Record>
                向量元素Record中仅包含bookId和readerId，其他变量无意义
         */
    public Vector<Record> queryBorrowedBookRecord(String isbn){
        Vector<Record> recordVector=new Vector<>();
        try {
            connect();
            PreparedStatement statement=connection.prepareStatement(
                    "select record.bookId,record.readerId " +
                            "from record,bookid " +
                            "where bookid.isbn=? " +
                            "and record.bookId=bookid.bookId;"
            );
            statement.setObject(1,isbn);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                recordVector.add(new Record(
                        0,
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        null,
                        null,
                        null

                ));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return recordVector;
    }
    /*
        查询未借阅图书bookId接口
        输入参数：String 为图书的isbn
        输出参数：Vector<String>
                向量元素String为指定ISBN未被借阅图书的bookId
         */
    public Vector<String> queryAvailableBook(String isbn){
        Vector<String> bookIds=new Vector<>();
        try {
            connect();
            //仅检索指定ISBN未被借阅图书的bookId
            PreparedStatement statement=connection.prepareStatement(
                    "select bookId from bookid " +
                            "where isbn=? " +
                            "and isBorrowed=0;"
            );
            statement.setObject(1,isbn);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                bookIds.add(resultSet.getString(1));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return bookIds;
    }
    /*
        删除读者
        输入参数：int 为读者readerId
        输出参数：int 0--删除成功 1--系统出错
        描述：删除时必须保证读者已借书已还清！！！！！
         */
    public int deleteReader(int readerId){
        int result=0;
        try {
            connect();
            //删除登录信息相应reader，record记录也删除
            PreparedStatement statement=connection.prepareStatement(
                    "delete from userlogin where readerid=?;"
            );
            statement.setObject(1,readerId);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            result=1;
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                result=1;
            }
        }
        return result;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DBConnect db=new DBConnect();
        Scanner scanner=new Scanner(System.in);
        System.out.println(db.borrowBook(new Record(0,100012,6,null,
                "2000-2-1","2001-2-1")));
    }




} // end class DisplayAuthors