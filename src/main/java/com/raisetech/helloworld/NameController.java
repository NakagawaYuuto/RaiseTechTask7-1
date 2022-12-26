package com.raisetech.helloworld;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
public class NameController {

    @GetMapping("/names")
    public List<String> getName(){
        return List.of("nakagawa", "nakazima");
    }

    @PostMapping("/names")
    public ResponseEntity<String> createName(@RequestBody CreateForm form){
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/names/id")
                .build()
                .toUri();
        return ResponseEntity.created(url).body("name successfully created");
    }

    @PatchMapping("/names/{id}")
    public ResponseEntity<Map<String, String >> updateName(@PathVariable("id")int id, @RequestBody UpdateForm from) {
        return ResponseEntity.ok(Map.of("message", "name successfully updated"));
    }

    @GetMapping("/testquerynames")
    @ResponseBody
    public  String testquerynames(@RequestParam String name, @RequestParam int age ) {
        String profile = "Self-introduction" + "<br>";
        profile = profile.concat("My name is " + name + "<br>");
        profile = profile.concat("I am  " + age + "years old" + "<br>");
        return profile;
    }
}
