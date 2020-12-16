package com.cs.api.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "employee")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "EMPLOYEE_TYPE")
public class Employee {
	@Column(name = "SSN")
	@Id
	private Long SSN;

	@Column(name = "name", nullable = false, length = 255)
	private String name;

	@ElementCollection
	@CollectionTable(name = "employee_emails", joinColumns = @JoinColumn(name = "employee_id"))
	@Column(name = "emailID")
	private Set<String> emails = new HashSet<>();

	private String addreessLine;

	private String city;

	private String state;

	private String zipCode;

	private String country;
	
	private int salary;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store")
	private Store store;

	@ElementCollection
	@CollectionTable(name = "employee_phone_numbers", joinColumns = @JoinColumn(name = "employee_id"))
	@Column(name = "phone_number")
	private Set<Integer> phoneNumbers = new HashSet<>();

	// self join to describe Employee-Manager Relationship
	@ManyToOne(cascade = { CascadeType.ALL })
	@JsonIgnore
	@JoinTable(name = "employee_manager", joinColumns = {
			@JoinColumn(name = "employee_id", referencedColumnName = "SSN") }, inverseJoinColumns = {
					@JoinColumn(name = "manager_id", referencedColumnName = "SSN") })
	private Employee manager;

	@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY) // Avoiding
																// empty json
																// arrays.objects
	@OneToMany(mappedBy = "manager")
	private Set<Employee> subordinates = new HashSet<Employee>();

	
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Set<Employee> getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(Set<Employee> subordinates) {
		this.subordinates = subordinates;
	}

	public Long getSSN() {
		return SSN;
	}

	public void setSSN(Long sSN) {
		SSN = sSN;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
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

	public Set<Integer> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<Integer> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	
}
