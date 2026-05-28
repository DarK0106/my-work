package com.test.java.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.java.dto.BoardDto;
import com.test.java.entitiy.Board;
import com.test.java.entitiy.User;
import com.test.java.repository.BoardRepository;
import com.test.java.repository.UserRepository;

import lombok.RequiredArgsConstructor;

// REST 컨트롤러
@RestController
@RequiredArgsConstructor
public class BoardController {

	private final BoardRepository boardRepository;
	private final UserRepository userRepository;

	// - /board
	@GetMapping("/board")
	public ResponseEntity<Map<String, Object>> board() {

		Map<String, Object> result = new HashMap<String, Object>();

		result.put("result", "ok");
		result.put("path", "/board");
		result.put("message", "board page");

		return ResponseEntity.ok(result);
	}

	// - /board/list
	@GetMapping("/board/list")
	public ResponseEntity<Map<String, Object>> list() {

		// List<Board>를 반환받은걸 변환시켜서
		// List<Map<String, Object>> 이걸로 만든다는 것
		List<Map<String, Object>> list = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "seq")) // List<Board>를 반환
				.stream().map(this::toResponse)
				// .map(board => toResponse(board))
				.toList();

		Map<String, Object> result = new HashMap<String, Object>();

		result.put("result", "ok");
		result.put("list", list);

		return ResponseEntity.ok(result);
	}

	private Map<String, Object> toResponse(Board board) {

		// Board 엔티티 를 변환해서 Map<String, Object>로 만들자
		User user = board.getUser();

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("seq", board.getSeq());
		result.put("subject", board.getSubject());
		result.put("content", board.getContent());
		result.put("regdate", board.getRegdate());
		result.put("username", user.getUsername());
		result.put("name", user.getName());

		return result;

	}

	// - /board/add
	@PostMapping("/board/add")
	public ResponseEntity<Map<String, Object>> add(@RequestBody BoardDto dto, Authentication authentication) {

		// 작성자는 클라이언트가 보낸 username이 아니라 로그인한 사용자에서 가져옴
		User user = userRepository.findById(authentication.getName())
				.orElseThrow(() -> new IllegalStateException("로그인 사용자를 찾을 수 없습니다."));

		// seq는 시퀀스, regdate는 @CreationTimestamp가 채워주므로 null로 둠
		Board board = new Board(null, dto.getSubject(), dto.getContent(), null, user);

		Board resultBoard = boardRepository.save(board);

		Map<String, Object> result = new HashMap<String, Object>();

		result.put("result", "ok");
		result.put("board", toResponse(resultBoard));

		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	// - /board/view
	@GetMapping("/board/view")
	public ResponseEntity<Map<String, Object>> view(@RequestParam("seq") Long seq) {

		Board board = boardRepository.findById(seq).orElse(null);

		if (board == null) {

			Map<String, Object> result = new HashMap<String, Object>();

			result.put("error", "board not found");
			result.put("seq", seq);

			//404
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
		}

		Map<String, Object> result = new HashMap<String, Object>();

		result.put("result", "ok");
		result.put("board", toResponse(board));

		return ResponseEntity.ok(result);
	}

	// - /board/del
	@DeleteMapping("/board/del")
	public ResponseEntity<Map<String, Object>> delete(@RequestParam("seq") Long seq) {

		if (!boardRepository.existsById(seq)) {

			Map<String, Object> result = new HashMap<String, Object>();

			result.put("error", "board not found");
			result.put("seq", seq);

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
		}

		boardRepository.deleteById(seq);

		Map<String, Object> result = new HashMap<String, Object>();

		result.put("result", "ok");
		result.put("seq", seq);

		return ResponseEntity.ok(result);
	}

}
