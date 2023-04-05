package app.top3.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//생성자 주입
@NoArgsConstructor
public class ReplyVO {
    private Long replyNumber;
    private String replyContent;
    private String replyWriter;
    private String replyRegisterDate;
    private String replyUpdateDate;
    private Long boardNumber;
}
