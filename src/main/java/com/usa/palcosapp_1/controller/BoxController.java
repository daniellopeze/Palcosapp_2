package com.usa.palcosapp_1.controller;

import com.usa.palcosapp_1.model.Box;
import com.usa.palcosapp_1.service.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Box")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class BoxController {

    @Autowired
    private BoxService boxService;

    @GetMapping("/all")
    public List<Box> getAll(){
        return boxService.getAll();
    }
    @GetMapping("/{idBox}")
    public Optional<Box> getById (@PathVariable("isBox") Integer id){
        return boxService.getById(id);
    }
    @PutMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Box save(@RequestBody Box box){
        return boxService.save(box);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Box update (@RequestBody Box box){
        return boxService.update(box);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete (@PathVariable("id")Integer id){
        return boxService.delete(id);
    }

}



