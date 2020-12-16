package com.cs.api.service;

import java.util.Date;
import java.util.List;

import com.cs.api.entity.Transaction;

public interface TransactionService {
	public List<Transaction> findAll();
	public Transaction findOne(Integer id);
	public List<Transaction> findBySenderId(Integer s_id);	
	public List<Transaction> findBySenderName(String s_name);	
	public List<Transaction> findByReceiverId(Integer r_id);
	public List<Transaction> findByItemType(String itemType);
	public List<Transaction> findByStartDate(Date startDate);
	public List<Transaction> findByDeliveryDate(Date deliveryDate);
	public List<Transaction> findDeliveyType(String deliveryType);
	public List<Transaction> findByItemCategory(String itemCategory);
	public List<Transaction> findByStoreId(Integer store_id);
	public List<Transaction> performedBy(Integer manager_id);
}
