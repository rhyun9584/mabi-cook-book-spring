package com.j1001000.mabicookbook.dao;

import com.j1001000.mabicookbook.domain.Collect;
import com.j1001000.mabicookbook.vo.CollectId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollectRepository extends JpaRepository<Collect, CollectId> {
    public List<Collect> findByIdUserIdOrderByIdCookId(Long userId);
}
