package ma.xproce.demo.services;
import ma.xproce.demo.dtos.UserDTO;
import ma.xproce.demo.DAO.entities.User;
import ma.xproce.demo.mappers.UserMapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class UserManager {
    private List<User> users = new ArrayList<>();
    private Long idCounter = 1L;

    public User createUser(UserDTO userDTO) {
        User newUser = UserMapper.mapDTOToUser(userDTO);
        newUser.setId(idCounter++);
        users.add(newUser);
        return newUser;
    }

    public List<User> getAllUsers() {
        return users;
    }

    public Optional<User> getUserById(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public User updateUser(Long id, UserDTO updatedUserDTO) {
        Optional<User> optionalUser = getUserById(id);

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            // Update only non-null fields
            if (updatedUserDTO.getName() != null) {
                existingUser.setName(updatedUserDTO.getName());
            }
            if (updatedUserDTO.getEmail() != null) {
                existingUser.setEmail(updatedUserDTO.getEmail());
            }
            if (updatedUserDTO.getDateNaissance() != null) {
                existingUser.setDateNaissance(updatedUserDTO.getDateNaissance());
            }
            if (updatedUserDTO.getPassword() != null) {
                existingUser.setPassword(updatedUserDTO.getPassword());
            }

            return existingUser;
        } else {
            throw new IllegalArgumentException("User not found with ID: " + id);
        }
    }

    public void deleteUser(Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }
}
