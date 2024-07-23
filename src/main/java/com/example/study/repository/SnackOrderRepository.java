package com.example.study.repository;

import com.example.study.domain.mapping.SnackOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnackOrderRepository extends JpaRepository<SnackOrder, Long> {
}
