package com.sitetasik.backend.repository;

import com.sitetasik.backend.model.Datel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DatelRepository extends PagingAndSortingRepository<Datel, UUID>, CrudRepository<Datel, UUID> {
    @Query("SELECT c from Datel c WHERE c.id = :id")
    Datel getById(@Param("id") UUID id);

    @Query("SELECT c FROM Datel c")
    List<Datel> getAll();
}
