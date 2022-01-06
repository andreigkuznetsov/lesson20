package helper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LombokData {

    private String isbn;
    private String subTitle;
    private String publisher;
    private String description;
    private String website;
}

