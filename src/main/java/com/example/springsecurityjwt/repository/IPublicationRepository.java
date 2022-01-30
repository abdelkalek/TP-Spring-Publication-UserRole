package com.example.springsecurityjwt.repository;
import com.example.springsecurityjwt.entity.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IPublicationRepository extends JpaRepository<Publication, Long> {
 Publication findFirstByOrderByIdDesc();

 @Query("select count(p) from Publication p")
 Long countPublicationById();
Optional<Publication> findPublicationByLastModifiedDateIsNotNull();

}
