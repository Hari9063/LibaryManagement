package com.example.Library_Management.Entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Books")
@Builder
public class Book {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long id;
	private String title;

	private String author;

	private String category;

	private Integer totalCopies;

	private Integer availableCopies;







}
