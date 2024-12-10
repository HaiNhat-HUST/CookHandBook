package model.dao;

import model.actor.User;

public interface UserDAO {
    public void insert(User user);
    public void update(User user);
    public void deleteById(int id);
    public User findUser(String username, String password);
}
