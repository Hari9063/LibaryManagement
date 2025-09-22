package com.example.Library_Management.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Library_Management.Entity.Member;
import com.example.Library_Management.Service.MemberService;

@RestController
@RequestMapping("/api/members")
public class MemberController {

	private final MemberService ser;

	public MemberController(MemberService ser) {
		this.ser=ser;

	}

	@GetMapping
	public List<Member> getAll() {
		return ser.getAll();
	}
	@GetMapping("/{id}")
	public Member getById(@PathVariable long id) {

		return ser.getMemberbyId(id);

	}
	@GetMapping("/{q}")
	public Optional<Member> searchemail(@RequestParam("q") String q) {

		return ser.search(q);

	}

	@PostMapping
	public ResponseEntity<Member> AddMember(@RequestBody Member m) {

		return ser.addMember(m);
	

	}

	@PutMapping("/{id}")
	public void updateMember(@PathVariable long id,@RequestBody Member m) {

		ser.updateMember(id,m);
	}

	@DeleteMapping("/{id}")
	public void DeleteMember(@PathVariable long  id) {
		ser.deleteMember(id);
	}


}
