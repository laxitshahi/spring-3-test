package com.learningjava.javaspring3contentcalendar.repository;

import com.learningjava.javaspring3contentcalendar.model.Content;
import com.learningjava.javaspring3contentcalendar.model.Status;
import com.learningjava.javaspring3contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    // CURRENTLY just used to keep a list of content since we don't want talk to a DB server yet

    private static final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        // 1. Stream allows you to manipulate data (array?) WITHOUT altering the original content
        // 2. Streams can be used ONLY once
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content content) {
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }

    @PostConstruct // can be added into constructor, but this makes it easier
    private void init() {
        Content content = new Content(1, "My First Radical Story", "This is my first ever coolio story", Status.IDEA, Type.VIDEO, LocalDateTime.now(), null, "");
        contentList.add(content);
    }

    public boolean existsById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    public void delete(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }
}
