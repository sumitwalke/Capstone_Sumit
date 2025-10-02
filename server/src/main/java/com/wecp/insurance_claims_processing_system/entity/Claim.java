package com.wecp.insurance_claims_processing_system.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

@Entity
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String status;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "policyholder_id")
    private Policyholder policyholder;

    @ManyToOne
    @JoinColumn(name = "adjuster_id")
    private Adjuster adjuster;

    @ManyToOne
    @JoinColumn(name = "underwriter_id")
    private Underwriter underwriter;

    @OneToOne(mappedBy = "claim")
    @JsonIgnore
    private Investigation investigation;

    public Claim() {
    }

    public Claim(Long id, String description, String status, Date date, Policyholder policyholder, Adjuster adjuster,
            Underwriter underwriter, Investigation investigation) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.date = date;
        this.policyholder = policyholder;
        this.adjuster = adjuster;
        this.underwriter = underwriter;
        this.investigation = investigation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Policyholder getPolicyholder() {
        return policyholder;
    }

    public void setPolicyholder(Policyholder policyholder) {
        this.policyholder = policyholder;
    }

    public Adjuster getAdjuster() {
        return adjuster;
    }

    public void setAdjuster(Adjuster adjuster) {
        this.adjuster = adjuster;
    }

    public Underwriter getUnderwriter() {
        return underwriter;
    }

    public void setUnderwriter(Underwriter underwriter) {
        this.underwriter = underwriter;
    }

    public Investigation getInvestigation() {
        return investigation;
    }

    public void setInvestigation(Investigation investigation) {
        this.investigation = investigation;
    }
}
