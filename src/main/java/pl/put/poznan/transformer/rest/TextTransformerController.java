package pl.put.poznan.transformer.rest;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.TextTransformer;
import pl.put.poznan.transformer.models.Building;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.put.poznan.transformer.models.Building;
import java.io.File;
import java.util.Arrays;


@RestController
@RequestMapping("/{text}")
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String get(@PathVariable String text,
                              @RequestParam(value="transforms", defaultValue="upper,escape") String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        // perform the transformation, you should run your logic here, below is just a silly example
        TextTransformer transformer = new TextTransformer(transforms);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            //Building Buildings = objectMapper.readValue(new File("target/buildings.json"), Building.class);
            //String buildingsAsString = objectMapper.writeValueAsString(buildings);
            // = buildingsAsString;
            String json = "{\"id\":6,\"name\":\"b1\",\"floors\":[{\"id\":4,\"name\":\"b1\",\"rooms\":[{\"id\":1,\"name\":\"b1\",\"area\":12.0,\"cube\":10.0,\"heating\":1.2,\"light\":10.8,\"lightPerUnit\":1.08,\"heatingPerUnit\":0.1},{\"id\":2,\"name\":\"b1\",\"area\":1.0,\"cube\":2.0,\"heating\":3.0,\"light\":4.0,\"lightPerUnit\":2.0,\"heatingPerUnit\":3.0}],\"light\":14.8,\"cube\":12.0,\"lightPerUnit\":1.2333333,\"area\":13.0,\"heatingPerUnit\":0.3230769,\"heating\":4.2},{\"id\":5,\"name\":\"b1\",\"rooms\":[{\"id\":3,\"name\":\"b1\",\"area\":21.0,\"cube\":30.0,\"heating\":5.0,\"light\":8.0,\"lightPerUnit\":0.26666668,\"heatingPerUnit\":0.23809524}],\"cube\":30.0,\"lightPerUnit\":0.26666668,\"light\":8.0,\"area\":21.0,\"heatingPerUnit\":0.23809524,\"heating\":5.0}],\"light\":22.8,\"cube\":42.0,\"lightPerUnit\":0.5428571,\"area\":34.0,\"heating\":9.2,\"heatingPerUnit\":0.27058822}";
            JsonNode jsonNode = objectMapper.readTree(json);


            return jsonNode.get(text).asText();
        }
        catch (final Exception e){
            e.printStackTrace();
        }
        //return transformer.transform(text);
        return "404";
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String post(@PathVariable String text,
                      @RequestBody String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        // perform the transformation, you should run your logic here, below is just a silly example
        TextTransformer transformer = new TextTransformer(transforms);


        try {
            ObjectMapper objectMapper = new ObjectMapper();
            //Building Buildings = objectMapper.readValue(new File("target/buildings.json"), Building.class);
            //String buildingsAsString = objectMapper.writeValueAsString(buildings);
            // = buildingsAsString;
            String json = "{\"id\":6,\"name\":\"b1\",\"floors\":[{\"id\":4,\"name\":\"b1\",\"rooms\":[{\"id\":1,\"name\":\"b1\",\"area\":12.0,\"cube\":10.0,\"heating\":1.2,\"light\":10.8,\"lightPerUnit\":1.08,\"heatingPerUnit\":0.1},{\"id\":2,\"name\":\"b1\",\"area\":1.0,\"cube\":2.0,\"heating\":3.0,\"light\":4.0,\"lightPerUnit\":2.0,\"heatingPerUnit\":3.0}],\"light\":14.8,\"cube\":12.0,\"lightPerUnit\":1.2333333,\"area\":13.0,\"heatingPerUnit\":0.3230769,\"heating\":4.2},{\"id\":5,\"name\":\"b1\",\"rooms\":[{\"id\":3,\"name\":\"b1\",\"area\":21.0,\"cube\":30.0,\"heating\":5.0,\"light\":8.0,\"lightPerUnit\":0.26666668,\"heatingPerUnit\":0.23809524}],\"cube\":30.0,\"lightPerUnit\":0.26666668,\"light\":8.0,\"area\":21.0,\"heatingPerUnit\":0.23809524,\"heating\":5.0}],\"light\":22.8,\"cube\":42.0,\"lightPerUnit\":0.5428571,\"area\":34.0,\"heating\":9.2,\"heatingPerUnit\":0.27058822}";
            JsonNode jsonNode = objectMapper.readTree(json);

            return jsonNode.get(text).asText();
        }
        catch (final Exception e) {
            e.printStackTrace();
        }

        System.out.println(text);
        //return transformer.transform(text);
        return "404";
    }



}


