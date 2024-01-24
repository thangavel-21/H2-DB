package com.thangavel.todo.service;

import com.thangavel.todo.modal.PersonalDetails;
import com.thangavel.todo.repository.PersonalDetailRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalDetailService {

    private final PersonalDetailRepo repo;

    public PersonalDetailService(PersonalDetailRepo repo) {
        this.repo = repo;
    }

    public void addDetails(PersonalDetails details) {
        repo.save(details);
    }

    public List<PersonalDetails> getAllDetails() {
        return repo.findAll();
    }

    public PersonalDetails getUserById(Integer id) throws Exception {
        return repo.findById(id).orElseThrow(() -> new Exception("User Not Found"));
    }

    public void updateUserById(Integer id, PersonalDetails person) throws Exception {
        PersonalDetails personalDetails = getUserById(id);
        personalDetails.setAddress(person.getAddress());
        personalDetails.setFirstName(person.getFirstName());
        personalDetails.setLastName(person.getLastName());
        repo.save(personalDetails);
    }

    public void deleterUser(Integer id) {
        repo.deleteById(id);
    }
}
