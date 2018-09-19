package pl.parkin9.xrest_project.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.parkin9.xrest_project.Exception.NBPApiJsonException;
import pl.parkin9.xrest_project.Model.NBPApiJson;

@Component
public class NBPApiClientImpl implements NBPApiClient {

    private final RestTemplate restTemplate;

    @Autowired
    public NBPApiClientImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

//////////////////////////////////////////////////////////////////////////////

    public NBPApiJson getNBPApiJson() {

        final String urlApi = "http://api.nbp.pl/api/exchangerates/tables/A?format=json";

        ResponseEntity<NBPApiJson[]> responseEntity = restTemplate.getForEntity(urlApi, NBPApiJson[].class);
        NBPApiJson[] nbpApiJsonArray = responseEntity.getBody();

        if (nbpApiJsonArray != null) {
            return nbpApiJsonArray[0];

        } else {
            throw new NBPApiJsonException("Content not found.");
        }
    }
}
