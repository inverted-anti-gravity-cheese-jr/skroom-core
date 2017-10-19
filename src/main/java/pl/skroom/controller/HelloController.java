package pl.skroom.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.skroom.model.Book;

@RequestMapping("/api")
@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public Book get() {
        return new Book() {{
            setId(1);
            setAuthor("HP Lovecraft");
            setName("Ktulhu");
        }};
    }

}