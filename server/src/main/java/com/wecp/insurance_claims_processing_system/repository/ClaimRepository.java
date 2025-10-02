package com.wecp.insurance_claims_processing_system.repository;

import com.wecp.insurance_claims_processing_system.entity.Claim;
import com.wecp.insurance_claims_processing_system.entity.Policyholder;
import com.wecp.insurance_claims_processing_system.entity.Underwriter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long>{

    @Query("SELECT c FROM Claim c WHERE c.policyholder.id = :policyholderId")
    List<Claim> getClaimsByPolicyholder(Long policyholderId);

    List<Claim> findByUnderwriter(Underwriter underwriter);
    List<Claim> findByPolicyholder(Policyholder policyholder);

}

