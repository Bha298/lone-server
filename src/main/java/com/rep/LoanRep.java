package com.rep;

import com.entity.Lone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRep extends JpaRepository<Lone, Integer> {
    List<Lone> findByType(String type);
}
