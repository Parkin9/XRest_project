package pl.parkin9.xrest_project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.parkin9.xrest_project.Controller.IndexController;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XRestProjectApplicationTests {

    @Autowired
    private IndexController indexController;

    @Test
    public void contextLoads() {
        assertNotNull(indexController);
    }

}
