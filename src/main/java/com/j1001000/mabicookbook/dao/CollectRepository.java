package com.j1001000.mabicookbook.dao;

import com.j1001000.mabicookbook.domain.Collect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CollectRepository extends JpaRepository<Collect, Long> {
    @Query("SELECT c FROM Collect c " +
            "JOIN FETCH c.cook " +
            "WHERE c.user.id = :userId")
    public List<Collect> findAllByUserIdWithCook(Long userId);

    public Optional<Collect> findByUserIdAndCookId(Long userId, Integer cookId);

}
