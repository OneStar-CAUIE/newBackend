package onestar.onestar.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudyCafeDto {
    private String name;
    private String address;
    private String date;
    private String time;

}
