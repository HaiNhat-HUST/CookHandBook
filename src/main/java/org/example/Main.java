/*
    Step by step:
        1. Run InitDatabase to initialize live local datbase
        2. Run Main
 */

package org.example;

import model.actor.User;
import model.dao.UserDao;

public class Main {

    public static void main(String[] args) {
        User user = new User();
        user.setEmail("DAT");
        user.setPassword("123456");
        user.setUsername("DAT");
        UserDao userDao = new UserDao();
        User newUser = userDao.findUser("DAT", "123456");
        System.out.println(newUser.getEmail());
    }

}
