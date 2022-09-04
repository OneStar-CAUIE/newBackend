package onestar.onestar.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class StudyCafe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String date;
    private String time;

    @Builder
    public StudyCafe(int id, String name, String address, String date, String time){
        this.id = id;
        this.name = name;
        this.address = address;
        this.date = date;
        this.time =time;

    }




}
