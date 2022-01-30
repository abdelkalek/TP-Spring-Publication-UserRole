package com.example.springsecurityjwt.api;

import com.example.springsecurityjwt.entity.Publication;
import com.example.springsecurityjwt.repository.IPublicationRepository;
import com.example.springsecurityjwt.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/publication")
public class PublicationController {
    @Autowired
    private PublicationService pubser;
    @Autowired
   private IPublicationRepository pubrep;
    @PostMapping("add-pub")
    @ResponseBody
    public Publication addPublication (@RequestBody Publication p) {
        Publication pu = pubser.addPublication(p);
        return pu;
    }
    @DeleteMapping("/delete/{pub-id}")
    @ResponseBody
    public void removeChat(@PathVariable("pub-id") long pubId) {
        pubser.deletePublication(pubId);
    }

    @PutMapping("/modify-pub")
    @ResponseBody
    public Publication modifyChat(@RequestBody Publication pub) {
        return pubser.updatePublication(pub);
    }
    @GetMapping("/retrieve-all-pub")
    @ResponseBody
    public List<Publication> getPub() {
        List<Publication> list = pubser.retrieveAllPublication();
        return list;
    }

    @GetMapping("/retrieve-pub/{pub-id}")
    @ResponseBody
    public Publication retrievePub(@PathVariable("pub-id") Long id) {
        return pubser.retrievePublication(id);
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/retrieve-lastPub")
    @ResponseBody
    public Publication retrieveLastPub() {
        return pubrep.findFirstByOrderByIdDesc();
    }
    @Secured("ROLE_ADMIN")
    @GetMapping("/CountPublication")
    @ResponseBody
    public Long  countPub() {
        return pubrep.countPublicationById();
    }
    @Secured("ROLE_ADMIN")
    @GetMapping("/retrieve-all-pubWithLastModifiedDateExists")
    @ResponseBody
    public Optional<Publication> getPubLastModifiedDateExists() {
        Optional<Publication> list = Optional.ofNullable(pubrep.findPublicationByLastModifiedDateIsNotNull().orElse(null));
        return list;
    }
}