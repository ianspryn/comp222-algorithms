import java.io.*;
import java.util.*;

public class Schedule {
	//Contains user input broken up accordingly
	static HashMap<String, String[]> courses = new HashMap<String, String[]>();
	//Contains processed format of courses. Will eventually be outputted
	static ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
	
	
		
	public static void main(String[] args) {
		
		 
		 Scanner scnr = new Scanner(System.in);
		 
		 while (scnr.hasNext()) {
			 
			 String[] split = scnr.nextLine().split(":");
			 if (split.length > 1) {
				 courses.put(split[0], split[1].split(","));
			 } else {
				 courses.put(split[0], new String[]{});
			 }
			 
		 }
		 
		 for (String course : courses.keySet()) {
			simulate(course); 
		 }
		 
		 for(ArrayList<String> courses : list) {
			    for(String s: courses) {
			    	System.out.print(s + ", ");
			    }
			    System.out.println();
		}
		
		 
		 scnr.close();
	}
	
	public static HashSet<String> prereq(String course) {
		HashSet<String> prereqs = new HashSet<String>();
		for (String s : courses.get(course)) {
			prereqs.add(s);
			prereqs.addAll(prereq(s));
		}
		
		return prereqs;
	}
	
	public static int semester(String course) {
		int n = 0;
		for (ArrayList<String> value : list) {
		    if (value.contains(course)) {
		        return n;
		    }
		    n++;
		}
		return -1;
	}
	
	public static void simulate(String course) {
		int n = 0;
		for (String s : prereq(course)) {
			for (ArrayList<String> value : list) {
			    if (value.contains(course)) {
			        return;
			    }
			}
			
			int value = semester(s);
			if (value == -1) {
				simulate(s);
				n = Math.max(n, semester(s) + 1);
			} else {
				n = Math.max(n, semester(s) + 1);
			}
			if (list.size() < n+1) {
				list.add(new ArrayList<String>());
			}
			list.get(n).add(course);
		}
	}
}
