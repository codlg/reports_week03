package com.sparta.week03.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findAllByOrderByModifiedAtDesc();  // findAll - 찾아라 By OrderBy - 순서대로 정렬해줘 ModifiedAt - 수정된 날짜 기준으로 Desc - 내림차순
}
