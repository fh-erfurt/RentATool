package core;

import de.rat.model.logistics.Tool;
import de.rat.storage.core.AccessingDataJpaApplication;
import de.rat.storage.core.ToolRepository;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

@SpringBootTest(classes= AccessingDataJpaApplication.class)
public class ToolRepositoryTest {
    ToolRepository rep;
    private static final Logger log= LoggerFactory.getLogger(ToolRepositoryTest.class);
    @Autowired
    ToolRepository repository;

    @Test
    void contextLoads()
    {
        repository.save(new Tool());
    }


}
