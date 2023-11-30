package board.data;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //@Repository xml설정파일에서 bean으로 생성되는 것과 동일한 효과
public class BoardDao {
    //xml파일에서 SqlSession으로 생성된 세터주입이나, 생성자 주입이 있으면 자동으로 주입을 시켜라.
    //@AllArgsConstructor으로 사용해도 됨
    @Autowired
    private SqlSession session;

    private String nameSpace = "board.data.BoardDao.";

    //전체 갯수 반환하는 메서드
    public int getTotalCount() {
        //복수개로 여러개로 받을 거면 selectList
        //하나로만 받을거면 selectOne
        return session.selectOne(nameSpace + "totalCountOfBoard");  //BoardMapper의 select id값
    }

    public  void insertBoard(BoardDto dto) {
        //nameSpace는 설정파일에서 설정한 namespace이름
        session.insert(nameSpace + "insertBoard", dto); //BoardMapper의 insert id값

    }


    public List<BoardDto> getAllDatas(){
        return session.selectList(nameSpace + "selectAllBoard");
    }

    public void updateReadCount(int num){
        session.update(nameSpace + "updateReadCount", num);
    }
    
    public BoardDto getData(int num){
        return  session.selectOne(nameSpace + "selectOneData",num);
    }

    public void deleteData(int num){
        session.delete(nameSpace + "deleteBoard",num);
    }

    public void updateData(BoardDto dto){
        session.update(nameSpace + "updateBoard",dto);
    }
}
