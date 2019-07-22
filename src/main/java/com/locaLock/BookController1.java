package com.locaLock;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.locaLock.LocalLock1;

/**
 * BookController
 *
 * @author 
 * @since 
 */
@RestController
@RequestMapping("/book")
public class BookController1 {

    @LocalLock1(key = "book:arg[0]")
    @GetMapping
    public String query(@RequestParam String token) {
        return "success - " + token;
    }
}
