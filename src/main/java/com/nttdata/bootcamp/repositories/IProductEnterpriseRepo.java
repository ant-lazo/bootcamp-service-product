package com.nttdata.bootcamp.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.bootcamp.models.ProductEnterprise;

import reactor.core.publisher.Mono;

public interface IProductEnterpriseRepo extends ReactiveMongoRepository<ProductEnterprise, String>{
	
	public Mono<ProductEnterprise> findByIdCustomerEnterprise(String idCustomerEnterprise);

}
