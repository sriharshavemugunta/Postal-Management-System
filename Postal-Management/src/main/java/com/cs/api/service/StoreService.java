package com.cs.api.service;

import java.util.List;

import com.cs.api.entity.Store;

public interface StoreService {
	
	public Store insertStore(Store store);
	public Store findById(Integer id);
	public Store findByName(String storeName);
	public List<Store> findAll();
	public void deleteById(Integer id);
	public Store updateStore(int id, Store store);
	

}
