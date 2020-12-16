package com.cs.api.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "customer",indexes = {
		@Index( name = "customer_name_idx", columnList = "name")
		})
public class Customer {

	@Column(name = "ID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// @GeneratedValue(strategy = GenerationType.SEQUENCE,
	// generator="CUSTOMER_SEQ_GEN")
	// @SequenceGenerator(name="CUSTOMER_SEQ_GEN", sequenceName="CUSTOMER_SEQ",
	// allocationSize=1)
	private Integer id;

	@Column(nullable = false, length = 255)
	private String name;

	@ElementCollection
	@CollectionTable(name = "customer_emails", joinColumns = @JoinColumn(name = "customer_id"))
	@Column(name = "emailID")
	private Set<String> emails = new HashSet<>();

	private String addreessLine;

	private String city;

	private String state;

	private String zipCode;

	private String country;

	@ElementCollection
	@CollectionTable(name = "customer_phone_numbers", joinColumns = @JoinColumn(name = "customer_id"))
	@Column(name = "phone_number")
	private Set<String> phoneNumbers = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Set<String> getEmails() {
		return emails;
	}

	public void setEmails(Set<String> emails) {
		this.emails = emails;
	}

	public String getAddreessLine() {
		return addreessLine;
	}

	public void setAddreessLine(String addreessLine) {
		this.addreessLine = addreessLine;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Set<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public Customer(String name, Set<String> emails, String addreessLine, String city, String state, String zipCode,
			String country, Set<String> phoneNumbers) {
		super();
		this.name = name;
		this.emails = emails;
		this.addreessLine = addreessLine;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
		this.phoneNumbers = phoneNumbers;
	}

}
