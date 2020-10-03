package pl.coderslab.dao_workbench;

import pl.coderslab.entity.User;

public class MainDAO {

    public static void main(String[] args) {
    UserDao userDao = new UserDao();
        User user = new User();
        String password = "abc1234!@#";
    userDao.create(user);
    userDao.read(1);
    userDao.update(user);
    userDao.hashPassword(password);
    userDao.delete(1);
    userDao.findAll();
    }

}
