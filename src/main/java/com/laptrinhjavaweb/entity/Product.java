package com.laptrinhjavaweb.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "KHONG DUOC BO TRONGgg")
	private String name;
	
	@NotBlank(message = "name 2 ko duoc bo trong")
	private String name2;
	
	@NotNull(message= "amount may not be empty")
	@Min(value=3, message = "amount it nhat la 3")
	private Integer amount;
	
	// mappedBy phải giống tên thuộc tính bên ProductClass.
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	@NotNull(message = "productClasses khong duoc null")
	@Valid
	private List<ProductClass> productClasses;
}
