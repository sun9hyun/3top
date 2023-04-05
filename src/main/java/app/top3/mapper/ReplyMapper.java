package app.top3.mapper;

import app.top3.domain.vo.ReplyVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyMapper {
//    댓글 등록
    void insertReply(ReplyVO replyVO);
//    댓글 조회
    List<ReplyVO> replyList(Long boardNumber);

}
