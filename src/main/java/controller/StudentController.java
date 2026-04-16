package controller;

import jakarta.servlet.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/students")
public class StudentController extends HttpServlet{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req,HttpServletResponse res)
    throws ServletException,IOException{

        RequestDispatcher rd = req.getRequestDispatcher("students.jsp");
        rd.forward(req,res);
    }
}
/**

package com.school.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection(){

        Connection con = null;

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/schooldb",
                    "root",
                    "root");

        }catch(Exception e){
            e.printStackTrace();
        }

        return con;
    }
}
5️⃣ StudentRepository (CRUD)
package com.school.repository;

import java.sql.*;
import java.util.*;
import com.school.model.Student;
import com.school.config.DBConnection;

public class StudentRepository {

    public void addStudent(Student s){

        try{

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "insert into students(name,class_name,age,email) values(?,?,?,?)");

            ps.setString(1,s.getName());
            ps.setString(2,s.getClassName());
            ps.setInt(3,s.getAge());
            ps.setString(4,s.getEmail());

            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
*/