package br.com.ddd.application.customer.usecase;

import br.com.ddd.BaseTeste;
import br.com.ddd.application.customer.usecase.factory.UpdateCustomerFactory;
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
public class UpdateCustomerUsecaseTest extends BaseTeste {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private UpdateCustomerUsecase usecase;


    @BeforeEach
    void setUp() {
        this.usecase = new UpdateCustomerUsecase(customerService, new UpdateCustomerFactory());
    }

    @Test
    @DisplayName("should create a customer")
    void shouldFindACustomer() {

        final var input = this.buildUpdateCustomerInput();

        when(this.customerService.notifyUpdate(anyString(), anyString(), anyString(), anyString(), anyString(), anyString()))
                .thenReturn(this.buildValidCustomer());

        final var response = this.usecase.execute(input);

        assertNotNull(response.id());
        assertEquals(input.name(), response.name());
        assertEquals(input.address().street(), response.address().street());
        assertEquals(input.address().city(), response.address().city());
        assertEquals(input.address().state(), response.address().state());
        assertEquals(input.address().zipCode(), response.address().zipCode());

    }


}
