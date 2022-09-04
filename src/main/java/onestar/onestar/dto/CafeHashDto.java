package onestar.onestar.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class CafeHashDto {
    private String name;
    private boolean tnf;
    private List<String> hashes;

}
