package com.j1001000.mabicookbook.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class CollectId implements Serializable {
    @Column
    private Long userId;
    @Column
    private Integer cookId;
}
