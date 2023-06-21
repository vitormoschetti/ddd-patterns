package br.com.ddd.infrastructure.repository;

import br.com.ddd.BaseTeste;
import br.com.ddd.domain.product.repository.IProductRepository;
import br.com.ddd.infrastructure.repository.memory.adapter.impl.ProductRepositoryMemoryAdapterImpl;
import br.com.ddd.infrastructure.repository.memory.mock.ProductsMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ProductRepositoryTest extends BaseTeste {

    private IProductRepository repository;

    @BeforeEach
    public void init() {
        final var memoryAdapter = new ProductRepositoryMemoryAdapterImpl(new ProductsMock());
        this.repository = new ProductRepository(memoryAdapter);
    }

    @Test
    @DisplayName("should find product by id")
    public void shouldFindById() {

        final var product1 = this.repository.findById("product-test");

        Assertions.assertNotNull(product1);
        Assertions.assertEquals("product-test", product1.getName());

    }

    @Test
    @DisplayName("should find all products")
    public void shouldFindAll() {

        final var products = this.repository.findAll();

        Assertions.assertNotNull(products);
        Assertions.assertEquals(6, products.size());

    }

    @Test
    @DisplayName("should create product with name 'product1'")
    public void shouldCreateProductNameProduct1() {

        final var product1 = this.buildProductWith("product1", BigDecimal.TEN);

        this.repository.create(product1);

        final var result = this.repository.findById(product1.getId());

        Assertions.assertEquals("product1", result.getName());

    }

    @Test
    @DisplayName("should update product price with name 'product1'")
    public void shouldUpadateProductPriceWithNameProduct1() {

        final var product1 = this.buildProductWith("product1", BigDecimal.TEN);

        this.repository.create(product1);

        product1.changePrice(new BigDecimal(100L));

        this.repository.update(product1);

        final var result = this.repository.findById(product1.getId());

        Assertions.assertEquals(new BigDecimal(100L), result.getPrice());

    }

}
