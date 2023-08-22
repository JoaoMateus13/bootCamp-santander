package bootCampsantanderAPI.domain.controller;


import bootCampsantanderAPI.domain.model.User;
import bootCampsantanderAPI.domain.service.UserService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        return ResponseEntity.ok(userService.findById(id));
    }




    @PostMapping
    public ResponseEntity<User> findById(@RequestBody User user){
        var userr = userService.create(user);


        URI location = ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("/{id}").
                buildAndExpand(user.getId()).
                toUri();

        return ResponseEntity.created(location).body(userr);
    }
}
