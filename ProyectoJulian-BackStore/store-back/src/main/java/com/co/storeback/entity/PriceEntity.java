/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.storeback.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.co.storeback.enums.StatusPriceEnum;

/**
 *
 * @author user
 */
@Entity
@Table(name = "price")
@NamedQueries({
    @NamedQuery(name = "PriceEntity.findAll", query = "SELECT p FROM PriceEntity p")})
public class PriceEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "cost")
    private BigDecimal cost;
    @Basic(optional = false)
    @Column(name = "discount_per")
    private BigDecimal discountPer;
    @Basic(optional = false)
    @Column(name = "discount_cost")
    private BigDecimal discountCost;
    @Basic(optional = false)
    @Column(name = "total_cost")
    private BigDecimal totalCost;
    @Basic(optional = false)
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusPriceEnum status;
    @JoinColumn(name = "id_reference", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ReferenceEntity idReference;

    public PriceEntity() {
    }

    public PriceEntity(Integer id) {
        this.id = id;
    }

    public PriceEntity(Integer id, BigDecimal cost, BigDecimal discountPer, BigDecimal discountCost, BigDecimal totalCost, Date startDate, Date endDate, StatusPriceEnum status) {
        this.id = id;
        this.cost = cost;
        this.discountPer = discountPer;
        this.discountCost = discountCost;
        this.totalCost = totalCost;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getDiscountPer() {
        return discountPer;
    }

    public void setDiscountPer(BigDecimal discountPer) {
        this.discountPer = discountPer;
    }

    public BigDecimal getDiscountCost() {
        return discountCost;
    }

    public void setDiscountCost(BigDecimal discountCost) {
        this.discountCost = discountCost;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public StatusPriceEnum getStatus() {
        return status;
    }

    public void setStatus(StatusPriceEnum status) {
        this.status = status;
    }

    public ReferenceEntity getIdReference() {
        return idReference;
    }

    public void setIdReference(ReferenceEntity idReference) {
        this.idReference = idReference;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PriceEntity)) {
            return false;
        }
        PriceEntity other = (PriceEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.storeback.entity.PriceEntity[ id=" + id + " ]";
    }
    
}
