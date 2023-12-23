package ma.xproce.demo.mappers;

import ma.xproce.demo.DAO.entities.User;
import ma.xproce.demo.dtos.UserDTO;

public class UserMapper {
    public static User mapDTOToUser(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        User user = new User();
        //user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setDateNaissance(userDTO.getDateNaissance());
        // Map other properties as needed

        return user;
    }
}
