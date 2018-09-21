package pl.parkin9.xrest_project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.parkin9.xrest_project.Controller.IndexController;
import pl.parkin9.xrest_project.Exception.SortingOrderException;
import pl.parkin9.xrest_project.Model.NumbersJson;
import pl.parkin9.xrest_project.Model.OrderEnum;
import pl.parkin9.xrest_project.Service.SortingService;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class XRestProjectApplicationTests {

    @Autowired
    private IndexController indexController;

    @Autowired
    private SortingService sortingService;

    @Autowired
    private MockMvc mockMvc;

/////////////////////////////////////////////////////////////////////////

    @Test
    public void contextLoads() {

        assertThat(indexController).isNotNull();
    }

    @Test
    public void pingpongTest() throws Exception {

        this.mockMvc.perform(get("/status/ping"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("pong"));
    }

    @Test
    public void sortingNumbersTest() throws Exception {

        String requestJson = "{" +
                                "\"numbers\": [12, 31, 3, 72, 5], " +
                                "\"order\": \"ASC\"" +
                                "}";

        String responseJson = "{" +
                                "\"numbers\": [3, 5, 12, 31, 72]" +
                                "}";

        this.mockMvc.perform(post("/numbers/sort-command")
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .content(requestJson))
                    .andExpect(status().isOk())
                    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                    .andExpect(content().json(responseJson));
    }

    @Test
    public void getCurrencyValueTest() throws Exception {

        String json = "{" +
                        "\"currency\": \"EUR\"" +
                        "}";

        this.mockMvc.perform(post("/currencies/get-current-currency-value-command")
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .content(json))
                    .andExpect(status().isOk())
                    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void sortingServiceTest() {

        NumbersJson numbersJson = new NumbersJson();
        numbersJson.setNumbers(Arrays.asList(4,2,6,1,5,3));

        numbersJson.setOrder("DESC");
        sortingService.sort(numbersJson);
        assertThat(numbersJson.getNumbers()).isEqualTo(Arrays.asList(6,5,4,3,2,1));

        numbersJson.setOrder("ASC");
        sortingService.sort(numbersJson);
        assertThat(numbersJson.getNumbers()).isEqualTo(Arrays.asList(1,2,3,4,5,6));
    }
}
