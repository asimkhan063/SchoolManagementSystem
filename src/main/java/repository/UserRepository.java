package repository;

import java.sql.*;
import model.User;

public class UserRepository {

    public User login(String email,String password){

        User user = null;

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/schooldb","root","root");

            PreparedStatement ps = con.prepareStatement(
            "select * from users where email=? and password=?");

            ps.setString(1,email);
            ps.setString(2,password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                user = new User();

                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setRole(rs.getString("role"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return user;
    }
}