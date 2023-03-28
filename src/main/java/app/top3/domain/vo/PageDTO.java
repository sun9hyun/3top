package app.top3.domain.vo;

import lombok.Data;

@Data
public class PageDTO {
    //    페이지 단위 수
    private int pageCount;
    //    현재 페이지를 기준으로 시작 페이지
    private int startPage;
    //    현재 페이지를 기준으로 마지막 페이지
    private int endPage;
    //    가장 마지막 페이지
    private int realEnd;
    private boolean prev, next;
    //    전체 게시글 개수
    private int total;
    //    화면에서 받아온 page, amount를 필드로 구성한 객체
    private ListDTO listDTO;

    public void createPageDTO(ListDTO listDTO, int total){
        createPageDTO(listDTO, total, 10);
    }

    public void createPageDTO(ListDTO listDTO, int total, int pageCount){
        this.listDTO = listDTO;
        this.total = total;
        this.pageCount = pageCount;

        this.endPage = (int)(Math.ceil(listDTO.getPage() / (double)pageCount)) * pageCount;
        this.startPage = endPage - pageCount + 1;

        this.realEnd = (int)(Math.ceil((double)total / listDTO.getAmount()));

        if(realEnd < endPage){
//            게시글이 한 개도 없다면, realEnd는 0이 되고, endPage도 0이 된다.
//            따라서 realEnd가 0이라면 endPage를 1로 변경해주어야 한다.
            endPage = realEnd == 0 ? 1 : realEnd;
        }
        this.prev = startPage > 1;
        this.next = endPage < realEnd;
    }
}
