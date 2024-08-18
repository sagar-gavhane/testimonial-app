package com.testimonial.service;

import com.testimonial.entity.Space;
import com.testimonial.exception.SpaceExistException;
import com.testimonial.exception.SpaceNotExistException;
import com.testimonial.repository.SpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpaceService {
    @Autowired
    private SpaceRepository spaceRepository;

    public Space create(Space space) {
        Optional<Space> spaceOptional = spaceRepository.findByUrl(space.getUrl());

        if (spaceOptional.isPresent()) {
            throw new SpaceExistException("Space with url '" + space.getUrl() + "' already exists");
        }

        return spaceRepository.save(space);
    }

    public List<Space> getAll() {
        return spaceRepository.findAll();
    }

    public Space getBySpaceID(Long spaceId) {
        return spaceRepository.findById(spaceId).orElseThrow(() -> new SpaceNotExistException("Space with id '" + spaceId + "' does not exists."));
    }

    public Space getBySpaceUrl(String spaceUrl) {
        return spaceRepository.findByUrl("/" + spaceUrl).orElseThrow(() -> new SpaceNotExistException("Space with url '/" + spaceUrl + "' does not exists."));
    }
}
