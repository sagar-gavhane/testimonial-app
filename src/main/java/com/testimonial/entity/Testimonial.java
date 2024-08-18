package com.testimonial.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "testimonials")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Testimonial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "spaceId", nullable = false)
    private Space space;

    private String name;
    private String email;
    private String message;
    private boolean isFavourite = false;
    private LocalDateTime submittedDate = LocalDateTime.now();
}
