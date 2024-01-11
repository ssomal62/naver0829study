package com.codepresso.codepressoblog.service;

import com.codepresso.codepressoblog.mapper.PostMapper;
import com.codepresso.codepressoblog.vo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostMapper  postMapper;

    public PostService(PostMapper postMapper){
        this.postMapper = postMapper;
    }

    public List<Post> getAllPost(){
        return postMapper.findAll();
    }

    public List<Post> getPostByPage(Integer page, Integer size){
        return postMapper.findByPage(size, (page - 1) * size);
    }

    public Post getPostById(Integer id){
        return postMapper.findOne(id);
    }

    public boolean savePost(Post post){
        Integer result = postMapper.savePost(post);
        return result == 1; // 1 이면 성공, 0 이면 실패, 오류 핸들링은 추후
    }

    @Transactional
    public boolean updatePost(Post post){
        Integer result = postMapper.update(post);

        int test = 199/0;
        System.out.println(test);

        return result == 1;
    }

}
