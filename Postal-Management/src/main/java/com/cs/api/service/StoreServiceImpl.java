package com.cs.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cs.api.entity.Store;
import com.cs.api.repository.StoreRepository;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	StoreRepository storeRepository;

	@Override
	public Store insertStore(Store store) {
		Store _store = storeRepository.save(new Store(store.getName(), store.getAddreessLine(), store.getCity(),
				store.getState(), store.getZipCode(), store.getCountry()));
		return _store;
	}

	@Override
	public Store findById(Integer id) {
		if (id != null) {
			Optional<Store> storeData = storeRepository.findById(id);

			if (storeData.isPresent()) {
				return storeData.get();
			}
		}

		return null;
	}

	@Override
	public Store findByName(String storeName) {
		if (!StringUtils.isEmpty(storeName)) {
			List<Store> stores = new ArrayList<Store>();
			storeRepository.findByName(storeName).forEach(stores::add);
			return (stores.isEmpty()) ? null : stores.get(0);
		}

		return null;
	}

	@Override
	public List<Store> findAll() {
		return storeRepository.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		if(id!=null)
		storeRepository.deleteById(id);
	}

	@Override
	public Store updateStore(int id, Store store) {
		//it will be updated auto as it will be present in persistent contxt
		Store _store = findById(id);
		if(store!=null){
			if (!store.getName().isEmpty())
				_store.setName(store.getName());// name is not nullable
			
			_store.setAddreessLine(store.getAddreessLine());
			_store.setCity(store.getCity());
			_store.setState(store.getState());
			_store.setZipCode(store.getZipCode());
			_store.setCountry(store.getCountry());
		}
		return _store;
	}

}
