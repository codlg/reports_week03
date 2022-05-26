package com.sparta.week03.domain;

import lombok.Getter;

@Getter
public class BoardRequestDto {
    private String writer;
    private String password;
    private String title;
    private String contents;
}
