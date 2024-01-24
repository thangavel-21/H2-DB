package com.thangavel.todo.repository;

import com.thangavel.todo.modal.PersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalDetailRepo extends JpaRepository<PersonalDetails, Integer> {
    PersonalDetails findByFirstName(String firstName);

    PersonalDetails findByLastName(String lastName);
}
