package com.nttdata.bootcamp.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "product_enterprises")
@Builder
public class ProductEnterprise {
	@Id
	private String id;
	private String idCustomerEnterprise;
	private List<BusinessCredit> businessCredits;
	private List<CurrentAccount> currentAccounts;
}
