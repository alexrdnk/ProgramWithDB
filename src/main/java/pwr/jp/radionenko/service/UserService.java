package pwr.jp.radionenko.service;

import pwr.jp.radionenko.model.Register;
import pwr.jp.radionenko.dao.RegisterDao;

public class UserService {
    private final RegisterDao userDao = new RegisterDao();

    public boolean registerUser(String username, String password, String name) {
        Register user = new Register(username, password, name);
        return userDao.registerUser(user);
    }

    public int authenticateUser(String username, String password) {
        return userDao.getUserId(username, password); // Return user ID
    }


}
