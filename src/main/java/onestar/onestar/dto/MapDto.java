package onestar.onestar.dto;

import lombok.Data;

@Data
public class MapDto {
    private String name;
    private String address;
    private Double longitude;  // 위도
    private Double latitude;   // 경도
}
