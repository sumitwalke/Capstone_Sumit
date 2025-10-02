package com.wecp.insurance_claims_processing_system.service;


import com.wecp.insurance_claims_processing_system.entity.Claim;
import com.wecp.insurance_claims_processing_system.entity.Policyholder;
import com.wecp.insurance_claims_processing_system.entity.Underwriter;
import com.wecp.insurance_claims_processing_system.repository.ClaimRepository;
import com.wecp.insurance_claims_processing_system.repository.PolicyholderRepository;
import com.wecp.insurance_claims_processing_system.repository.UnderwriterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimService {
    
    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private PolicyholderRepository policyholderRepository;

    @Autowired
    private UnderwriterRepository underwriterRepository;

    public Claim submitClaim(Long policyholderId, Claim claim){
        Policyholder policyholder = policyholderRepository.findById(policyholderId).get();
        claim.setPolicyholder(policyholder);
        return claimRepository.save(claim);
    }

    public List<Claim> getClaimsByPolicyholder(Long policyholderId){
        Policyholder policyholder = policyholderRepository.findById(policyholderId).get();
        List<Claim> claims = claimRepository.getClaimsByPolicyholder(policyholderId);
        return claims;
    }

    public Claim updateClaim(Long id, Claim claim){
        Claim updatedClaim = claimRepository.findById(id).get();
        claim.setId(updatedClaim.getId());
        return claimRepository.save(claim);
    }

    public List<Claim> getAllClaims(){
        List<Claim> claims = claimRepository.findAll();
        return claims;
    }

    public List<Underwriter> getAllUnderwriters(){
        List<Underwriter> underwriters = underwriterRepository.findAll();
        return underwriters;
    }

    public Claim assignClaim(Long claimId, Long underwriterId){
        Claim claim = claimRepository.findById(claimId).get();
        Underwriter underwriter = underwriterRepository.findById(underwriterId).get();
        if(claim!= null && underwriter!=null){
            claim.setUnderwriter(underwriter);
            return claim;
        } else {
            throw new IllegalArgumentException("Claim or Underwriter not found");
        }

    }

    public List<Claim> getAllClaimsForReview(Long underwriterId){
        Underwriter underwriter = underwriterRepository.findById(underwriterId).get();
        List<Claim> claims = claimRepository.findByUnderwriter(underwriter);
        return claims;
    }

    public Claim reviewClaim(Long id, String status){
        Claim claim = claimRepository.findById(id).get();
        claim.setStatus(status);
        claimRepository.save(claim);
        return claim;
    }

    public Claim getClaimById(Long claimId){
        Claim claim = claimRepository.findById(claimId).get();
        return claim;
    }
}
