package dao;

import entities.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserDaoImpl implements IUserDao {

    private EntityManagerFactory emf;
    private EntityManager em;

    public UserDaoImpl() {
        emf = Persistence.createEntityManagerFactory("PersistentUserPU"); //apo persistence.xml to name
        em = emf.createEntityManager();

    }

    @Override
    public User findById(int id) {
        User user = em.find(User.class, id);   //etoimi method apo em.
        //to User sketo gia entity class den to dexetai
        //to User.class einai to compiled arxeio
        return user;
    }

    @Override
    public List<User> findAll() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
        //JPQL to query
        //to User einai to entity
    }

    //delete kai update xreiazetai transaction
    //kleidwnei ta sugkekrimena dedomena mexri na teleiwsw me del/update
    //wste na min crasharei kapoios allos s=pou paizei me ayta parallila
    @Override
    public boolean deleteById(int id) {
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
            em.getTransaction().commit();
            return true;
        } else {
            em.getTransaction().commit();
            return false;
        }
    }

    @Override
    public boolean updateById(int id, User userToUpdate) {
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        if (user != null && !user.equals(userToUpdate)) {
            
            user.setFirstName(userToUpdate.getFirstName());
            user.setLastName(userToUpdate.getLastName());
            user.setTel(userToUpdate.getTel());
            user.setEmail(userToUpdate.getEmail());
            em.getTransaction().commit();
            
            return true;
        } else {
            em.getTransaction().commit();
            return false;
        }

    }

    @Override
    public boolean save(User userToSave) {
        
        em.getTransaction().begin();
        
        User newUser = new User();
        
        newUser.setFirstName(userToSave.getFirstName());
        newUser.setLastName(userToSave.getLastName());
        newUser.setTel(userToSave.getTel());
        newUser.setEmail(userToSave.getEmail());
        
        em.persist(newUser);
        em.getTransaction().commit();  
        
        
        return true;
    }
}
