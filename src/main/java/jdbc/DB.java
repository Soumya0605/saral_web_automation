package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

    static Connection conn = null;
    public static Connection connect(){
        try{
            String url ="jdbc:postgresql://35.200.183.186:5432/staging_saral_db";
            String Username ="postgres";
            String Password ="7ah60wIcxDPo5C7H";
            conn = DriverManager.getConnection(url,Username,Password);
        }catch (Exception e ){
            e.printStackTrace();
        }
        return conn;
    }

}
