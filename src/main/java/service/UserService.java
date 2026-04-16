package service;

import repository.UserRepository;
import model.User;

public class UserService {

    UserRepository repo = new UserRepository();

    public User login(String email,String password){

        return repo.login(email,password);
    }
}