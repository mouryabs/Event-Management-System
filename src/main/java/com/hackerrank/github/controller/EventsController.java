package com.hackerrank.github.controller;

import com.hackerrank.github.model.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping(value = "/events")
public class EventsController {

    @PostMapping(
            value = "/events",
            consumes = "application/json"
    )
    public ResponseEntity<Object> createEvent(@RequestBody Event event) {
        for(Event e : ResourcesController.events){
            if(e.getId() == event.getId()){
                return ResponseEntity.status(400).body(null);
            }
        }
        ResourcesController.events.add(event);
        return ResponseEntity.status(201).body(null);
    }

    @GetMapping(
            value = "/events/{id}",
            produces = "application/json"
    )
    ResponseEntity<Object> getEventById(@PathVariable("id") Long id) {
        for(Event e : ResourcesController.events){
            if(e.getId() == id){
                return ResponseEntity.status(200).body(e);
            }
        }
        return ResponseEntity.status(404).body(null);
    }

    @GetMapping(
            value = "/events/repos/{repoID}",
            produces = "application/json"
    )
    ResponseEntity<Object> getEventsbyRepoId(@PathVariable("repoID") Long id) {
        List<Event> returnList = new ArrayList<>();
        for(Event e : ResourcesController.events){
            if(e.getRepo().getId() == id){
                returnList.add(e);
            }
        }

        if(returnList.isEmpty()){
            return ResponseEntity.status(404).body(null);
        }
        else{
            return ResponseEntity.status(200).body(returnList.toArray());
        }
    }

    @GetMapping(
            value = "/events/actors/{actorID}",
            produces = "application/json"
    )
    ResponseEntity<Object> getEventsbyActorId(@PathVariable("actorID") Long id) {
        List<Event> returnList = new ArrayList<>();
        for(Event e : ResourcesController.events){
            if(e.getActor().getId() == id){
                returnList.add(e);
            }
        }

        if(returnList.isEmpty()){
            return ResponseEntity.status(404).body(null);
        }
        else{
            return ResponseEntity.status(200).body(returnList.toArray());
        }
    }



    @GetMapping(
            value = "/events/repos/{repoID}/actors/{actorID}",
            produces = "application/json"
    )
    ResponseEntity<Object> getEventsbyActorAndRepoId(@PathVariable("actorID") Long actorID,@PathVariable("repoID") Long repoID) {
        List<Event> returnList = new ArrayList<>();
        for(Event e : ResourcesController.events){
            if((e.getActor().getId() == actorID) && (e.getRepo().getId() == repoID)){
                returnList.add(e);
            }
        }

        if(returnList.isEmpty()){
            return ResponseEntity.status(404).body(null);
        }
        else{
            return ResponseEntity.status(200).body(returnList.toArray());
        }
    }




}
