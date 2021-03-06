package com.nttdata.bootcamp.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SavingAccount {
	private String accountingBalance;
	private String maintenance;
	private String movementLimit;
}
