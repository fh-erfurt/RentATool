/*
 * TODO:
 *   We try to generate IntegrationTests, but we cant solve the problem, that we doesnt get access to pages with an authorization.
 *   This doesnt work with RestAssured and also not with Mockito.
 *   The access to the response Body works fine with TestRestTemplate.
 *   We dont get JSON on our pages, we just get HTML. The most examples about this problem works with JSON, but we couldn't find a solution to provide JSON.
 */

package de.rat.api;

import static io.restassured.RestAssured.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;

import de.rat.RentAToolApplication;
import de.rat.model.common.Account;
import de.rat.model.common.Address;
import de.rat.model.common.Role;
import de.rat.model.customer.Customer;
import de.rat.model.logistics.Category;
import de.rat.model.logistics.Manufacturer;
import de.rat.model.logistics.Tool;
import de.rat.model.logistics.ToolStatus;
import de.rat.repositories.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = RentAToolApplication.class)
public class IntegrationTest {

    @Autowired
    TestRestTemplate restTemplate;

    URL base;

    @LocalServerPort
    int port;

    private Customer custHans2;

    @Autowired
    CustomerRepository repository;

    @Before
    public void setUp() throws MalformedURLException {

//        custHans2 =  new Customer("Mwller", "Hans", LocalDate.of(2005, 8, 29),"hans@web.de","Kastanienallee","1A","01144", "Berlin","DE","0176767676");
//        repository.save(custHans2);

        restTemplate = new TestRestTemplate("hans@web.de", "ha290805mw");
        base = new URL("http://localhost:" + port);
    }


    @Test
    public void getToolsFromToolsPage() throws URISyntaxException {
        URI uri = new URI(base.toString() + "/tools");

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");

        HttpEntity<Customer> request = new HttpEntity<>(custHans2, headers);

        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

        System.out.println(uri);
        System.out.println(result.getHeaders().getLocation());
        System.out.println(result.getBody());
        //Verify request succeed
//        Assert.assertEquals(201, result.getStatusCodeValue());
    }


    // TODO: try to reach a page with user-permission with an logged user
    //  UserLogin failed

    @Test
    public void whenLogged_UserRequestsToolManagement_ThenSuccess() throws IllegalStateException, IOException {
        ResponseEntity<String> response = restTemplate.getForEntity(base.toString() + "/toolManagement", String.class);

        System.out.println(response
                .getBody());

        System.out.println(base.toString() + "/toolManagement");

//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertTrue(Objects.requireNonNull(response
//                .getBody())
//                .contains("Baeldung"));

    }


    @Test
    public void givenRestTemplate_whenRequested_thenLogAndModifyResponse() {
        Account account = new Account(Role.CUSTOMER, "customer1@test.de", "123");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Account> requestEntity = new HttpEntity<Account>(account, headers);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(base.toString() + "/toolManagement", requestEntity, String.class);

//        assertThat(responseEntity.getStatusCode(), is(equalTo(HttpStatus.OK)));
        System.out.println(responseEntity.getBody());
//        assertThat(responseEntity.getHeaders()
//                .get("Foo")
//                .get(0), is(equalTo("bar")));
    }

    @Test
    public void whenUserWithWrongCredentials_thenUnauthorizedPage() throws IllegalStateException, IOException {
        restTemplate = new TestRestTemplate("user", "wrongpassword");
        ResponseEntity<String> response = restTemplate.getForEntity(base.toString(), String.class);

//        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
//        assertNull(response.getBody());
    }

    @Test
    public void isTheCustomerSavedAndRetrieved() {

        Customer custHans2 = new Customer("Mwller", "Hans", LocalDate.of(2005, 8, 29), "luis.meyer@web.de",
                "Kastanienallee", "1A", "01144", "Berlin", "DE", "0176767676");

        Address address2 = new Address("Weg", "1", "12345", "Erfurt", "Deutschland");
        Manufacturer manufacture = new Manufacturer("Bosch", address2, "Herr Bosch", "05642-458759");
        Tool tool1 = new Tool("1", manufacture, "Bohrer", Category.HANDTOOL, "1A", ToolStatus.AVAILABLE, new BigDecimal("5.00"));
        Tool tool2 = new Tool("2", manufacture, "Axt", Category.HANDTOOL, "1B", ToolStatus.AVAILABLE, new BigDecimal("6.00"));

        Tool isThisTheCustomer = when()
                .get("/")
                .then()
                .statusCode(org.apache.http.HttpStatus.SC_CREATED)
                .extract()
                .body().as(Tool.class);

//        assertEquals("Hammer", isThisTheCustomer.getDescription());

    }


}