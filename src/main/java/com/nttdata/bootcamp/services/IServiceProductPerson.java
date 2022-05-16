package com.nttdata.bootcamp.services;

import com.nttdata.bootcamp.models.ProductPerson;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IServiceProductPerson {
	public Flux<ProductPerson> findAll();
	public Mono<ProductPerson> findById(String id);
	public Mono<ProductPerson> findByIdCustomerPerson(String id);
	public Mono<ProductPerson> save(ProductPerson productPerson);
	public Mono<Void> delete(ProductPerson productPerson);
}
