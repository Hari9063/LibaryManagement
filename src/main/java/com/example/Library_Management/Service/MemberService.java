package com.example.Library_Management.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Library_Management.Entity.Book;
import com.example.Library_Management.Entity.Member;
import com.example.Library_Management.Repository.MemberRepo;

@Service
public class MemberService {

	private MemberRepo repo;

	public MemberService(MemberRepo repo) {
		this.repo=repo;
	}

	public List<Member> getAll(){

		return repo.findAll();

	}

	public Member getMemberbyId(long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(()->new RuntimeException("Member not found"));
	}

	public Optional<Member> search(String q) {
		// TODO Auto-generated method stub
		return repo.findByEmail(q);
	}

	public ResponseEntity<Member> addMember(Member m) {

		return ResponseEntity.ok(repo.save(m));
	}

	public void deleteMember(long id) {

		repo.deleteById(id);
	}

	public void updateMember(long id, Member m) {
		// TODO Auto-generated method stub
		Member m1=repo.findById(id).orElseThrow(()->new RuntimeException("Member not found"));
		m1.setEmail(m.getEmail());
		m1.setName(m.getName());
		m1.setRole(m.getRole());
		repo.save(m1);
		
	}




}
