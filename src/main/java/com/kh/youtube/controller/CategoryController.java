package com.kh.youtube.controller;

import com.kh.youtube.domain.Category;
import com.kh.youtube.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/*")
public class CategoryController
{
    @Autowired
    private CategoryService service;

    @GetMapping("/category")
    public ResponseEntity<List<Category>> showAll()
    {
        try
        {
            return ResponseEntity.status(HttpStatus.OK).body(service.showAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//          위 코드와 같음 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/category/{code}")
    public ResponseEntity<Category> show(@PathVariable int code)
    {
        try
        {
            return ResponseEntity.status(HttpStatus.OK).body(service.show(code));
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/category")
    public ResponseEntity<Category> create(@RequestBody Category category)
    {
        try
        {
            return ResponseEntity.status(HttpStatus.OK).body(service.create(category));
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/category")
    public ResponseEntity<Category> update(@RequestBody Category category)
    {
        try
        {
            return ResponseEntity.status(HttpStatus.OK).body(service.update(category));
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/category/{code}")
    public ResponseEntity<Category> update(@PathVariable Integer code)
    {
        try
        {
            return ResponseEntity.status(HttpStatus.OK).body(service.delete(code));
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
