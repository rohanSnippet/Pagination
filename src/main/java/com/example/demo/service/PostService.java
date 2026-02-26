package com.example.demo.service;

import com.example.demo.models.Post;
import com.example.demo.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepo postRepo;

    public List<Post> getAllPosts(){
        return postRepo.findAll();
    }

    public List<Post> createBulkPosts(List<Post> posts){
       return postRepo.saveAll(posts);
    }

    public Page<Post> getAllPosts(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return postRepo.findAll(pageable);
    }
}
