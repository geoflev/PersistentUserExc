package services;

import entities.User;
import java.util.List;

public interface IUser {

    User findById(int id);

    List<User> findAll();

    boolean deleteById(int id);

    boolean updateById(int id, User userToUpdate);
    
    boolean save(User userToSave);

}
