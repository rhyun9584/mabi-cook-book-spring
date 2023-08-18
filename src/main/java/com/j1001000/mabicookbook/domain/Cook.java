package com.j1001000.mabicookbook.domain;

import com.j1001000.mabicookbook.vo.Method;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Cook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String engName;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Method method;
}
