package dao;

import entities.User;
import java.util.List;

public interface IUserDao {

    User findById(int id);

    List<User> findAll();

    boolean deleteById(int id);

    boolean updateById(int id, User userToUpdate);
    
    boolean save(User userToSave);

}
