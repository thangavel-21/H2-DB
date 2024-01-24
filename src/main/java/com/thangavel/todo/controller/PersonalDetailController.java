package com.thangavel.todo.controller;

import com.thangavel.todo.modal.PersonalDetails;
import com.thangavel.todo.service.PersonalDetailService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static com.thangavel.todo.constants.Constants.*;

@RestController
@RequestMapping(API)
public class PersonalDetailController {
    private final PersonalDetailService service;

    public PersonalDetailController(PersonalDetailService service) {
        this.service = service;
    }

    @PostMapping(ADD)
    public String addDetails(@RequestBody PersonalDetails details) {
        service.addDetails(details);
        return "Added Successfully";
    }

    @GetMapping(DETAILS_USER)
    public List<PersonalDetails> getAllDetails() {
        return  service.getAllDetails();
    }

    @GetMapping(USER)
    public PersonalDetails getUserById(@PathVariable Integer id) throws Exception {
        return service.getUserById(id);
    }

    @PutMapping(UPDATE)
    public String updateUser(@PathVariable Integer id, @RequestBody PersonalDetails person) throws Exception {
        service.updateUserById(id, person);
        return "Success";
    }

    @DeleteMapping(DELETE_USER)
    public String userDelete(@PathVariable Integer id) {
        return "User Deleted";
    }
}
