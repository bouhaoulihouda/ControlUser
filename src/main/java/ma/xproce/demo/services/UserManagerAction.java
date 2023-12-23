package ma.xproce.demo.services;
import ma.xproce.demo.dtos.UserDTO;
import ma.xproce.demo.DAO.entities.User;
import ma.xproce.demo.mappers.UserMapper;

import java.util.List;
import java.util.Optional;
public class UserManagerAction {
    private UserManager userManager;

    public UserManagerAction(UserManager userManager) {
        this.userManager = userManager;
    }

    public User createUser(UserDTO userDTO) {
        // Vérifier si l'email existe déjà dans la base de données
        if (emailExists(userDTO.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        // Créer l'utilisateur en utilisant le UserManager
        return userManager.createUser(userDTO);
    }
    private boolean emailExists(String email) {
        List<User> existingUsers = userManager.getAllUsers();
        return existingUsers.stream().anyMatch(user -> user.getEmail().equals(email));
    }

    // Les autres méthodes peuvent être redirigées directement vers UserManager
    public List<User> getAllUsers() {
        return userManager.getAllUsers();
    }

    public Optional<User> getUserById(Long id) {
        return userManager.getUserById(id);
    }

    public User updateUser(Long id, UserDTO updatedUserDTO) {
        return userManager.updateUser(id, updatedUserDTO);
    }

    public void deleteUser(Long id) {
        userManager.deleteUser(id);
    }
}
