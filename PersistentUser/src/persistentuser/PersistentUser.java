package persistentuser;

import entities.User;
import java.util.List;

public class PersistentUser {

    public static void main(String[] args) {

        //FINDBYID
        services.UserImpl userService = new services.UserImpl();
        //swstos tropos gia na to grafw to apo panw,xwris import giati to kalw mono mia fora
        User user = userService.findById(2);
        if (user == null) {
            System.out.println("Oh!!! Something is not found!!");
        } else {
            System.out.println(user);

        }

        //FINDALL
        List<User> users = userService.findAll();
        for (User user1 : users) {
            System.out.println(user1);
        }

        //DELETE
        int i = 5;
        boolean delete = userService.deleteById(i);
        if (delete) {
            System.out.println("User with id : " + i + " deleted successfully!");
        }
        
        //UPDATE
        User userToUpdate = new User();
        userToUpdate.setFirstName("John");
        userToUpdate.setLastName("Cena");
        userToUpdate.setTel("98765");
        userToUpdate.setEmail("johnCena@hotmail.com");

        // int id is an id (PRIMARY KEY) !! WE DON'T KNOW IF IT IS A VALID ID
        // IF IT IS VALID THEN UPDATE BY USING user object as below
        int j = 2;
        boolean update = userService.updateById(j, userToUpdate);
        if (update) {
            System.out.println("User with id : " + j + " updated successfully!");
        }
        
        //SAVE
        
        User userToSave = new User();
        userToSave.setFirstName("Hello");
        userToSave.setLastName("World");
        userToSave.setTel("3874562");
        userToSave.setEmail("nickBald@hotmail.com");
        boolean save = userService.save(userToSave);
        
        if (save) {
            System.out.println("User saved successfully!");
        }
    }

}
