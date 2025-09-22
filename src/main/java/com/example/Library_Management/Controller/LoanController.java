package com.example.Library_Management.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Library_Management.Entity.Loan;
import com.example.Library_Management.Entity.Member;
import com.example.Library_Management.Service.LoanService;

@RequestMapping("/api/loans")
@RestController
public class LoanController {

	private LoanService ser;

	public LoanController(LoanService ser) {
		this.ser=ser;
	}

	@GetMapping
	public List<Loan> getAllLoans(){

		return ser.getAllLoans();

	}

	@GetMapping("/{id}")
	public Member getById(@PathVariable long id) {

		return ser.getMembyM_Id(id);

	}
	@PostMapping
	public ResponseEntity<Loan> borrow(@RequestParam long bookId,@RequestParam long memberId,@RequestParam int loanDays){
		return ResponseEntity.ok(ser.borrow(bookId,memberId,loanDays));
	}
	@PostMapping("/return/{id}")
	public ResponseEntity<Loan> returnbook(@PathVariable long id){
		return ResponseEntity.ok(ser.returnBok(id));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteLoan(@PathVariable Long id) {
        ser.deleteLoan(id);
        return ResponseEntity.ok(Map.of("message", "Loan deleted successfully"));
    }

}
