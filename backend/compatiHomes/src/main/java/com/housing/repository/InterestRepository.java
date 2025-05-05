package com.housing.repository;

import com.housing.model.entity.Interest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterestRepository extends JpaRepository<Interest, Long> {
    List<Interest> findByTenantId(Long tenantId);
    boolean existsByTenantIdAndPropertyId(Long tenantId, Long propertyId);
}
