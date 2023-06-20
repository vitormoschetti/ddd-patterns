package br.com.ddd.domain.service;

import br.com.ddd.core.domain.IService;
import br.com.ddd.domain.entity.product.Product;

import java.math.BigDecimal;
import java.util.List;

public class ProductService implements IService {

    public static void increasePrice(final List<Product> products, final Long percentage) {

        final var decimalPercentage = new BigDecimal(percentage).divide(new BigDecimal(100));

        products.forEach(product -> product.changePrice((product.getPrice().multiply(decimalPercentage)).add(product.getPrice())));

    }
}
