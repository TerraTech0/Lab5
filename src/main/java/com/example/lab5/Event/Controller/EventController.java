package com.example.lab5.Event.Controller;

import com.example.lab5.Event.Model.Event;
import com.example.lab5.Projects.Api.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/event")
public class EventController {
    ArrayList<Event> events = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Event> showEvents(){
        return events;
    }


    @PostMapping("/add")
    public ApiResponse addEvent(@RequestBody Event event){
        events.add(event);
        return new ApiResponse("Event added successfully!");
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateEvent(@PathVariable int index, @RequestBody Event event){
        events.set(index, event);
        return new ApiResponse("event updated successfully!");


    }

    //change only the capacity
    @PutMapping("/change-capacity/{index}/{capacity}")
    public ApiResponse changeCapacity(@PathVariable int index, @PathVariable int capacity){
        Event event = events.get(index);
        event.setCapacity(capacity);
        events.set(index, event);
        return new ApiResponse("Capacity Changed!");
    }



    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteEvent(@PathVariable int index){
        events.remove(index);
        return new ApiResponse("event deleted successfully!");
    }


    //search for event by giving id:
    @GetMapping("/search/{ID}")
    public ArrayList<Event> search(@PathVariable String ID){
        ArrayList<Event> event = new ArrayList<>();
        for (Event ev : events){
            if (ev.getID().equalsIgnoreCase(ID)){
                event.add(ev);
            }
        }
        return event;
    }
}
