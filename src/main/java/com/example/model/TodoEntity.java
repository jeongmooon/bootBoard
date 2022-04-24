package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder // builder 클래스를 안만들고 builder 패턴으로 오브젝트 생성 가능
@NoArgsConstructor // 매개 변수 없는 생성자 구현
@AllArgsConstructor // 모든 매개변수를 받는 생성자 구현
@Data // getter,setter 구현
public class TodoEntity {
	private String id; // 오브젝트 아이디
	private String userId; // 오브젝트 생성한 샤용자 아이디
	private String title; // Todo 타이틀
	private boolean done; // true - todo완료한 경우
}
