package kz.bitlab.springframework.springframework1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Item {
    private Long id;
    private String name;
    private String description;
    private double price;
}
