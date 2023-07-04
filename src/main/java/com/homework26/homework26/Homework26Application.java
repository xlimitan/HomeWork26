package com.homework26.homework26;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

import static com.homework26.homework26.IntegerList.IntegerListImpl.*;

@SpringBootApplication
public class Homework26Application {

	public static void main(String[] args) {
		SpringApplication.run(Homework26Application.class, args);

		Integer[] one = generateRandomArray();
//		Arrays.copyOf(one, one.length);
//		long start = System.currentTimeMillis();
//		sortInsertion(one);
//		System.out.println(System.currentTimeMillis() - start);

		Arrays.copyOf(one, one.length);
		long start1 = System.currentTimeMillis();
		sortSelection(one);
		System.out.println(System.currentTimeMillis() - start1);

//		Arrays.copyOf(one, one.length);
//		long start2 = System.currentTimeMillis();
//		sortBubble(one);
//		System.out.println(System.currentTimeMillis() - start2);

	}

}
