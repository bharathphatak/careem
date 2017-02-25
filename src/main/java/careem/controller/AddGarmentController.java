package careem.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by bhara on 07-03-2016.
 */
@RestController
@EnableAutoConfiguration
public class AddGarmentController {



    private final List<String> supportedHosts = Arrays.asList("flipkart","snapdeal","amazon");

    @RequestMapping(value = "/api/add/get/url/{test}/test", method = RequestMethod.GET)
    @ResponseBody
    public String teast(@PathVariable String test){
        return "Hello";
    }

    @RequestMapping(value = "/api/add/get/url", method = RequestMethod.POST)
    @ResponseBody
    public String teat(@RequestBody String value){
        return "Hello";
    }



}
