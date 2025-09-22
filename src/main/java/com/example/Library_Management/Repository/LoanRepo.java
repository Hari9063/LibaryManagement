package com.example.Library_Management.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Library_Management.Entity.Loan;
import com.example.Library_Management.Entity.LoanStatus;
import com.example.Library_Management.Entity.Member;

public interface LoanRepo extends JpaRepository<Loan,Long> {
	List<Loan> findByMemberId(long MemberId);
	List<Loan> findByStatus(LoanStatus status);

	
	

}
