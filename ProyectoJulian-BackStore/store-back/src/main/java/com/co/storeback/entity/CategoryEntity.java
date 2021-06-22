/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.storeback.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.co.storeback.enums.StatusCategoryEnum;

/**
 *
 * @author user
 */
@Entity
@Table(name = "category")
@NamedQueries({
    @NamedQuery(name = "CategoryEntity.findAll", query = "SELECT c FROM CategoryEntity c")})
public class CategoryEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusCategoryEnum status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategory", fetch = FetchType.LAZY)
    private List<ReferenceEntity> referenceEntityList;
    @OneToMany(mappedBy = "idCategory", fetch = FetchType.LAZY)
    private List<CategoryEntity> categoryEntityList;
    @JoinColumn(name = "id_category", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private CategoryEntity idCategory;

    public CategoryEntity() {
    }

    public CategoryEntity(Integer id) {
        this.id = id;
    }

    public CategoryEntity(Integer id, String name, StatusCategoryEnum status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatusCategoryEnum getStatus() {
        return status;
    }

    public void setStatus(StatusCategoryEnum status) {
        this.status = status;
    }

    public List<ReferenceEntity> getReferenceEntityList() {
        return referenceEntityList;
    }

    public void setReferenceEntityList(List<ReferenceEntity> referenceEntityList) {
        this.referenceEntityList = referenceEntityList;
    }

    public List<CategoryEntity> getCategoryEntityList() {
        return categoryEntityList;
    }

    public void setCategoryEntityList(List<CategoryEntity> categoryEntityList) {
        this.categoryEntityList = categoryEntityList;
    }

    public CategoryEntity getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(CategoryEntity idCategory) {
        this.idCategory = idCategory;
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
        if (!(object instanceof CategoryEntity)) {
            return false;
        }
        CategoryEntity other = (CategoryEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.storeback.entity.CategoryEntity[ id=" + id + " ]";
    }
    
}
