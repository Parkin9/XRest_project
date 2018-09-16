package pl.parkin9.xrest_project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import pl.parkin9.xrest_project.Controller.IndexController;

import org.skyscreamer.jsonassert.JSONAssert;
import pl.parkin9.xrest_project.Model.NumbersJson;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = XRestProjectApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class XRestProjectApplicationTests {

    @Autowired
    private IndexController indexController;
    private TestRestTemplate testRestTemplate = new TestRestTemplate();
    private HttpHeaders httpHeaders = new HttpHeaders();
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

        NumbersJson numbersJson = new NumbersJson();
        numbersJson.setNumbers(Arrays.asList(12, 31, 3, 72, 5));
        numbersJson.setOrder("ASC");

        HttpEntity<NumbersJson> httpEntity = new HttpEntity<>(numbersJson, httpHeaders);
        ResponseEntity<NumbersJson> responseEntity = testRestTemplate.postForEntity("http://localhost:" + port + "/numbers/sort-command", NumbersJson.class);

    }
}
