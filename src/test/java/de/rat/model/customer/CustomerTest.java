package de.rat.model.customer;

import de.rat.model.common.Address;
import de.rat.model.common.Role;
import de.rat.model.logistics.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    //Variable declaration
    private Customer custMaria;
    private Customer custLudwig;

    private Address musterhausen;
    private Station station1;
    private Manufacturer bosch;

    private Tool drill;
    private Tool hammer;
    private Tool welder;

    @BeforeEach
    void setUp() {
        musterhausen = new Address("Musterstrasse", 1, 99099, "Erfurt", "Deutschland");
        bosch = new Manufacturer("Bosch", musterhausen, "Mr Smith", "123456");
        station1 = new Station("S1", 3, musterhausen);

        // Tools
        drill = new Tool("123", bosch, "Bohrer", Category.HANDTOOL, "1-4-5", ToolStatus.AVAILABLE, 3.0);
        hammer = new Tool("12553", bosch, "Hammer", Category.HANDTOOL, "1-4-6", ToolStatus.ISINREPAIR, 2.5);
        welder = new Tool("ewv133", bosch, "Schweißgerät", Category.HANDTOOL, "1-4-7", ToolStatus.ISRENTED, 3.5);

        //Customer
        custMaria = new Customer("Schmidt", "Maria", LocalDate.of(2005, 8, 29), "maria.schmidt@web.de",
        "Weimarerlandstraße", 53, 99986, "Dresden", "Germany", "561616310651");
        custLudwig = new Customer("Ebert", "Ludwig", LocalDate.of(1937, 12, 17), "crazyemail@web.de",
        "Bahnhofsstraße", 16, 99067, "Gotha", "Germany", "01236/465854");

        station1.addToolToBox(welder);
    }

    // Customer Information
    @Test
    void create_correct_password_for_customer_and_employee(){
        assertEquals("ma290805sc", custMaria.getAccount().getPassword());
    }

    @Test
    void set_correct_email_for_the_customer(){
        assertEquals("maria.schmidt@web.de", custMaria.getAccount().getEmail());
    }

    @Test
    void set_correct_role_for_the_customer(){
        assertEquals(Role.CUSTOMER, custMaria.getAccount().getRole());
    }

    // Customer Interactions
    @Test
    void should_put_and_get_tool_in_inventory() {
        custLudwig.putToolInInventory(drill);
        assertEquals(drill,custLudwig.getToolFromInventory(drill));
    }

    @Test
    void after_removing_the_tool_from_the_inventory_the_tool_is_not_even_in_the_inventory(){
        custLudwig.putToolInInventory(drill);
        custLudwig.getToolFromInventory(drill);
        assertNull(custLudwig.getToolFromInventory(drill));
    }

    @Test
    void should_get_null_if_the_tool_is_not_in_the_inventory() {
        custLudwig.putToolInInventory(drill);
        assertNull(custLudwig.getToolFromInventory(hammer));
    }

    @Test
    void should_get_a_tool_from_the_station_in_the_inventory() {
        Boolean checkGetComplete = custLudwig.getToolFromStation(welder,  station1);
        assertEquals(true, checkGetComplete);
    }

    @Test
    void should_put_a_tool_from_the_inventory_in_the_station() {
        custLudwig.putToolInInventory(drill);
        Boolean checkPutComplete = custLudwig.returnToolToStation(drill, station1);
        assertEquals(true, checkPutComplete);
    }

}