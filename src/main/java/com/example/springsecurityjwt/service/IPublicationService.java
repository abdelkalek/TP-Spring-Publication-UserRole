package com.example.springsecurityjwt.service;

import com.example.springsecurityjwt.entity.Publication;

import java.util.List;

public interface IPublicationService {
    Publication addPublication(Publication p);
    void deletePublication(long id);
    Publication updatePublication( Publication t);
    List<Publication> retrieveAllPublication();
    Publication retrievePublication(Long id);
}
