package com.boots.repository;

import com.boots.entity.Parents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<Parents,Integer> {
}
