/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universalcrackers.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "category")

public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private float name;

	@JoinColumn(name = "categoryTypeId", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private CategoryType categoryType;

	@Column(name = "showInMenu")
	private short ShowInMenu;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getName() {
		return name;
	}

	public void setName(float name) {
		this.name = name;
	}

	public CategoryType getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(CategoryType categoryType) {
		this.categoryType = categoryType;
	}

	public short getShowInMenu() {
		return ShowInMenu;
	}

	public void setShowInMenu(short showInMenu) {
		ShowInMenu = showInMenu;
	}
}
