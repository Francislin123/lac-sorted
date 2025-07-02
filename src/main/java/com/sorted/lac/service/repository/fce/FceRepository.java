package com.sorted.lac.service.repository.fce;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FceRepository extends JpaRepository<Fce, Integer>, JpaSpecificationExecutor<Fce> {}
