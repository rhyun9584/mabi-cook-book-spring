package com.j1001000.mabicookbook.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Collect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private SiteUser user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COOK_ID", nullable = false)
    private Cook cook;

    @Column(columnDefinition = "TINYINT")
    @NotNull
    private Integer status;
}
