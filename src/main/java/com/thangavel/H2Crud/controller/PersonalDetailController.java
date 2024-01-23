package com.thangavel.H2Crud.controller;

import com.thangavel.H2Crud.modal.PersonalDetails;
import com.thangavel.H2Crud.service.PersonalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/details")
public class PersonalDetailController {

    @Autowired
    private PersonalDetailService service;

    @PostMapping("/add")
    public String addDetails(@RequestBody PersonalDetails details) {
        service.addDetails(details);
        return "Added Successfully";
    }

    @GetMapping("/getDetails")
    public List<PersonalDetails> getAllDetails() {
        return  service.getAllDetails();
    }

    @GetMapping("/getById/{id}")
    public PersonalDetails getUserById(@PathVariable Integer id) throws Exception {
        return service.getUserById(id);
    }

    @PutMapping("update/{id}")
    public String updateUser(@PathVariable Integer id, @RequestBody PersonalDetails person) throws Exception {
        service.updateUserById(id, person);
        return "Success";
    }

    @DeleteMapping("delete/{id}")
    public String userDelete(@PathVariable Integer id) {
        return "User Deleted";
    }
}
