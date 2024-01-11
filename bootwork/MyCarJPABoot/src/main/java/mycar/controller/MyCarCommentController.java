package mycar.controller;

import lombok.RequiredArgsConstructor;
import mycar.data.MyCarCommentDto;
import mycar.data.MyCarDto;
import mycar.repository.MyCarCommentDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MyCarCommentController {

    private final MyCarCommentDao myCarCommentDao;

    @GetMapping("/addcomment")
    public void addComment(@RequestParam Long num,
                           @RequestParam String comment) {

        MyCarDto mycarNum = MyCarDto.builder().num(num).build();

        MyCarCommentDto commentDto = MyCarCommentDto.builder()
                                            .comment(comment)
                                            .macar(mycarNum)
                                            .build();

        myCarCommentDao.insertComment(commentDto);
    }

    @GetMapping("/comment-list")
    public List<MyCarCommentDto> getCommentList(@RequestParam Long num) {
        return myCarCommentDao.getMyCarCommentList(num);
    }

}
