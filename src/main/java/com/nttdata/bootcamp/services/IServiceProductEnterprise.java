package com.nttdata.bootcamp.services;

import com.nttdata.bootcamp.models.ProductEnterprise;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IServiceProductEnterprise {
	public Flux<ProductEnterprise> findAll();
	public Mono<ProductEnterprise> findById(String id);
	public Mono<ProductEnterprise> findByIdCustomerEnterprise(String idCustomerEnterprise);
	public Mono<ProductEnterprise> save(ProductEnterprise productEnterprise);
	public Mono<Void> delete(ProductEnterprise productEnterprise);
}
