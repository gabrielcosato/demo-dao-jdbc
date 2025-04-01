package model.dao;

import db.DB;
import model.dao.impl.SellerDaoJDBC;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;

public class DaoFactory {

    public static SellerDao createSellerDao() throws SQLException, FileNotFoundException {
        return new SellerDaoJDBC(DB.getConnection());
    }
}
