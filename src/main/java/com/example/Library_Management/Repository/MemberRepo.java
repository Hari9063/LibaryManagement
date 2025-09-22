package com.example.Library_Management.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Library_Management.Entity.Member;

public interface MemberRepo extends
JpaRepository<Member,Long>
{

Optional<Member> findByEmail(String email);




}
