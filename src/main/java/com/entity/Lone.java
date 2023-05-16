package com.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Lone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String type;
    Double amount;
    Double interest;
}
