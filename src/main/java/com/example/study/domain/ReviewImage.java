package com.example.study.domain;

import com.example.study.domain.common.BaseEntity;
import jakarta.persistence.*;

@Entity
public class ReviewImage extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewImage_id")
    private Long id;
    private String imageURL;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="review_id")
    private Review review;
}
