package PublicComp;

import Utils.DBConnect;

import java.sql.SQLException;

public class Main{
    public static void main(String[] args){
        DBConnect db=null;
        try{
            db=new DBConnect();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
        new LoginFrame(db);
    }
}
