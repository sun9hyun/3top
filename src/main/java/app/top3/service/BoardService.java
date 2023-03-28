package app.top3.service;


import app.top3.domain.vo.BoardVO;
import app.top3.domain.vo.ListDTO;
import app.top3.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {
    private final BoardMapper boardMapper;
//    게시글 전체
    public int total(ListDTO listDTO){
        return boardMapper.getTotalList(listDTO);
    }
//    게시글 목록
    public List<BoardVO> showAll(ListDTO listDTO){
        return boardMapper.getList(listDTO);}
//    게시글 등록
    public void register(BoardVO boardVO){boardMapper.write(boardVO);}
//    게시글 조회
    public BoardVO findById(Long boardNumber){return boardMapper.showList(boardNumber);}
//    게시글 수정
    public void modify(BoardVO boardVO){boardMapper.updateList(boardVO);}
//    게시글 삭제
    public void remove(Long boardNumber){
        boardMapper.deleteList(boardNumber);
    }
}
