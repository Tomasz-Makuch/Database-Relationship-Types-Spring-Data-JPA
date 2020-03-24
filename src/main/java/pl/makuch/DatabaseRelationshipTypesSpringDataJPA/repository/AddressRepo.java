package pl.makuch.DatabaseRelationshipTypesSpringDataJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.makuch.DatabaseRelationshipTypesSpringDataJPA.model.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {
}
