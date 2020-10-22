package com.hackerrank.github.controller;

import com.hackerrank.github.model.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping(value = "/erase")
public class ResourcesController {

   static List<Event> events = new ArrayList<>();

    @DeleteMapping(
            value = "/erase"
    )
    public ResponseEntity<Object> createEvent() {
        events.clear();
        return ResponseEntity.status(200).body(null);
    }

}
