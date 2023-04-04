package com.docker.DockerSpringBoot.Controller;

import com.docker.DockerSpringBoot.Models.User.User;
import com.docker.DockerSpringBoot.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/addusers")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/user/{id}")
    public User getUseryId(@PathVariable Long id) {
        return userRepository.findById(id).get();
    }

    @PutMapping("/userupdate/{id}")
    public ResponseEntity<User> updateEmployee(@PathVariable Long id, @RequestBody User userDetails){
        User user = userRepository.findById(id).get();
        /*.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
         */
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setDob((userDetails.getDob()));

        User updateUser = userRepository.save(user);
        return ResponseEntity.ok(updateUser);
    }

    @GetMapping("/index")
    public String firstPage(){
        return "index";
    }

    @DeleteMapping("/userdelete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
        User user = userRepository.findById(id).get();
        /*  .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));*/

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
