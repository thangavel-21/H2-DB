package com.thangavel.H2Crud.repository;

import com.thangavel.H2Crud.modal.PersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalDetailRepo extends JpaRepository<PersonalDetails, Integer> {
    PersonalDetails findByFirstName(String firstName);

    PersonalDetails findByLastName(String lastName);
}
