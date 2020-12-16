package com.cs.api.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.api.entity.Customer;
import com.cs.api.entity.Transaction;
import com.cs.api.repository.CustomerRepository;
import com.cs.api.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transRepo;
	@Autowired
	CustomerRepository custRepo;
	
	@Override
	public List<Transaction> findAll() {
		List<Transaction>  listTrans = new ArrayList<Transaction>();
		listTrans= transRepo.findAll();
		return listTrans;
	}
	
	@Override
	public Transaction findOne(Integer id) {
		Transaction transaction = new Transaction();
		transaction = transRepo.getOne(id);
		return transaction;
	}

	@Override
	public List<Transaction> findBySenderId(Integer s_id) {
		return transRepo.findAllBySenderId(s_id);
	}
	
	@Override
	public List<Transaction> findBySenderName(String s_name) {
		List<Transaction> senderTransactions = new ArrayList<Transaction>();
		List<Customer> custDetails = custRepo.findByCustomerName(s_name);
		for(Customer cust: custDetails ) {
			List<Transaction> custTrans = transRepo.findAllBySenderId(cust.getId());
			senderTransactions.addAll(custTrans);
		}
		return senderTransactions;
	}

	@Override
	public List<Transaction> findByReceiverId(Integer r_id) {
		return transRepo.findAllByReceiverId(r_id);
	}

	@Override
	public List<Transaction> findByItemType(String itemType) {
		return transRepo.findAllByItemType(itemType);
	}

	@Override
	public List<Transaction> findByStartDate(Date startDate) {
		return transRepo.findAllByStartDate(startDate);
	}

	@Override
	public List<Transaction> findByDeliveryDate(Date deliveryDate) {
		return transRepo.findAllByDeliveryDate(deliveryDate);
	}

	@Override
	public List<Transaction> findDeliveyType(String deliveryType) {
		return transRepo.findAllByDeliveryType(deliveryType);
	}

	@Override
	public List<Transaction> findByItemCategory(String itemCategory) {
		return transRepo.findAllByItemCategory(itemCategory);
	}

	@Override
	public List<Transaction> findByStoreId(Integer store_id) {
		return transRepo.findAllByStoreId(store_id);
	}

	@Override
	public List<Transaction> performedBy(Integer manager_id) {
		return transRepo.findAllByManagerId(manager_id);
	}
	
}
