package onestar.onestar.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cafe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double rate;
    private String address;
    private String date;
    private String time;
    private double price;

    // 키워드
    private int Coffee;
    private int Beverage;
    private int interior;
    private int talk;
    private int dessert;
    private int view;
    private int picture;
    private int kind;
    private int concentration;
    private int food;
    private int wide;
    private int clean;
    private int parking;
    private int bread;
    private int special;
    private int cost;
    private int fresh;
    private int chair;
    private int tea;

}
