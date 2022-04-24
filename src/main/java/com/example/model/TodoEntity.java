package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder // builder Ŭ������ �ȸ���� builder �������� ������Ʈ ���� ����
@NoArgsConstructor // �Ű� ���� ���� ������ ����
@AllArgsConstructor // ��� �Ű������� �޴� ������ ����
@Data // getter,setter ����
public class TodoEntity {
	private String id; // ������Ʈ ���̵�
	private String userId; // ������Ʈ ������ ������ ���̵�
	private String title; // Todo Ÿ��Ʋ
	private boolean done; // true - todo�Ϸ��� ���
}
