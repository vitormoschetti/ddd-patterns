package br.com.ddd.application.customer.usecase;


import br.com.ddd.BaseTeste;
import br.com.ddd.application.customer.usecase.factory.ListCustomerFactoryToOutput;
import br.com.ddd.domain.customer.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ListCustomerUsecaseTest extends BaseTeste {

    @Mock
    private CustomerService service;

    @InjectMocks
    private ListCustomerUsecase usecase;

    @BeforeEach
    void setUp() {
        this.usecase = new ListCustomerUsecase(this.service, new ListCustomerFactoryToOutput());
    }

    @Test
    @DisplayName("should find a customer")
    void shouldFindACustomer() {

        final var expect = this.buildValidListCustomer();

        when(this.service.findAll()).thenReturn(expect);

        final var response = this.usecase.execute();

        assertNotNull(response);
        assertEquals(expect.size(), response.size());

    }


}
