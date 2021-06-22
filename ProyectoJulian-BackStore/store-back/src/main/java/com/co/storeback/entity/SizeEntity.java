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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.co.storeback.enums.StatusSizeEnum;

/**
 *
 * @author user
 */
@Entity
@Table(name = "size")
@NamedQueries({
    @NamedQuery(name = "SizeEntity.findAll", query = "SELECT s FROM SizeEntity s")})
public class SizeEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusSizeEnum status;

    public SizeEntity() {
    }

    public SizeEntity(Integer id) {
        this.id = id;
    }

    public SizeEntity(Integer id, String code, String description, StatusSizeEnum status) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatusSizeEnum getStatus() {
        return status;
    }

    public void setStatus(StatusSizeEnum status) {
        this.status = status;
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
        if (!(object instanceof SizeEntity)) {
            return false;
        }
        SizeEntity other = (SizeEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.storeback.entity.SizeEntity[ id=" + id + " ]";
    }
    
}
