package fileManagment;
import fileManagment.UsersType.Admin;
import fileManagment.UsersType.Reader;
import fileManagment.UsersType.Staff;

import java.sql.SQLException;
import java.util.Scanner;

public class main {
    final static int admin=111;
    final static int staff=122;
    final static int reader=133;
    static int version=0;
    public static void main(String[] args) throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Key to determine if you are an Admin, User or Reader : ");
        int key = in.nextInt();
        if (key == admin) {
            Admin.AdminOperation();
        } else if (key == staff) {
            Staff.staffOperation();
        } else if (key == reader) {
            Reader.ReadingFile();
    }
        else{
            System.out.println("The entered Key is incorrect");
        }
    }
}
