package com.learningjava.javaspring3contentcalendar.repository;

import com.learningjava.javaspring3contentcalendar.model.Content;
import com.learningjava.javaspring3contentcalendar.model.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

// This Interface works only when you use spring data jdbc
// @Repository is not needed here as we extended a base repository
public interface ContentRepository extends ListCrudRepository<Content, Integer> {
    // Extending ListCrudRepository removes BASIC operations on a repository
    // BUT you CAN extend the functionality for unique use cases

    //  During runtime, this is turned into a query
    List<Content> findAllByTitleContains(String keyword);

    // We can also DIRECTLY write queries
    @Query("""
                SELECT * FROM Content
                where status = :status
            """)
    List<Content> listByStatus(@Param("status") Status status);
}
