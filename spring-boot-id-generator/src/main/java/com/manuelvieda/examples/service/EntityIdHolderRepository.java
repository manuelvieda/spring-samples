/*
 * PayU Latam - Copyright (c) 2013 - 2016
 * http://www.payu.com.co
 * Date:   14/ 10/2016
 */
package com.manuelvieda.examples.service;

import javax.persistence.LockModeType;

import com.manuelvieda.examples.domain.EntityIdHolder;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 * @author Manuel E Vieda
 * @version 1.0
 */
interface  EntityIdHolderRepository extends Repository<EntityIdHolder, String> {

	/**
	 *
	 * @param entity
	 * @return
	 */
	@Lock(LockModeType.PESSIMISTIC_READ)
	EntityIdHolder findByEntity(String entity);

	/**
	 *
	 * @param entityIdHolder
	 */
	void save(EntityIdHolder entityIdHolder);

	@Query(value = "UPDATE id_generator SET current_id = current_id + range WHERE entity = ?1 RETURNING *",
			nativeQuery = true)
	EntityIdHolder updateAndReturn(String entity);
}
