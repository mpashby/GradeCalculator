//Michele Pashby
//HW 4
import java.util.*;
public class Grades {
	public static void main(String[] args) {
		Scanner console=new Scanner(System.in);
		System.out.println("This program accepts your homework and exam \nscores as input, and computes your grade in "
				+ "\nthe course or indicates what grade you need "
				+ "\nto earn on the final exam.");
		double hwGrade = homework(console);
		double mtGrade=midterm(console);
		finalexam(console, hwGrade, mtGrade);
	}
	
	//Homework
	public static double homework(Scanner console) {	
		System.out.println("\nHomework:");
		System.out.print("\tWhat is its weight (0-100)?");
		double hwweight=console.nextDouble();
		System.out.print("\tHow many homework assignments were there?");
		int hwass=console.nextInt();
		Double hwscoresum=0.0;
		Double hwmaxsum=0.0;
		for (int i=1; i<= hwass; i++){
			System.out.print("\tHomework "+i +" score and max score:");
			hwscoresum=hwscoresum+console.nextDouble();
			hwmaxsum=hwmaxsum+console.nextDouble();
		}
		double hwgrade=(hwscoresum)/(hwmaxsum)*hwweight;
		System.out.println("\tWeighted homework score: " + round2(hwgrade));
		return hwgrade;
	}
	//Midterm
	public static double midterm(Scanner console) {
		System.out.println("\nMidterm exam:");
		System.out.print("\tWhat is its weight (0-100)?");
		double mtweight=console.nextDouble();
		System.out.print("\tExam Score: ");
		double mtscore=console.nextDouble();
		System.out.print("\tWas there a curve? (1 for yes, 2 for no)");
		int  mtques=console.nextInt();
		if (mtques==1) {
			System.out.print("\tHow much was the curve?");
			double mtcurve=console.nextInt();
			mtscore=mtscore+mtcurve;
			if (mtscore>100){
				mtscore=100;
			}else {
				mtscore=mtscore;
			}
		} else if (mtques==2) {
			mtscore=mtscore;
		} else {
			System.out.println("Error");
		}
		double mtgrade=mtscore/100*mtweight;
		System.out.println("\tWeighted exam score: " + round2(mtgrade));
		return mtgrade;
	}
	//Final
	public static void finalexam(Scanner console, double hwGrade, double mtGrade) {
		System.out.println("\nFinal Exam:");
		System.out.print("\tHave you taken the final exam yet? (1 for yes, 2 for no)");
		int finex=console.nextInt();
		System.out.print("\tWhat is its weight (0-100)?");
		double fweight=console.nextDouble();
			if (finex==1) {
				System.out.print("\tExam score: ");
				double exscore=console.nextDouble();
				System.out.print("\tWas the final curved? (1 for yes, 2 for no)");
				int fcq=console.nextInt();
				if (fcq==1) {
					System.out.print("\tWhat was the curve?");
					double fincurve=console.nextDouble();
					exscore=exscore+fincurve;
				} else if (fcq==2) {
					exscore=exscore;
				} else {
					System.out.println("Error");
				}
				double finGrade=exscore/100*fweight;
				System.out.println("\tWeighted exam score: "+round2(finGrade));
				double coursegrade=hwGrade+mtGrade+finGrade;
				System.out.print("\n\tYour course grade is : "+round2(coursegrade));
			} else if (finex==2) {
				System.out.print("\tWhat percentage would you like to earn in the course?");
				double fpercent=console.nextDouble();
				double fgoal=100*(fpercent-hwGrade-mtGrade)/fweight;
				if (fgoal<=0.0) {
					fgoal=0.0;
					System.out.print("\tYou need a score of " + round2(fgoal)+ " on the final exam");
				} else if (fgoal>100.0) {
				    System.out.print("\n\n\tYou need a score of "+round2(fgoal)+" on the final exam." 
				    + "\n\tSorry, it is impossible to achieve this percentage." 
				    + "\n\tThe highest percentage you can get is " +round2(hwGrade+mtGrade+fweight));
				
				} else if (fgoal>0.0 && fgoal<100) {
					System.out.print("\n\n\tYou need a score of " + round2(fgoal)+ " on the final exam");
				}
			} else {
				System.out.println("Error");
			}
	}
	//Rounding
	public static double round2(double number) {
		return Math.round(number*100.0)/100.0;
	}
	
}
