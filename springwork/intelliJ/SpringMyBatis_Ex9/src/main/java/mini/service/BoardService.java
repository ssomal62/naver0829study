package mini.service;

import lombok.AllArgsConstructor;
import mini.dao.BoardDao;
import mini.dto.BoardDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class BoardService {

    private BoardDao boardDao;


    public int getTotalCount() {
        return boardDao.getTotalCount();
    }

    public List<BoardDto> getList(int start, int perpage){
        Map<String, Integer> map = new HashMap<>();

        map.put("start", start);
        map.put("perpage", perpage);

        return boardDao.getList(map);
    }

    public int getMaxNum(){
        return boardDao.getMaxNum();
    }

    public void updateRestep(int regroup, int restep){

        Map<String, Integer> map = new HashMap<>();

        map.put("regroup", regroup);
        map.put("restep", restep);

        boardDao.updateRestep(map);
    }

    public void insertBoard(BoardDto dto){

        int num = dto.getNum(); //새글일 경우 0, 답글일 경우 0보다 큰값이 들어있다.
        int regroup = dto.getRegroup(); //답글을 단 글의 regroup
        int restep = dto.getRestep(); //답글을 단 글의 restep
        int relevel = dto.getRelevel(); //답글을 단 글의 relevel

        if(num == 0){
            //새글인 경우
            regroup = boardDao.getMaxNum() + 1;

            //새글인 경우 restep, relevel은 기본적으로 0값이 넘어오지만 확실하게 값지정해주기.
            restep = 0;
            relevel = 0;

        } else {
            //답글인 경우

            //1. 그룹은 그대로 사용하므로 regroup의 값을 수정하지 않는다.

            //2. 그룹 중 전달받은 restep 값보다 큰 값들을 1씩 증가시킨다.
            this.updateRestep(regroup, restep);

            //3. 그 후 각각의 값에 1을 더한다.
            restep += 1;
            relevel += 1;
        }

        //4. 새로 구한값들을 다시 dto에 저장한다.

        dto.setRegroup(regroup);
        dto.setRestep(restep);
        dto.setRelevel(relevel);

        //5. db에 INSERT
        boardDao.insertBoard(dto);
    }

    public void updateReadCount(int num){
        boardDao.updateReadCount(num);
    }

    public BoardDto getData(int num){
        return boardDao.getData(num);
    }

    public void updateBoard(BoardDto dto){
        boardDao.updateBoard(dto);
    }

    public void deleteBoard(int num){
        boardDao.deleteBoard(num);
    }



}
