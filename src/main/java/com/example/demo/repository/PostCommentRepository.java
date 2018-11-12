package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.PostComment;

public interface PostCommentRepository extends JpaRepository<PostComment, Long> {

}
