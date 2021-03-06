package io.konik.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.konik.InvoiceTransformer;
import io.konik.zugferd.Invoice;
import org.junit.Test;

import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InvoicesTest {

	@Test
	public void shouldCreateDeepCloneOfTheInvoice() throws JsonProcessingException {
		//given:
		InputStream xml = getClass().getResourceAsStream("/ZUGFeRD_Invoice_with_discounts_and_charges.xml");
		InvoiceTransformer transformer = new InvoiceTransformer();
		Invoice invoice = transformer.toModel(xml);

		//when:
		Invoice clone = Invoices.clone(invoice);

		//then:
		assertThat(transformer.fromModel(invoice))
				.isEqualTo(transformer.fromModel(clone));
	}
}