package com.sorted.lac.service.repository.licenca;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LicencaRepository extends JpaRepository<Licenca, Integer> {

    @Query(value = "SELECT * FROM public.licenca l1 WHERE l1.licen_codigo = (SELECT MAX(l.licen_codigo) FROM public.licenca l WHERE l.fce_codigo = :fceCodigoParam AND l.status = 'CONCEDIDA')", nativeQuery = true)
    Optional<Licenca> findUltimaLicencaConcedidaByFceCodigo(@Param("fceCodigoParam") final Integer fceCodigoParam);
}
