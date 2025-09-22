package com.example.Library_Management.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Library_Management.Entity.Book;
import com.example.Library_Management.Entity.Loan;
import com.example.Library_Management.Entity.LoanStatus;
import com.example.Library_Management.Entity.Member;
import com.example.Library_Management.Repository.BookRepository;
import com.example.Library_Management.Repository.LoanRepo;
import com.example.Library_Management.Repository.MemberRepo;

@Service
public class LoanService {

	private LoanRepo repo;
	private BookRepository bookRepo;
	private MemberRepo memberRepo;
	public LoanService(LoanRepo repo,BookRepository br,MemberRepo mr) {
		this.repo=repo;
		this.bookRepo=br;
		this.memberRepo=mr;
	}

	public List<Loan> getAllLoans() {
	
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Member getMembyM_Id(long m_id) {
		// TODO Auto-generated method stub
		return memberRepo.findById(m_id).orElseThrow(()->new RuntimeException("Member not found"));
	}



	public Loan borrow(long b_id, long m_id, int days) {
		// TODO Auto-generated method stub
		
		Book b=bookRepo.findById(b_id).orElseThrow(()->new RuntimeException("Book Not Found"));
		if(b.getAvailableCopies()<1) {
			throw new RuntimeException("Book not avialable.");
		}
		Member m=memberRepo.findById(m_id).orElseThrow(()->new RuntimeException("Member Not Found"));
        b.setAvailableCopies(b.getAvailableCopies()-1);
		Loan l=Loan.builder().book(b).member(m).borrowDate(LocalDate.now()).
				dueDate(LocalDate.now().plusDays(days)).status(LoanStatus.BORROWED).build();

		return repo.save(l);
	}

	public Loan returnBok(long id) {
		// TODO Auto-generated method stub
		
		Loan l =repo.findById(id).orElseThrow(()-> new RuntimeException("Issue Id not found"));
		if(l.getStatus()==LoanStatus.RETURNED) {
			throw new RuntimeException();
		}

		l.setReturnDate(LocalDate.now());
		
		Book b=l.getBook();
		b.setAvailableCopies(b.getAvailableCopies()+1);
		bookRepo.save(b);
	
		  return repo.save(l);
		
	}

	public void deleteLoan(long id) {
		
		repo.deleteById(id);
		
	}


}
