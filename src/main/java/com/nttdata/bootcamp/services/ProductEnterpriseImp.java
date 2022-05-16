package com.nttdata.bootcamp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bootcamp.models.ProductEnterprise;
import com.nttdata.bootcamp.repositories.IProductEnterpriseRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductEnterpriseImp implements IServiceProductEnterprise{
	
	@Autowired
	IProductEnterpriseRepo enterpriseRepo;

	@Override
	public Flux<ProductEnterprise> findAll() {
		return enterpriseRepo.findAll();
	}

	@Override
	public Mono<ProductEnterprise> findById(String id) {
		return enterpriseRepo.findById(id);
	}
	
	@Override
	public Mono<ProductEnterprise> findByIdCustomerEnterprise(String idCustomerEnterprise) {
		return enterpriseRepo.findById(idCustomerEnterprise);
	}

	@Override
	public Mono<ProductEnterprise> save(ProductEnterprise productEnterprise) {
		return enterpriseRepo.save(productEnterprise);
	}

	@Override
	public Mono<Void> delete(ProductEnterprise productEnterprise) {
		return enterpriseRepo.delete(productEnterprise);
	}

}
