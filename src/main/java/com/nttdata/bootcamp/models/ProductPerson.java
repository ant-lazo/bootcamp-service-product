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
@Document(collection = "product_persons")
@Builder
public class ProductPerson {
	@Id
	private String id;
	private String idCustomerPerson;
	private PersonalCredit personalCredit;
	private SavingAccount savingAccount;
	private CurrentAccount currentAccount;
	private List<FixedTermAccount> fixedTermAccounts;

}
