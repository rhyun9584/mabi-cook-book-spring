package com.j1001000.mabicookbook.dao;

import com.j1001000.mabicookbook.domain.Cook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CookRepository extends JpaRepository<Cook, Integer> {
    public List<Cook> findAllByOrderByIdAsc();
}
