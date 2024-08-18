package com.testimonial.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "spaces")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Space {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String url;
    private String title;
    private String customMessage;
    private LocalDateTime createdAt = LocalDateTime.now();


    // TODO: add questions
    // TODO: user details (name, email, message, )
    @JsonBackReference
    @OneToMany(mappedBy = "space")
    private List<Testimonial> testimonials = new ArrayList<>();
}
