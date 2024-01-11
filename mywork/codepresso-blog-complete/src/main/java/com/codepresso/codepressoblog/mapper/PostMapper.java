package com.codepresso.codepressoblog.mapper;


import com.codepresso.codepressoblog.vo.Post;

import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.util.List;

@CreditCardNumber
public interface PostMapper {
    List<Post> findAll();
    List<Post> findByPage(@Param("limit") Integer limit, @Param("offset") Integer offset);
    Post findOne(@Param("id") Integer id);
    Integer savePost(@Param("post") Post post);
    Integer update(@Param("post") Post post);

}
