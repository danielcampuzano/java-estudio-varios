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

import com.co.storeback.enums.StatusReferenceEnum;
import com.co.storeback.enums.VisibleReferenceEnum;

/**
 *
 * @author user
 */
@Entity
@Table(name = "reference")
@NamedQueries({ @NamedQuery(name = "ReferenceEntity.findAll", query = "SELECT r FROM ReferenceEntity r") })
public class ReferenceEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Basic(optional = false)
	@Column(name = "codigo")
	private String codigo;
	@Basic(optional = false)
	@Column(name = "name")
	private String name;
	@Basic(optional = false)
	@Column(name = "description")
	private String description;
	@Basic(optional = false)
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private StatusReferenceEnum status;
	@Basic(optional = false)
	@Enumerated(EnumType.STRING)
	@Column(name = "visible")
	private VisibleReferenceEnum visible;
	@Basic(optional = false)
	@Column(name = "search_quanty")
	private long searchQuanty;
	@JoinColumn(name = "id_category", referencedColumnName = "id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private CategoryEntity idCategory;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idReference", fetch = FetchType.EAGER)
	private List<ProductEntity> productEntityList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idReference", fetch = FetchType.LAZY)
	private List<PriceEntity> priceEntityList;

	public ReferenceEntity() {
	}

	public ReferenceEntity(Integer id) {
		this.id = id;
	}

	public ReferenceEntity(Integer id, String codigo, String name, String description, StatusReferenceEnum status,
			VisibleReferenceEnum visible, long searchQuanty) {
		this.id = id;
		this.codigo = codigo;
		this.name = name;
		this.description = description;
		this.status = status;
		this.visible = visible;
		this.searchQuanty = searchQuanty;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public StatusReferenceEnum getStatus() {
		return status;
	}

	public void setStatus(StatusReferenceEnum status) {
		this.status = status;
	}

	public VisibleReferenceEnum getVisible() {
		return visible;
	}

	public void setVisible(VisibleReferenceEnum visible) {
		this.visible = visible;
	}

	public long getSearchQuanty() {
		return searchQuanty;
	}

	public void setSearchQuanty(long searchQuanty) {
		this.searchQuanty = searchQuanty;
	}

	public CategoryEntity getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(CategoryEntity idCategory) {
		this.idCategory = idCategory;
	}

	public List<ProductEntity> getProductEntityList() {
		return productEntityList;
	}

	public void setProductEntityList(List<ProductEntity> productEntityList) {
		this.productEntityList = productEntityList;
	}

	public List<PriceEntity> getPriceEntityList() {
		return priceEntityList;
	}

	public void setPriceEntityList(List<PriceEntity> priceEntityList) {
		this.priceEntityList = priceEntityList;
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
		if (!(object instanceof ReferenceEntity)) {
			return false;
		}
		ReferenceEntity other = (ReferenceEntity) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.co.storeback.entity.ReferenceEntity[ id=" + id + " ]";
	}

}
