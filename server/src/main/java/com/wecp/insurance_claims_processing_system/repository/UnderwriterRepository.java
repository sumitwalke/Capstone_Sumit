package com.wecp.insurance_claims_processing_system.repository;

import com.wecp.insurance_claims_processing_system.entity.Underwriter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnderwriterRepository extends JpaRepository<Underwriter, Long>{
}
