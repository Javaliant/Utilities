import java.util.Arrays;

public class GradeCalculator {
	private static final double WEIGHT = 0.2;
	private static final double TOTAL = 75;

	public static void main(String[] args) {
		double[] projects = {100.0, 100.0, 96};
		double[] homeworks = {97.7, 94};
		double[] quizzes = {87.5, 93.4, 95};
		double midterm = 89.8;
		double homeworkWeight = 0.15;

		System.out.println("Grade is: " + (weightedAverage(projects) + weightedAverage(homeworks, homeworkWeight) + weightedAverage(quizzes) + weighted(midterm)) / TOTAL);
	}



	private static double weighted(double grade) {
		return grade * WEIGHT;	
	}
	private static double weighted(double grade, double weight) {
		return grade * weight;
	}

	private static double weightedAverage(double[] grades) {
		return average(grades) * WEIGHT;
	}
	private static double weightedAverage(double[] grades, double weight) {
		return average(grades) * weight;
	}

	private static double average(double[] grades) {
		return Arrays.stream(grades).average().getAsDouble();
	}
}
