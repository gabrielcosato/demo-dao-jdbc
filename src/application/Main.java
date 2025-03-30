package application;

import db.DB;
import db.DBIntegrityException;
import db.DbException;
import model.entities.Department;

import java.io.FileNotFoundException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException, FileNotFoundException {

        Department obj = new Department(1, "Books");
        System.out.println(obj);
    }
}