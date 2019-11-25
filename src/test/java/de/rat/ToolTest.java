package de.rat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToolTest {


    @Test
    void increased_the_id_when_object_are_created() {

        Tool Werkzeug1 = new Tool(1, 2, "Test", "Electro", "A1",
                "good", 12.5);
        Tool Werkzeug2 = new Tool(1, 2, "Test", "Electro", "A1",
                "good", 12.5);

        Assertions.assertEquals(1, Werkzeug1.getToolId());
        Assertions.assertEquals(2, Werkzeug2.getToolId());

    }
}