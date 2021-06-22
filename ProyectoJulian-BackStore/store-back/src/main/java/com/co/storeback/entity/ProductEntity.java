/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.storeback.entity;

import java.io.Serializable;
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

import com.co.storeback.enums.StatusProductEnum;

/**
 *
 * @author user
 */
@Entity
@Table(name = "product")
@NamedQueries({
    @NamedQuery(name = "ProductEntity.findAll", query = "SELECT p FROM ProductEntity p")})
public class ProductEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ean")
    private String ean;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusProductEnum status;
    @JoinColumn(name = "id_color", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ColorEntity idColor;
    @JoinColumn(name = "id_reference", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ReferenceEntity idReference;
    @JoinColumn(name = "id_size", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private SizeEntity idSize;

    public ProductEntity() {
    }

    public ProductEntity(Integer id) {
        this.id = id;
    }

    public ProductEntity(Integer id, String ean, StatusProductEnum status) {
        this.id = id;
        this.ean = ean;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public StatusProductEnum getStatus() {
        return status;
    }

    public void setStatus(StatusProductEnum status) {
        this.status = status;
    }

    public ColorEntity getIdColor() {
        return idColor;
    }

    public void setIdColor(ColorEntity idColor) {
        this.idColor = idColor;
    }

    public ReferenceEntity getIdReference() {
        return idReference;
    }

    public void setIdReference(ReferenceEntity idReference) {
        this.idReference = idReference;
    }

    public SizeEntity getIdSize() {
        return idSize;
    }

    public void setIdSize(SizeEntity idSize) {
        this.idSize = idSize;
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
        if (!(object instanceof ProductEntity)) {
            return false;
        }
        ProductEntity other = (ProductEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.storeback.entity.ProductEntity[ id=" + id + " ]";
    }
    
}
