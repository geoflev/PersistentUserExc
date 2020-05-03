package services;

import entities.User;
import java.util.List;

public class UserImpl implements IUser {

    private dao.UserDaoImpl userDao;
    //pali edw den kanw import giati to xrisimopoiw mia fora

    //Business Logic tis efarmogis einai edw
    @Override
    public User findById(int id) {
        if (id <= 0) {
            return null;
        } else {
            // DAO = Data Access Object
            userDao = new dao.UserDaoImpl();
            return userDao.findById(id);
        }
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        if (id <= 0) {
            return false;
        } else {
            return userDao.deleteById(id);
        }

    }

    @Override
    public boolean updateById(int id, User userToUpdate) {
        if (id <= 0) {
            return false;
        } else {
            return userDao.updateById(id, userToUpdate);
        }
    }

    @Override
    public boolean save(User userToSave) {
        return userDao.save(userToSave);
    }

}
