package cs1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class GradebookTester {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner input =new Scanner(System.in);
		int choice;
		Gradebook students[]=ReadFromFile();
		while(true) {
			displayMenu();
			choice=input.nextInt();
			switch(choice) {
			case 1:{
				sortByName(students);
				display(students);
				continue;
			}
			case 2:{
				sortByAvg(students);
				display(students);
				continue;
			}
			case 3:{
				System.out.println("Enter name: ");
				String nameSearch=input.next();
				int index=nameSearch(students,nameSearch);
				if(index==-1) {
					System.out.println(nameSearch+" not found");
				}else {
					System.out.println(students[index]);
				}
				continue;
			}
			case 4:{
				display(students);
				continue;	
			}
			case 5:{
				displayAvgUnder5(students);
				continue;
			}
			case 6:{
				File outputFile=new File("Report.txt"); 
				
				if(outputFile.exists()) {
					System.out.println("File already exists");
					System.exit(0);
				}
				
				PrintWriter output=new PrintWriter(outputFile);
				
				output.println("Total nunber of students: "+ students.length);
				output.println("Name"+" "+"Quiz1"+" "+"Quiz2"+" "+"Average");
				output.println("----"+" "+"-----"+" "+"-----"+" "+"-----");
				for(int i=0;i<students.length;i++) {
					output.println(students[i]);
				}
				
		        {
	
			}
				System.out.print("student report has been written to file in directory");
				output.close();
				break;
			}
			default:{
			System.out.println("//Invalid Input//");
			continue;
			}
		}
		break;
		}
	}
	private static Gradebook[] ReadFromFile() throws Exception {
		int count = 0;
		String name;
		int qz1;
		int qz2;
		Scanner inputFile=new Scanner(new File("student.txt"));
		while(inputFile.hasNext()) {
			inputFile.nextLine();
			count++;
		}
		inputFile.close();
		Gradebook n[]=new Gradebook[count];
		inputFile=new Scanner(new File("student.txt"));
		for(int i=0;i<count;i++) {
			name=inputFile.next();
			qz1=inputFile.nextInt();
			qz2=inputFile.nextInt();
			n[i]=new Gradebook(name,qz1,qz2);
		}
		return n;
	}
	private static void displayMenu() {
		System.out.println("1: Print in sorted order by name");
		System.out.println("2: Print in sorted order by avg score");
		System.out.println("3: Search for a particular name");
		System.out.println("4: Print all student records");
		System.out.println("5: Print all student records who average of quiz is below 5.");
		System.out.println("6: Write student name, two quiz scores and their average to the File.");	
	}
	
	private static void sortByName(Gradebook[]students) {
		Gradebook temp;
		for(int i=0;i<students.length;i++) {
			for (int j=0;j<students.length;j++) {
			if(students[i].getName().compareTo(students[j].getName())>0) {
				temp=students[i];
				students[i]=students[j];
				students[j]=temp;	
				}
			}
		}
	}
	private static int nameSearch(Gradebook[]students,String nameSearch) {
		for(int i=0;i<students.length;i++) {
			if(students[i].getName().equalsIgnoreCase(nameSearch))
				return i;
		}
		return -1;
	}
	private static void sortByAvg(Gradebook[]students) {
		Gradebook temp;
		for(int i=0;i<students.length;i++) {
			for(int j=0;j<students.length;j++) {
				if(students[i].avg()>students[j].avg()) {
					temp=students[i];
					students[i]=students[j];
					students[j]=temp;	
				}
			}
		}
	}
	private static void displayAvgUnder5(Gradebook[]students) {
		for(int i=0;i<students.length;i++) {
			if(students[i].avg()<5) {
				System.out.println(students[i]);
			}
		}
	}
	public static void display(Gradebook[]students) {
		System.out.println("Total nunber of students: "+ students.length);
		System.out.println("Name"+" "+"\tQuiz1"+" "+"\tQuiz2"+" "+"\tAverage");
		System.out.println("----"+" "+"\t-----"+" "+"\t-----"+" "+"\t----");
		for(int i=0;i<students.length;i++) {
			System.out.println(students[i]);
		}
	}
}