package de.ait.users.controller;

import de.ait.users.entity.User;
import de.ait.users.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers(
            @RequestParam(name="n", required=false,defaultValue="") String name,
            @RequestParam(name ="e", required=false, defaultValue = "") String email) {
    return userService.getUsers(name, email);
}




    @PostMapping("/users")
public User createUser(@RequestBody User user){

        return userService.createNew(user);
}

@GetMapping("users/{id}")
public User getUserById(@PathVariable Long id){
        return userService.findById(id);
}

}
