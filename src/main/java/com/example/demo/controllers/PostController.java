package com.example.demo.controllers;

import com.example.demo.models.Post;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/get-all")
    public ResponseEntity<List<Post>> getAllPost(){
         return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<Page<Post>> getAllPosts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        return new ResponseEntity<>(postService.getAllPosts(page, size), HttpStatus.OK);
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<Post>> createBulkPosts(@RequestBody List<Post> posts){

        if(posts == null || posts.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        List<Post> savedPosts = postService.createBulkPosts(posts);

        return new ResponseEntity<>(savedPosts, HttpStatus.CREATED);
    }
}
