package com.cs.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cs.api.entity.Store;
import com.cs.api.service.StoreService;

@RestController
@RequestMapping("/api/store")
public class StoreController {

	@Autowired
	StoreService storeService;

	@RequestMapping("/stores")
	public ResponseEntity<List<Store>> getAllStores(@RequestParam(required = false) String name) {
		try {
			List<Store> stores = new ArrayList<Store>();

			if (name == null)
				stores = storeService.findAll();
			else {

				Store store = storeService.findByName(name);
				if (store != null)
					stores.add(store);
			}

			if (stores.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(stores, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/stores/{id}")
	public ResponseEntity<Store> getStoreById(@PathVariable("id") int id) {
		Store storeData = storeService.findById(id);

		if (storeData != null) {
			return new ResponseEntity<>(storeData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/stores", method = RequestMethod.POST)
	public ResponseEntity<Store> createStore(@RequestBody Store store) {
		try {
			Store _store = storeService.insertStore(store);
			return new ResponseEntity<>(_store, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/stores/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Store> updateStore(@PathVariable("id") int id, @RequestBody Store store) {
		Store _store = storeService.updateStore(id, store);
		if (_store == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>((_store), HttpStatus.OK);

	}

	@RequestMapping(value = "/stores/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deleteStore(@PathVariable("id") int id) {
		try {
			storeService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
