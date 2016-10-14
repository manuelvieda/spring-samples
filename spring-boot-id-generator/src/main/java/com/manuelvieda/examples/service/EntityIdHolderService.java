/*
 * PayU Latam - Copyright (c) 2013 - 2016
 * http://www.payu.com.co
 * Date:   14/ 10/2016
 */
package com.manuelvieda.examples.service;

import com.manuelvieda.examples.domain.EntityIdHolder;

/**
 * @author Manuel E Vieda
 * @version 1.0
 */
public interface EntityIdHolderService {

	EntityIdHolder getAndIncrement(String entityName);
	EntityIdHolder getAndIncrementDatabase(String entityName);

}
