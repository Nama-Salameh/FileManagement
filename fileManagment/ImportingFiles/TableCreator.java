package fileManagment.ImportingFiles;
import Exceptions.SQLQueryException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreator {
    public static void creatingTableForFilesInfo(Connection connection) throws SQLQueryException {
        try(Statement statement = connection.createStatement()){

            String sql = "create table FILESINFO(id int(10) primary key not null AUTO_INCREMENT ,name varchar(35)  not null,type varchar(15),size varchar(4), version int(2),content BLOB)";

            statement.executeUpdate(sql);
            System.out.println("Created table in given database...");
        }
        catch (SQLException e) {
            throw new SQLQueryException("Created table failed, maybe it's exists");
        }
    }
}