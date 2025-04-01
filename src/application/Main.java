package application;

import db.DB;
import db.DBIntegrityException;
import db.DbException;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.io.FileNotFoundException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException, FileNotFoundException {


        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller FindByID =====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);


        System.out.println("\n=== TEST 2: seller FindByDepartment =====");
        Department dep = new Department(2,null);
        List<Seller> list = sellerDao.findByDepartment(dep);

        for(Seller obj : list){
            System.out.println(obj);
        }

    }
}