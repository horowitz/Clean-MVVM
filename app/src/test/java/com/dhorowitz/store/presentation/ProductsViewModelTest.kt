package com.dhorowitz.store.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dhorowitz.store.domain.ProductsInteractor
import com.dhorowitz.store.domain.ProductsPresentationMapper
import com.dhorowitz.store.presentation.product.ProductType
import com.dhorowitz.store.presentation.product.ProductType.*
import com.dhorowitz.store.presentation.product.ProductViewEntity
import com.dhorowitz.store.presentation.product.ProductsViewModel
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.amshove.kluent.`should equal`
import org.amshove.kluent.shouldEqualTo
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class ProductsViewModelTest {
    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var interactor: ProductsInteractor

    @Mock
    lateinit var mapper: ProductsPresentationMapper

    private val viewModel by lazy { ProductsViewModel(interactor, mapper) }

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `should load products given interactor fetched successfully`() {
        val code = Unknown
        val name = "name"
        val price = 10.0
        val formattedPrice = "€10.00"
        val products = listOf(ProductViewEntity(code, name, price, formattedPrice))

        givenInteractorFetchedSuccessfully()
        givenProductsMappedCorrectly(products)

        viewModel.loadProducts()

        viewModel.products.observeForever {
            with(it) {
                size shouldEqualTo 1
                first().code `should equal`  Unknown
                first().name shouldEqualTo name
                first().formattedPrice shouldEqualTo formattedPrice
            }
        }
    }

    private fun givenInteractorFetchedSuccessfully() {
        whenever(interactor.fetchProducts()).thenReturn(Single.just(emptyList()))
    }

    private fun givenProductsMappedCorrectly(products: List<ProductViewEntity>) {
        whenever(mapper.mapToPresentation(any())).thenReturn(products)
    }
}

