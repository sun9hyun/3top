package app.top3.domain.vo;

import lombok.Data;
import org.springframework.web.util.UriComponentsBuilder;

@Data
public class ListDTO {
    private int page;
    private int amount;
    private int skip;
    private String type;
    private String keyword;

    public void createListDTO(int page, int amount) {
        this.page = page;
        this.amount = amount;
        this.skip = (page - 1) * amount;
    }

    public void createListDTO(){ createListDTO(1,10); }

    public String getQueryString(){
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
                .queryParam("page", this.page)
                .queryParam("amount", this.amount);
        return builder.toUriString();
    }

}