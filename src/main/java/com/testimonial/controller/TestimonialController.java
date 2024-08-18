package com.testimonial.controller;

import com.testimonial.entity.Testimonial;
import com.testimonial.service.TestimonialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/testimonial")
public class TestimonialController {
    @Autowired
    private TestimonialService testimonialService;

    @GetMapping("/space/{spaceId}")
    public ResponseEntity<List<Testimonial>> getTestimonialsBySpaceId(@PathVariable Long spaceId) {
        List<Testimonial> testimonials = testimonialService.getTestimonialsBySpaceId(spaceId);
        return ResponseEntity.ok(testimonials);
    }

    @PatchMapping("/{testimonialId}")
    public ResponseEntity<Testimonial> toggleFavourite(@PathVariable Long testimonialId) {
        Testimonial testimonial = testimonialService.toggleFavourite(testimonialId);
        return ResponseEntity.ok(testimonial);
    }

    @PostMapping("/{spaceId}")
    public ResponseEntity<Testimonial> addTestimonial(@PathVariable Long spaceId, @RequestBody Testimonial testimonial) {
        Testimonial addedTestimonial = testimonialService.addTestimonialToSpace(spaceId, testimonial);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedTestimonial);
    }
}
