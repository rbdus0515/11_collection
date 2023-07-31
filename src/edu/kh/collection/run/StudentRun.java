package edu.kh.collection.run;

import edu.kh.collection.model.service.StudentService;

public class StudentRun {
	public static void main(String[] args) {
		
		StudentService service = new StudentService();
		
		//service.ex();
		//service.displayMenu();
		
	}

	
	class Solution {
	    public int solution(int num, int n) {
	        
	        
	        if(num % n == 0) {
	        	return 1;
	        } else {
	        	return 0;
	        }
	    }
	}
}

