package com.Api.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import javax.validation.Valid;
import java.util.List;



@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    // Get All Notes
    @GetMapping("/users")
    public List<UserPOJO> getAllNotes() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public UserPOJO getNoteById(@PathVariable(value = "id") Integer userId) throws UserNotFoundException {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    @PostMapping("/login")
    public UserPOJO loginUser(@RequestBody LoginRequest request) throws UserNotFoundException {
        List<UserPOJO> users = userRepository.findByLogin(request.getLogin());
        UserPOJO user =  users.stream().findFirst().orElseThrow(() -> new UserNotFoundException(1));
        System.out.println(user.getPassword());
        System.out.println(request.getPassword());
        if (request.getPassword().equals(user.getPassword())) {
            return user;
        } else {
            throw new UserNotFoundException(2);
        }
    }

    @DeleteMapping("/users/{id}")
    public Boolean deleteBook(@PathVariable(value = "id") Integer userId) throws UserNotFoundException {
        UserPOJO book = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        userRepository.delete(book);

        return true;
    }

    @PostMapping("/users")
    public UserPOJO createNote(@RequestBody UserPOJO user) {
        return userRepository.save(user);
    }
}