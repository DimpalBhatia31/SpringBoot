package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.PostCommentDto;
import com.example.demo.model.PostComment;
import com.example.demo.service.PostCommentService;

@RestController
public class PostCommentController {
	@Autowired
	PostCommentService postC;
	@PostMapping("post/{id}/postComment")
	public void createPostComent(@PathVariable Long id,@RequestBody PostCommentDto postDto)
	{
		postC.postComment(id,postDto);
	}
	@DeleteMapping("/postComment/{id}")
	public void deleteComm(@PathVariable Long id)
	{
		postC.deleteComment(id);
	}
	@GetMapping("/postComment/{id}")
	public Optional<PostComment> getParticular(@PathVariable Long id)
	{
		return postC.getParticularComment(id);
	}
	@GetMapping("/postComment")
	public List<PostComment> getAllComments()
	{
		return postC.getAllComments();
	}
}
