package com.springsecurity.springsecurityauth.service;

import com.springsecurity.springsecurityauth.model.Comment;
import com.springsecurity.springsecurityauth.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    // Your code goes here
    @Autowired
    CommentRepository commentRepository;
    public List<Comment> getComments() {
        return commentRepository.findAll();
    }
    public Optional<Comment> getCommentById(long id) {
        return commentRepository.findById(id);
    }
    public Comment saveComment(Comment newComment) {
        return commentRepository.save(newComment);
    }
    public  void deleteComment(Comment comment) {
        commentRepository.delete(comment);
    }
    public void deleteCommentBy(long id) {
        commentRepository.deleteById(id);
    }




}
