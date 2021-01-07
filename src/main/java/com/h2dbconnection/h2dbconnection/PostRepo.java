package com.h2dbconnection.h2dbconnection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<PostBean, Integer> {
}
