package app.top3.controller;

import app.top3.domain.vo.ReplyVO;
import app.top3.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;

//    댓글 등록
    @PostMapping("/new")
    public ResponseEntity<String> write(@RequestBody ReplyVO replyVO){
        replyService.register(replyVO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
//    댓글 목록
    @GetMapping("/list/{bno}")
    public List<ReplyVO> list(@PathVariable("bno") Long boardNumber){
        return replyService.showAll(boardNumber);
    }

}
