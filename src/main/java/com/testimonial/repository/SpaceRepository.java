package com.testimonial.repository;

import com.testimonial.entity.Space;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpaceRepository extends JpaRepository<Space, Long> {
    Optional<Space> findByUrl(String url);

    Optional<Space> findByName(String name);
}
