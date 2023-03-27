package app.top3.domain.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Data
public class BoardVO {
    private Long boardNumber;
    @NotBlank(message = "제목을 입력해주세요")
    private String boardTitle;
    @NotBlank(message = "작성자를 입력해주세요")
    private String boardWriter;
    @NotBlank(message = "내용을 입력해주세요")
    private String boardContent;
    private String boardRegisterDate;
}
