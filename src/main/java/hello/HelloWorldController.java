package hello;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloWorldController {

    private static final String template = "Hello, %s!";
    private AtomicLong counter = new AtomicLong();

    /*

    @ResponseBody tells Spring MVC not to render a model into a view, but rather write the returned object into the
    response body. It does this by using one of Spring’s message converters. Because Jackson 2 is in the classpath,
    this means that MappingJackson2HttpMessageConverter will handle the conversion of Greeting to JSON if the request’s
    Accept header specifies that JSON should be returned.
     */
    @GetMapping("/hello-world")
    @ResponseBody
    public Greeting sayHello(@RequestParam(name = "name", required = false, defaultValue = "Stranger") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
