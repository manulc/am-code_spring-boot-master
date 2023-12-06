package com.mlorenzo.demo.jsonplaceholder;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "jsonplaceholder", url = "https://jsonplaceholder.typicode.com/posts")
public interface JSONPlaceHolderClient {

    @GetMapping
    List<Post> getPosts();

    @GetMapping("{postId}")
    Post getPost(@PathVariable Integer postId);
}
