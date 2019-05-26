package com.dhorowitz.store.domain

import com.dhorowitz.store.data.ProductsDto
import com.dhorowitz.store.data.ProductsRepository
import com.dhorowitz.store.domain.model.ProductDomainEntity
import com.dhorowitz.store.mock.STORE_MOCK_RESPONSE
import com.google.gson.Gson
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import java.lang.Exception

class ProductsInteractorImplTest {
    @Mock
    lateinit var repository: ProductsRepository

    @Mock
    lateinit var mapper: ProductsMapper

    private val interactor by lazy { ProductsInteractorImpl(repository, mapper) }
    private val productsDto = Gson().fromJson(STORE_MOCK_RESPONSE, ProductsDto::class.java)

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `should return products given retrieval and mapping successful`() {
        givenProductsMappedCorrectly()
        givenProductsFetchedCorrectly()

        val products = interactor.fetchProducts()
            .test()
            .assertNoErrors()
            .assertComplete()
            .values()
            .first()

        assert(products.size == 3)
    }

    @Test
    fun `should return error when product fetch fails`(){
        val exception = Exception()
        givenProductsMappedCorrectly()
        givenProductsFetchFails(exception)

        interactor.fetchProducts()
            .test()
            .assertError(exception)
    }

    private fun givenProductsFetchFails(exception: Exception) {
        whenever(repository.fetchProducts()).thenReturn(Single.error(exception))
    }

    private fun givenProductsFetchedCorrectly() {
        whenever(repository.fetchProducts()).thenReturn(Single.just(productsDto))
    }

    private fun givenProductsMappedCorrectly() {
        whenever(mapper.mapToDomain(productsDto))
            .thenReturn(
                listOf(
                    ProductDomainEntity("code", "name", 0.0),
                    ProductDomainEntity("code", "name", 0.0),
                    ProductDomainEntity("code", "name", 0.0)
                )
            )
    }
}