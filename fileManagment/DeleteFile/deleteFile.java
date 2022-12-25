package fileManagment.DeleteFile;
import Exceptions.SQLQueryException;
import Exceptions.NullObjectException;
import fileManagment.Database.DBconnection;
import fileManagment.Main;
import org.apache.log4j.Logger;

import java.sql.*;

public class deleteFile implements IdeleteFile{
    private static Logger logger = Logger.getLogger(Main.class);
    public void deleteByClassefication(String sql,String classification) throws SQLQueryException {
        logger.info("Inside the delete By Classification function");
        try {
            PreparedStatement pstmt = DBconnection.getConnection().prepareStatement(sql);
            pstmt.setString(1,classification);
            pstmt.executeUpdate();
            System.out.println("File deleted..");
        }
        catch (SQLException e){
            logger.info("SQLException");
            throw new SQLQueryException("Failed in deleteing files from DB");
        }
    }

    public void deleteFileByName(String FileName) throws NullObjectException {
        logger.info("Inside the delete By Name function");
        String sql= "DELETE FROM filesinfo WHERE name = ?";
        deleteByClassefication(sql, FileName);
        logger.info("deleted from database");
    }
    public void deleteFileByType(String FileType) throws NullObjectException {
        logger.info("Inside the delete By Type function");
        String sql = "DELETE FROM filesinfo WHERE type = ?";
        deleteByClassefication(sql,FileType);
        logger.info("deleted from database");
    }
    public void deleteFileBySize(String FileSize) throws NullObjectException {
        logger.info("Inside the delete By Size function");
        String sql = "DELETE FROM filesinfo WHERE size = ?";
        deleteByClassefication(sql,FileSize);
        logger.info("deleted from database");
    }
    public void deleteBycustomCategory(String nameClassification) throws SQLQueryException{
        String sql = "SELECT name,type,size FROM customCategory WHERE nameClassification=?";
        PreparedStatement pstmt=null;
        try{
            pstmt = DBconnection.getConnection().prepareStatement(sql);
            pstmt.setString(1,nameClassification);
            ResultSet resultSet = pstmt.executeQuery();
            DeleteByCustom.deleteByCustom(DBconnection.getConnection(),resultSet);
  
        }catch (SQLException e){
            throw new SQLQueryException("Failed in deleting files from DB");
        }
    }

}

