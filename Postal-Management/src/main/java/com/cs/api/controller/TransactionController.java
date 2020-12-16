package com.cs.api.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cs.api.entity.Transaction;
import com.cs.api.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	@Autowired
	TransactionService transactionService;
	
	@RequestMapping(value="/all", method= RequestMethod.GET)
	 public List<Transaction> findAll(){
		return transactionService.findAll();
	}
	
	@RequestMapping(value="/ById/{id}", method= RequestMethod.GET)
		public Transaction findOne(@PathVariable Integer id) {
		return transactionService.findOne(id);
	}
	
	@RequestMapping(value="/BySender/{s_id}", method= RequestMethod.GET)
	public List<Transaction> findBySenderId(@PathVariable Integer s_id) {
	return transactionService.findBySenderId(s_id);
	}
	
	@RequestMapping(value="/BySenderName/{s_name}", method= RequestMethod.GET)
	public List<Transaction> findBySenderName(@PathVariable String s_name) {
	return transactionService.findBySenderName(s_name);
	}
	
	@RequestMapping(value="/ByReceiver/{r_id}", method= RequestMethod.GET)
	public List<Transaction> findByReceiverId(@PathVariable Integer r_id) {
	return transactionService.findByReceiverId(r_id);
	}
	
	@RequestMapping(value="/ByItemType/{itemType}", method= RequestMethod.GET)
	public List<Transaction> findByItemType(@PathVariable String itemType) {
	return transactionService.findByItemType(itemType);
	}
	
	@RequestMapping(value="/ByStartDate/{startDate}", method= RequestMethod.GET)
	public List<Transaction> findByStartDate(@PathVariable Date startDate) {
	return transactionService.findByStartDate(startDate);
	}
	
	@RequestMapping(value="/ByDeliveryDate/{deliveryDate}", method= RequestMethod.GET)
	public List<Transaction> findByDeliveryDate(@PathVariable Date deliveryDate) {
	return transactionService.findByDeliveryDate(deliveryDate);
	}
	
	@RequestMapping(value="/ByDeliveryType/{deliveryType}", method= RequestMethod.GET)
	public List<Transaction> findByDeliveryType(@PathVariable String deliveryType) {
	return transactionService.findDeliveyType(deliveryType);
	}
	
	@RequestMapping(value="/ByItemCategory/{itemCategory}", method= RequestMethod.GET)
	public List<Transaction> findByItemCategory(@PathVariable String itemCategory) {
	return transactionService.findByItemCategory(itemCategory);
	}
	
	@RequestMapping(value="/findByStoreId/{storeId}", method= RequestMethod.GET)
	public List<Transaction> findByStoreId(@PathVariable Integer storeId) {
	return transactionService.findByStoreId(storeId);
	}
	
	@RequestMapping(value="/performedBy/{managerId}", method= RequestMethod.GET)
	public List<Transaction> performedBy(@PathVariable Integer managerId) {
	return transactionService.performedBy(managerId);
	}
}
