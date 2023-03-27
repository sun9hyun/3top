package app.top3.controller;

import app.top3.domain.vo.BoardVO;
import app.top3.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
@Slf4j
public class BoardController {
    private final BoardService boardService;
    @GetMapping("/index")
        public void main(){}

//    게시글 목록
    @GetMapping("/list")
    public void list(Model model){
        model.addAttribute("boards",boardService.showAll());
    }

//    게시글 등록
    @GetMapping("/write")
    public void writeForm(Model model){
        model.addAttribute("board", new BoardVO());
    }

    @PostMapping("/write")
    public String write(@Validated @ModelAttribute("board") BoardVO boardVO, BindingResult result) {

        if(result.hasErrors()){
            log.info("쓰기 예외 발생 = {}", result);
            return "/board/write";
        }

        boardService.register(boardVO);
        return "/board/reload";
    }
//    게시글 조회
    @GetMapping("/read")
    public String read(Long boardNumber, Model model){
        model.addAttribute("board", boardService.findById(boardNumber));
        return"/board/read";
    }

//    게시글 수정
    @GetMapping("/update")
    public void modify(Long boardNumber, Model model){
        model.addAttribute("board", boardService.findById(boardNumber));
    }

    @PostMapping("/update")
    public String update(BoardVO boardVO, RedirectAttributes redirectAttributes){
        redirectAttributes.addAttribute("boardNumber", boardVO.getBoardNumber());
        boardService.modify(boardVO);
        return "redirect:/board/read";
    }

//    게시글 삭제
    @GetMapping("/delete")
    public String delete(Long boardNumber){
        boardService.remove(boardNumber);
        return "redirect:/board/list";
    }
}
