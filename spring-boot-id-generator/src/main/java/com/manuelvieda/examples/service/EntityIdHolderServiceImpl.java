/*
 * PayU Latam - Copyright (c) 2013 - 2016
 * http://www.payu.com.co
 * Date:   14/ 10/2016
 */
package com.manuelvieda.examples.service;

import com.manuelvieda.examples.domain.EntityIdHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * @author Manuel E Vieda
 * @version 1.0
 */
@Service
public class EntityIdHolderServiceImpl implements EntityIdHolderService {

	private EntityIdHolderRepository repository;

	public EntityIdHolderServiceImpl(EntityIdHolderRepository repository) {

		this.repository = repository;

	}

	@Transactional(propagation = Propagation.REQUIRED, timeout = 10)
	@Override
	public EntityIdHolder getAndIncrement(String entityName) {

		Assert.notNull(entityName, "Entity name must not be null");

		/*EntityIdHolder entityIdHolder = repository.findByEntity(entityName);
		EntityIdHolder response = new EntityIdHolder(entityIdHolder);
		entityIdHolder.increment();
		repository.save(entityIdHolder);
		return response;
*/
		EntityIdHolder entityIdHolder = repository.findByEntity(entityName);
		entityIdHolder.increment();
		repository.save(entityIdHolder);
		return entityIdHolder;
	}

	@Override
	public EntityIdHolder getAndIncrementDatabase(String entityName) {

		Assert.notNull(entityName, "Entity name must not be null");
		return repository.updateAndReturn(entityName);
	}
}
