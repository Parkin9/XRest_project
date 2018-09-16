package pl.parkin9.xrest_project;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import pl.parkin9.xrest_project.Controller.IndexController;
import pl.parkin9.xrest_project.Model.CurrencyJson;
import pl.parkin9.xrest_project.Model.NumbersJson;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class XRestProjectApplicationTests {

    @Autowired
    private IndexController indexController;
    @Autowired
    private TestRestTemplate testRestTemplate;
    @LocalServerPort
    private int port;

/////////////////////////////////////////////////////////////////////////

    @Test
    public void contextLoads() {

        assertNotNull(indexController);
    }

    @Test
    public void pingpongTest_ShouldReturnPongWithHttpStatusOK() {

        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("http://localhost:" + port + "/status/ping", String.class);

        assertThat(responseEntity.getBody(), equalTo("pong"));
        assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void sortingNumbersTest_ShouldReturnAscendingSortedNumbersWithHttpStatusOK() {


    }
}
