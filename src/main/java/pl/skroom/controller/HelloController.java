package pl.skroom.controller;

import java.util.List;
import java.util.Arrays;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.skroom.model.Book;

@RequestMapping("/api")
@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public List<Book> get() {
        return Arrays.asList(
            new Book() {{
                setId(1);
                setAuthor("HP Lovecraft");
                setName("Ktulhu");
            }},
            new Book() {{
                setId(1);
                setAuthor("JRR Tolkien");
                setName("LOTR");
            }},
            new Book() {{
                setId(1);
                setAuthor("Stephen King");
                setName("Cell");
            }}
        );
    }

}