package fileManagment.ImportingFiles;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreator {
    public static void creatingTableForFilesInfo(Connection connection) {
        try(Statement stmt = connection.createStatement();){

            String sql = "create table FILESINFO(id int(10) primary key ,name varchar(15),type varchar(15),size float(4), content varchar(100000))";

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}