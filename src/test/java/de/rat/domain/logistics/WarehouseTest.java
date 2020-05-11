package de.rat.domain.logistics;

import de.rat.domain.common.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {

    private Warehouse warehouse;
    private Tool hammer;
    private Manufacturer bosch;
    private Address address;

    @BeforeEach
    void setUp(){
        warehouse= new Warehouse();
        hammer = new Tool("123",bosch,"Hammer",Category.HANDTOOL,"Lager",ToolStatus.AVAILABLE,3.5);
        address = new Address("Bosch-Strasse", 1, 99425, "Weimar", "DE");
        bosch =  new Manufacturer("Bosch",address,"Mr. Smith","01234");
    }

    @Test
    void is_tool_in_warehouse_after_call_put_tool_in_warehouse() {
        int sizeBefore = warehouse.getStock().size();
        warehouse.putToolInWarehouse(hammer);
        assertEquals(sizeBefore+1,warehouse.getStock().size());
    }

    @Test
    void is_tool_not_longer_in_warehouse_after_call_remove_tool_from_warehouse() {
        warehouse.putToolInWarehouse(hammer);
        int sizeBefore = warehouse.getStock().size();
        warehouse.removeToolFromWarehouse(hammer);
        assertEquals(sizeBefore-1,warehouse.getStock().size());
    }

    @Test
    void is_not_available_tool_already_in_warehouse_after_call_remove_tool_from_warehouse() {
        hammer.setToolStatus(ToolStatus.ISBROKEN);
        warehouse.putToolInWarehouse(hammer);
        int sizeBefore = warehouse.getStock().size();
        warehouse.removeToolFromWarehouse(hammer);
        assertEquals(sizeBefore,warehouse.getStock().size());
    }

}