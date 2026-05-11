package com.test.java.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tblUser")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	@Column(name = "id", length = 50)
	private String id;
	
	@Column(name = "pw", nullable = false, length = 50)
	private String pw;
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	// 부모 -> (참조) -> 자식 를 한 상황임
	// 근데 UserInfo 에서
	// 자식 -> (참조) -> 부모 를 했었기 때문에
	// 결론적으로 양방향 참조를 해둔 상태임
	@OneToOne(mappedBy = "user")
//	@OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
	private UserInfo userInfo;
	
	// 유저 : 보드(Board) = 1 : N
	// 여러개 받으니까 ArrayList로 받음
	// 여기서 부모 -> (참조) -> 자식 를 했고
	// Board(엔티티) 에서
	// 자식 -> (참조) -> 부모 를 했었기 때문에
	// 결론적으로 양방향 참조를 해둔 상태임
	@OneToMany(mappedBy = "user")
//	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Board> board;	
	
}
