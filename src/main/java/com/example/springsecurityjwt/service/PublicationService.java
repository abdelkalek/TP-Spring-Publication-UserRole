package com.example.springsecurityjwt.service;

import com.example.springsecurityjwt.entity.Publication;
import com.example.springsecurityjwt.repository.IPublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PublicationService implements IPublicationService {
    @Autowired
    private IPublicationRepository pubrepo;

    @Override
    public Publication addPublication(Publication p) {
        return pubrepo.save(p);
    }

    @Override
    public void deletePublication(long id) {
        pubrepo.deleteById(id);
    }

    @Override
    public Publication updatePublication(Publication p) {
        Publication pub = pubrepo.findById(p.getId()).orElse(null);
        return pubrepo.save(p);
    }

    @Override
    public List<Publication> retrieveAllPublication() {
        return pubrepo.findAll();
    }

    @Override
    public Publication retrievePublication(Long id) {
        return pubrepo.getById(id);
    }
}
