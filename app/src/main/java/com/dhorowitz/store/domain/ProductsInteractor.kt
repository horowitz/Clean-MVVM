package com.dhorowitz.store.domain

import com.dhorowitz.store.data.ProductsRepository

interface ProductsInteractor {

}

class ProductsInteractorImpl(val repository: ProductsRepository, mapper: ProductsMapper): ProductsInteractor {

}