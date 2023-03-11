package com.Api.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@Data
@Builder
public class UserPOJO implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    private String login;
    private String password;
    private String email;
    private String name;
    private String address;
    private String role;

    public String getPassword() {
        return password;
    }
}
