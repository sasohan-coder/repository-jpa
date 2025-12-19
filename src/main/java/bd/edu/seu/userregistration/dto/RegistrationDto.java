package bd.edu.seu.userregistration.dto;

import bd.edu.seu.userregistration.model.User;

public record RegistrationDto(String name, String email, String password) {
    public User toUser() {
        return new User(name, email, password);
    }
}
