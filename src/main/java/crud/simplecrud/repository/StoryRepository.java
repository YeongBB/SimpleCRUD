package crud.simplecrud.repository;

import crud.simplecrud.domain.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Story, Long> {

}
