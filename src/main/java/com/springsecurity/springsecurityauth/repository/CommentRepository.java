package com.springsecurity.springsecurityauth.repository;

import com.springsecurity.springsecurityauth.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>{
    // Your code goes here
    public List<Comment> findAll();
    public Optional<Comment> findById(long id);
    public void deleteById(long id);

}
