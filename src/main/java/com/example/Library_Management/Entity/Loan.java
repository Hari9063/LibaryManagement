package com.example.Library_Management.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Loan")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Loan {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private long id;

	@ManyToOne
    @JoinColumn(name = "book_id", nullable = false) // foreign key column in Loan table
    private Book book;

    // Many loans can be for the same member
    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false) // foreign key column in Loan table
    private Member member;
	private LocalDate borrowDate;


	private LocalDate dueDate;

	private LocalDate returnDate;
	
	
	@Enumerated(EnumType.STRING)
	private LoanStatus status;










}
