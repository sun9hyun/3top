package app.top3.mapper;

import app.top3.domain.vo.BoardVO;
import app.top3.domain.vo.ListDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BoardMapper {
//    게시글 총 갯수
    int getTotalList(ListDTO listDTO);
//    게시글 목록
    List<BoardVO> getList(ListDTO listDTO);
//    게시글 등록
    int write(BoardVO boardVO);
//    게시글 조회
    BoardVO showList(Long boardBNumber);
//    게시글 수정
    int updateList(BoardVO boardVO);
//    게시글 삭제
    int deleteList(Long BoardNumber);
}
