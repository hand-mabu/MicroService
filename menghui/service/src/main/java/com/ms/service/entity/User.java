package com.ms.service.entity;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;

    private String userName;

    private String passWord;

    private String realName;
}
