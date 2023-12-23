package ma.xproce.demo.dtos;
import java.util.Date;
public class UserDTO {
        private String name;
        private String email;
        private Date dateNaissance;

        private String password;

        // Constructeurs, getters, setters, etc.

        public UserDTO(String name, String email, Date dateNaissance, String password) {
            this.name = name;
            this.email = email;
            this.dateNaissance = dateNaissance;
            this.password = password;
        }

        // Ajoutez les getters et setters appropriés

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Date getDateNaissance() {
            return dateNaissance;
        }

        public void setDateNaissance(Date dateNaissance) {
            this.dateNaissance = dateNaissance;
        }
        public String getPassword() {
            return password;
        }



}
