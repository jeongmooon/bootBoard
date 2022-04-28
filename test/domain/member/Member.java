package com.sutdy.test.domain.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member {
	@Id //pk
	@GeneratedValue(strategy = GenerationType.AUTO) //�ڵ�����
	private Long id;
	
	@Column(nullable = false,length = 30, unique = true)
	private String username; //���̵�
	
	@Column(nullable = false,length = 100)
	private String password;
	
	@Column(nullable = false,length = 50)
	private String email;
	
	@Column(nullable = false,length = 20)
	private String nickname;
	
	@Enumerated(EnumType.STRING) // JPA�� DB�����Ҷ� Enum���� ���� ����(����Ʈ�� int)
	@Column(nullable = false)
	private Role role;
	
	public void setPassword(String password) {
		this.password = password;
	}
}
