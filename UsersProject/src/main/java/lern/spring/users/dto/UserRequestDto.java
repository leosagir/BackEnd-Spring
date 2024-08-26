package lern.spring.users.dto;

import lern.spring.users.entity.User;

public class UserRequestDto {
    private Long id;
    private String name;
    private String email;
    private String password;

    public UserRequestDto(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "UserRequestDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public static User toNtity(UserRequestDto dto){
        return new User(null,dto.getName(),dto.getEmail(),dto.getPassword());
    }
}
