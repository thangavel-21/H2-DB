package com.thangavel.H2Crud.service;

import com.thangavel.H2Crud.modal.PersonalDetails;
import com.thangavel.H2Crud.repository.PersonalDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalDetailService {

    @Autowired
    private PersonalDetailRepo repo;

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
