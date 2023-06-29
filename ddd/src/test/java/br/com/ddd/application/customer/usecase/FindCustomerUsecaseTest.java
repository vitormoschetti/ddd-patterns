package br.com.ddd.application.customer.usecase;


import br.com.ddd.BaseTeste;
import br.com.ddd.application.customer.input.FindCustomerInput;
import br.com.ddd.application.customer.usecase.factory.FindCustomerFactoryToOutput;
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
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindCustomerUsecaseTest extends BaseTeste {

    @Mock
    private CustomerService service;

    @InjectMocks
    private FindCustomerUsecase usecase;

    @BeforeEach
    void setUp() {
        this.usecase = new FindCustomerUsecase(this.service, new FindCustomerFactoryToOutput());
    }

    @Test
    @DisplayName("should find a customer")
    void shouldFindACustomer() {

        final var expect = this.buildValidCustomer();

        when(this.service.findById(anyString())).thenReturn(expect);

        final var response = this.usecase.execute(new FindCustomerInput(expect.getId()));

        assertNotNull(response);
        assertEquals(expect.getId(), response.id());
        assertEquals(expect.getName(), response.name());
        assertEquals(expect.getAddress().street(), response.address().street());
        assertEquals(expect.getAddress().city(), response.address().city());
        assertEquals(expect.getAddress().state(), response.address().state());
        assertEquals(expect.getAddress().zipCode(), response.address().zipCode());

    }


}
