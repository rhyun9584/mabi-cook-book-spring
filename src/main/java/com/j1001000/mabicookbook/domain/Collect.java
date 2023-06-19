package com.j1001000.mabicookbook.domain;

import com.j1001000.mabicookbook.vo.CollectId;
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
    @EmbeddedId
    private CollectId id;

    @Column(columnDefinition = "TINYINT")
    @NotNull
    private Integer status;
}
