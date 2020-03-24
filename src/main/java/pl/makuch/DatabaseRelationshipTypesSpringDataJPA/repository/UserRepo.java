package pl.makuch.DatabaseRelationshipTypesSpringDataJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.makuch.DatabaseRelationshipTypesSpringDataJPA.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
