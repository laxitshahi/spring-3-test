package com.learningjava.javaspring3contentcalendar.controller;

import com.learningjava.javaspring3contentcalendar.model.Content;
import com.learningjava.javaspring3contentcalendar.model.Status;
import com.learningjava.javaspring3contentcalendar.repository.ContentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/content")// What is the path to this controller
@CrossOrigin // Default values applied :: allows you to access the API endpoint from a client
public class ContentController {

    // This class is a dependency, because we rely on it for the ContentController class to work
    //    private final ContentCollectionRepository repository;
    private final ContentRepository repository;

    // We already have an instance of ContentCollectionRepository, we do not want to duplicate it
    // As such we can instead just use the method below (one of many) to inject the dependency
    @Autowired // Unnecessary, as there is only 1 constructor in this class
    public ContentController(ContentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("") // This url will combine with the RequestMapping url
    public List<Content> findAll() {
        return repository.findAll();
    }

    // You can also add all CRUD methods here
    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id) {
        return repository.findById((id)).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content was not found."));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    // Validation only happens when we put the @Valid annotation
    public void create(@Valid @RequestBody Content content) { // Indicates method request is bound to the body of the web request
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content was not found");
        }
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    // CUSTOM CRUD method
    @GetMapping("/filter/title/{keyword}")
    public List<Content> findByTitle(@PathVariable String keyword) {
        return repository.findAllByTitleContains(keyword);
    }

    // CUSTOM CRUD method using CUSTOM sql
    @GetMapping("/filter/status/{status}")
    public List<Content> findByStatus(@PathVariable Status status) {
        return repository.listByStatus(status);
    }
}
