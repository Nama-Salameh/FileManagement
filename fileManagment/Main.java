package fileManagment;

import fileManagment.UsersType.Admin;
import fileManagment.UsersType.Reader;
import fileManagment.UsersType.Staff;
import java.sql.SQLException;
import java.util.Scanner;
import org.apache.log4j.Logger;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class);
    private final static int ADMIN = 111;
    private final static int STAFF = 122;
    private final static int READER = 133;
    public static void main(String[] args) throws SQLException {
        logger.info("Here you inside main");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Key to determine if you are an Admin, User or Reader : ");
        int key = in.nextInt();
        if(key == ADMIN){
            Admin.AdminOperation();
        }
        else if(key == STAFF){
            Staff.staffOperation();
        }
        else if(key == READER){
            Reader.ReaderOperation();
        }
        else{
            System.out.println("The entered Key is incorrect");
        }
    }
}
