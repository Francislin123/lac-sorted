package com.sorted.lac.service.repository.auditoria;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@CacheConfig(cacheNames = "auditoriaRepository")
@Repository
public interface AuditoriaRepository extends JpaRepository<Auditoria, Integer> {}
