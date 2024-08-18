package com.testimonial.controller;

import com.testimonial.entity.Space;
import com.testimonial.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/space")
public class SpaceController {
    @Autowired
    private SpaceService spaceService;

    @GetMapping
    public ResponseEntity<List<Space>> getAll() {
        List<Space> spaces = spaceService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(spaces);
    }

    @GetMapping("/{spaceId}")
    public ResponseEntity<Space> getBySpaceID(@PathVariable Long spaceId) {
        Space space = spaceService.getBySpaceID(spaceId);
        return ResponseEntity.status(HttpStatus.OK).body(space);
    }

    @GetMapping("/url/{spaceUrl}")
    public ResponseEntity<Space> getBySpaceID(@PathVariable String spaceUrl) {
        Space space = spaceService.getBySpaceUrl(spaceUrl);
        return ResponseEntity.status(HttpStatus.OK).body(space);
    }

    @PostMapping
    public ResponseEntity<Space> create(@RequestBody Space space) {
        Space savedSpace = spaceService.create(space);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSpace);
    }
}
