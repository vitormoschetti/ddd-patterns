package br.com.ddd.domain.product.service;

import br.com.ddd.domain.shared.service.IService;
import br.com.ddd.domain.product.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public class ProductService implements IService {

    public static void increasePrice(final List<Product> products, final Long percentage) {

        final var decimalPercentage = new BigDecimal(percentage).divide(new BigDecimal(100));

        products.forEach(product -> product.changePrice((product.getPrice().multiply(decimalPercentage)).add(product.getPrice())));

    }
}
