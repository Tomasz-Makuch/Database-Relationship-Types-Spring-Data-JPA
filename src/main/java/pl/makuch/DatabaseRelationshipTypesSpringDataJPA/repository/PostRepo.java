package pl.makuch.DatabaseRelationshipTypesSpringDataJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.makuch.DatabaseRelationshipTypesSpringDataJPA.model.Post;


@Repository
public interface PostRepo extends JpaRepository<Post,Long> {
}
