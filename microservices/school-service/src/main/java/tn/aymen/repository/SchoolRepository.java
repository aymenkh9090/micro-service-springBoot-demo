package tn.aymen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.aymen.models.School;

import java.util.Optional;


@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {

}
