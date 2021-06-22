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

import com.co.storeback.enums.StatusColorEnum;

/**
 *
 * @author user
 */
@Entity
@Table(name = "color")
@NamedQueries({
    @NamedQuery(name = "ColorEntity.findAll", query = "SELECT c FROM ColorEntity c")})
public class ColorEntity implements Serializable {

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
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusColorEnum status;

    public ColorEntity() {
    }

    public ColorEntity(Integer id) {
        this.id = id;
    }

    public ColorEntity(Integer id, String code, String name, StatusColorEnum status) {
        this.id = id;
        this.code = code;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatusColorEnum getStatus() {
        return status;
    }

    public void setStatus(StatusColorEnum status) {
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
        if (!(object instanceof ColorEntity)) {
            return false;
        }
        ColorEntity other = (ColorEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.storeback.entity.ColorEntity[ id=" + id + " ]";
    }
    
}
