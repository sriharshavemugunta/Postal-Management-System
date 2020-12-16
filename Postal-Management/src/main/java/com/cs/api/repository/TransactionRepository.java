package com.cs.api.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cs.api.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	@Query("SELECT t FROM Transaction t WHERE t.sender=:senderId")
	public List<Transaction> findAllBySenderId(@Param("senderId") Integer senderId);
	
	@Query("SELECT t FROM Transaction t WHERE t.receiver=:receiverId")
	public List<Transaction> findAllByReceiverId(@Param("receiverId") Integer receiverId);

	@Query("SELECT t FROM Transaction t WHERE t.itemType=:itemType")
	public List<Transaction> findAllByItemType(@Param("itemType") String itemType);

	@Query("SELECT t FROM Transaction t WHERE t.startDate=:startDate")
	public List<Transaction> findAllByStartDate(@Param("startDate") Date startDate);
	
	@Query("SELECT t FROM Transaction t WHERE t.deliveryDate=:deliveryDate")
	public List<Transaction> findAllByDeliveryDate(@Param("deliveryDate") Date deliveryDate);

	@Query("SELECT t FROM Transaction t WHERE t.deliveryType=:deliveryType")
	public List<Transaction> findAllByDeliveryType(@Param("deliveryType") String deliveryType);
	
	@Query("SELECT t FROM Transaction t WHERE t.category=:itemCategory")
	public List<Transaction> findAllByItemCategory(@Param("itemCategory") String itemCategory);
	
	@Query("SELECT t FROM Transaction t WHERE t.store=:storeId")
	public List<Transaction> findAllByStoreId(@Param("storeId") Integer storeId);
	
	@Query("SELECT t FROM Transaction t WHERE t.performedBy=:performedBy")
	public List<Transaction> findAllByManagerId(@Param("performedBy") Integer performedBy);
}
