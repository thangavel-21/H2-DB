package com.thangavel.H2Crud.controller;

import com.thangavel.H2Crud.constants.Constants;
import com.thangavel.H2Crud.modal.PersonalDetails;
import com.thangavel.H2Crud.service.PersonalDetailService;
import org.aspectj.apache.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/details")
public class PersonalDetailController {
    private final PersonalDetailService service;

    public PersonalDetailController(PersonalDetailService service) {
        this.service = service;
    }

    @PostMapping(Constants.add)
    public String addDetails(@RequestBody PersonalDetails details) {
        service.addDetails(details);
        return "Added Successfully";
    }

    @GetMapping(Constants.details)
    public List<PersonalDetails> getAllDetails() {
        return  service.getAllDetails();
    }

    @GetMapping(Constants.userById)
    public PersonalDetails getUserById(@PathVariable Integer id) throws Exception {
        return service.getUserById(id);
    }

    @PutMapping(Constants.updateById)
    public String updateUser(@PathVariable Integer id, @RequestBody PersonalDetails person) throws Exception {
        service.updateUserById(id, person);
        return "Success";
    }

    @DeleteMapping(Constants.deleteById)
    public String userDelete(@PathVariable Integer id) {
        return "User Deleted";
    }
}
