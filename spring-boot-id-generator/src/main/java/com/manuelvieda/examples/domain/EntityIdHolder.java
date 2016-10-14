/*
 * PayU Latam - Copyright (c) 2013 - 2016
 * http://www.payu.com.co
 * Date:   14/ 10/2016
 */
package com.manuelvieda.examples.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * @author Manuel E Vieda
 * @version 1.0
 */
@Entity(name = "id_generator")
public class EntityIdHolder implements Serializable {

	/**
	 * Default class serial version UUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Identifier or name of the entity
	 */
	@Id
	@Column(name = "entity", nullable = false)
	private String entity;

	/**
	 * The current consecutive number associated with the given entity
	 */
	@Column(name = "current_id", nullable = false)
	@NotNull
	private Integer currentId;

	/**
	 *
	 */
	@Column(name = "range", nullable = false)
	@NotNull
	private Integer range;

	/**
	 * Default constructor required by JPA specification.
	 */
	protected EntityIdHolder() {
		// Protected since it shouldn't be used directly
	}

	public  EntityIdHolder(EntityIdHolder other){
		this.entity = other.entity;
		this.currentId = other.currentId;
		this.range = other.range;
	}

	/**
	 * Entity ID Holder model constructor
	 *
	 * @param entity
	 * @param currentId
	 * @param range
	 */
	public EntityIdHolder(String entity, Integer currentId, Integer range) {

		this.entity = entity;
		this.currentId = currentId;
		this.range = range;
	}

	/**
	 * Returns the entity name or identifier
	 * @return The entity name or identifier
	 */
	public String getEntity() {

		return entity;
	}

	/**
	 * Returns the current consecutive number associated with the given entity
	 * @return The current consecutive number associated with the given entity
	 */
	public Integer getCurrentId() {

		return currentId;
	}

	/**
	 * Returns
	 * @return
	 */
	public Integer getRange() {

		return range;
	}

	public void increment() {

		currentId += range;
	}

	@Override
	public String toString() {

		return getEntity() + "[" + getCurrentId() + ", " + getRange() + "]";
	}
}
