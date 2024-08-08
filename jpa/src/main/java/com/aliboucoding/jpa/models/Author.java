package com.aliboucoding.jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
//@Table/* (name = "AUTHOR_TBL") */
public class Author extends BaseEntity {

    /* @Id
    @GeneratedValue
            /*(
            strategy = GenerationType.TABLE,
            generator = "author_id_gen") */
    /* @SequenceGenerator(
            name="author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1) */
    /* @TableGenerator(
            name = "author_id_gen",
            table = "id_generator",
            pkColumnName = "id_name",
            valueColumnName = "id_value",
            allocationSize = 1
    ) */
// **** BaseEntity にまとめてるので省略
// @EqualsAndHashCode(callSuper = true)をつけること。
// BuilderからSuperBuilderへの変更も忘れずに。
// private Integer id;

    @Column(
            name = "f_name",
            length = 35
    )
    private String firstName;
    private String lastName;
    @Column(
            unique = true,
            nullable = false
    )
    private String email;
    private int age;


//    @Column(
//            updatable = false,
//            nullable = false
//    )
//    private LocalDateTime createAt;
//
//    @Column(
//            insertable = false
//    )
//    private LocalDateTime lastModified;


}
