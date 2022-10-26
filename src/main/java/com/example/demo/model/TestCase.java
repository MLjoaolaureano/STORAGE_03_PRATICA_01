package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class TestCase {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_case;

    @Column(length = 256)
    private String description;

    @Column
    private boolean tested;

    @Column
    private boolean passed;

    @Column
    private int number_of_tries;

    @Column(name = "last_update")
    private Date lastUpdate;

}