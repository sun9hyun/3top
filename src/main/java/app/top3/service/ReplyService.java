package app.top3.service;

import app.top3.domain.vo.ReplyVO;
import app.top3.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyMapper replyMapper;
//    댓글 등록
    public void register(ReplyVO replyVO){
        replyMapper.insertReply(replyVO);
    }
//    댓글 조회
    public List<ReplyVO> showAll(Long boardNumber) {
        return replyMapper.replyList(boardNumber);
    }
}
