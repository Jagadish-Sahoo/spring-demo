package com.wipro.restfulwebservices.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.restfulwebservices.Resufulwebservicewithangular.model.User;
import com.wipro.restfulwebservices.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("users")
    public List<User> getUsers(){
        
        return this.userRepository.findAll();
    }
    
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getEmployeeById(@PathVariable(value = "id") Long employeeId)
        throws ResourceNotFoundException {
        User user = userRepository.findById(employeeId)
          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        return ResponseEntity.ok().body(user);
    }
    
    @GetMapping("/deluser/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
         throws ResourceNotFoundException {
        User user = userRepository.findById(employeeId)
       .orElseThrow(() -> new ResourceNotFoundException("Employee not present for the id :: " + employeeId));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<User>  updateEmployee(@PathVariable(value = "id") Long employeeId,
         @Validated @RequestBody User employeeDetails) throws ResourceNotFoundException {
        User user = userRepository.findById(employeeId)
        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        user.setEmail(employeeDetails.getEmail());
        user.setLastName(employeeDetails.getLastName());
        user.setFirstName(employeeDetails.getFirstName());
        final User updatedEmployee = userRepository.save(user);
        return ResponseEntity.ok(updatedEmployee);
    }
    
    @PostMapping("/add")
    public User createEmployee(@Validated @RequestBody User user) {
        return userRepository.save(user);
    }
}
