package com.sitetasik.backend.repository;

import com.sitetasik.backend.model.Sto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StoRepository extends PagingAndSortingRepository<Sto, UUID>, CrudRepository<Sto, UUID> {
}
