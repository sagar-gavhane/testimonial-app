package com.testimonial.service;

import com.testimonial.entity.Space;
import com.testimonial.entity.Testimonial;
import com.testimonial.exception.TestimonialNotExistException;
import com.testimonial.repository.TestimonialRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestimonialService {
    @Autowired
    private SpaceService spaceService;

    @Autowired
    private TestimonialRepository testimonialRepository;

    @Transactional
    public Testimonial addTestimonialToSpace(Long spaceId, Testimonial testimonial) {
        Space space = spaceService.getBySpaceID(spaceId);

        testimonial.setSpace(space);

        Testimonial savedTestimonial = testimonialRepository.save(testimonial);

        return savedTestimonial;
    }

    public List<Testimonial> getTestimonialsBySpaceId(Long spaceId) {
        spaceService.getBySpaceID(spaceId);

        List<Testimonial> testimonials = testimonialRepository.findAllBySpaceId(spaceId);

        return testimonials;
    }

    @Transactional
    public Testimonial toggleFavourite(Long testimonialId) {
        Testimonial testimonial = testimonialRepository.findById(testimonialId)
                .orElseThrow(() -> new TestimonialNotExistException("Testimonial with id: " + testimonialId + " does not exists."));

        testimonial.setFavourite(!testimonial.isFavourite());

        Testimonial saved = testimonialRepository.save(testimonial);

        return saved;
    }
}
