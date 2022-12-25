package fileManagment.DeleteFile;
import fileManagment.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DeleteByCustom {

    public static void deleteByCustom(Connection connection, ResultSet resultSet) throws SQLException {
        deleteFile deleteFile=new deleteFile();
        String fileName=null;
        String fileType=null;
        String fileSize=null;
        while (resultSet.next()) {
            fileName = resultSet.getString(1);
            fileType= resultSet.getString(2);
            fileSize= resultSet.getString(3);
        }
        if(!fileName.equals("null")&&!fileType.equals("null")&&!fileSize.equals("null")) {
            String deleteSql = "DELETE FROM filesinfo WHERE name = ? and type=? and size=?";
            PreparedStatement pstmtdelete = DBconnection.getConnection().prepareStatement(deleteSql);
            pstmtdelete.setString(1, fileName);
            pstmtdelete.setString(2, fileType);
            pstmtdelete.setString(3, fileSize);
            pstmtdelete.executeUpdate();
        }else if(!fileName.equals("null")&&!fileType.equals("null")&&fileSize.equals("null")){
            String deleteSql = "DELETE FROM filesinfo WHERE name = ? and type=?";
            PreparedStatement pstmtdelete = DBconnection.getConnection().prepareStatement(deleteSql);
            pstmtdelete.setString(1, fileName);
            pstmtdelete.setString(2, fileType);
            pstmtdelete.executeUpdate();
        }else if(!fileName.equals("null")&&!fileSize.equals("null")&&fileType.equals("null")){
            String deleteSql = "DELETE FROM filesinfo WHERE name = ? and size=?";
            PreparedStatement pstmtdelete = DBconnection.getConnection().prepareStatement(deleteSql);
            pstmtdelete.setString(1, fileName);
            pstmtdelete.setString(2, fileSize);
            pstmtdelete.executeUpdate();
        }else if(!fileType.equals("null")&&!fileSize.equals("null")&&fileName.equals("null")){
            String deleteSql = "DELETE FROM filesinfo WHERE type = ? and size=?";
            PreparedStatement pstmtdelete = DBconnection.getConnection().prepareStatement(deleteSql);
            pstmtdelete.setString(1, fileType);
            pstmtdelete.setString(2, fileSize);
            pstmtdelete.executeUpdate();
        }else if(fileType.equals("null")&&fileSize.equals("null")&&!fileName.equals("null")){
            deleteFile.deleteFileByName(fileName);
        }else if(fileName.equals("null")&&fileSize.equals("null")&&!fileType.equals("null")){
            deleteFile.deleteFileByType(fileType);
        }else if(fileType.equals("null")&&fileName.equals("null")&&!fileSize.equals("null")){
            deleteFile.deleteFileBySize(fileSize);
        }
        System.out.println("File deleted..");
    }
}
