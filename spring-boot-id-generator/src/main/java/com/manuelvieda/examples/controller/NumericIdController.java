/*
 * PayU Latam - Copyright (c) 2013 - 2016
 * http://www.payu.com.co
 * Date:   14/ 10/2016
 */
package com.manuelvieda.examples.controller;

import com.manuelvieda.examples.domain.EntityIdHolder;
import com.manuelvieda.examples.service.EntityIdHolderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Manuel E Vieda
 * @version 1.0
 */
@Controller
@RequestMapping("/numeric")
public class NumericIdController {

	private EntityIdHolderService idService;

	NumericIdController(EntityIdHolderService idService){
		this.idService = idService;
	}

	/**
	 *
	 * @param entityName
	 * @return
	 */
	@GetMapping(value = "consecutive/range/{entityName:.+}")
	@ResponseBody
	public EntityIdHolder requestId(@PathVariable String entityName) {

		//  return idService.getAndIncrement(entityName);
		return idService.getAndIncrementDatabase(entityName);
	}
}
