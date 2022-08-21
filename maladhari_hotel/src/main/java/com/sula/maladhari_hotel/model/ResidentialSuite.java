package com.sula.maladhari_hotel.model;

import com.sula.maladhari_hotel.model.enums.ResidentialSuitTypes;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "residential_suite")
@Data
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class ResidentialSuite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private ResidentialSuitTypes residentialSuitTypes;

    private String availability;
}
