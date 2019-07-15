package com.kumuluz.ee.samples.openapi.v2;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kumuluz.ee.samples.openapi.Customer;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

/**
 * CustomerResource class with openAPI
 *
 * @author Zvone Gazvoda
 * @since 2.5.0
 */
@Path("customer")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {

	@GET
	@Operation(summary = "Get customers list", tags = {
			"customers" }, description = "Returns a list of customers.", responses = {
					@ApiResponse(description = "List of customers", responseCode = "200", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Customer.class)))) })
	public Response getCustomers() {

		List<Customer> customers = new ArrayList<>();
		Customer c = new Customer("1", "John", "Doe");

		customers.add(c);
		customers.add(new Customer("2", "Suneesh", "Joshi"));
		customers.add(new Customer("3", "Charitha", "Joshi"));
		customers.add(new Customer("4", "Muneesh", "Joshi"));

		return Response.status(Response.Status.OK).entity(customers).build();
	}

	@GET
	@Operation(summary = "Get customers details", tags = {
			"customers" }, description = "Returns customer details.", responses = {
					@ApiResponse(description = "Customer details", responseCode = "200", content = @Content(schema = @Schema(implementation = Customer.class))) })
	@Path("{customerId}")
	public Response getCustomer(@PathParam("customerId") String customerId) {

		Customer c = new Customer("1", "John", "Doe");

		return Response.status(Response.Status.OK).entity(c).build();
	}

}
