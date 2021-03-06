package lecture;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		Lecture lecture = new GradeLecture("객체지향 프로그래밍",
				70,
				Arrays.asList(new Grade("A", 100, 95),
						new Grade("B", 94, 80),
						new Grade("C", 79, 70),
						new Grade("D", 69, 50),
						new Grade("F", 49, 0)),
				Arrays.asList(81, 95, 75, 50, 45));

		System.out.println("lecture = " + lecture.evaluate());

		Professor professor = new Professor("다익스트라", new Lecture("자료구조", 70, Arrays.asList(81, 95, 75, 50, 45)));
		System.out.println("professor = " + professor.compileStatistics());

		Professor professor1 = new Professor("다익스트라",
				new GradeLecture("자료구조",
						70,
						Arrays.asList(new Grade("A", 100, 95),
								new Grade("B", 94, 80),
								new Grade("C", 79, 70),
								new Grade("D", 69, 50),
								new Grade("F", 49, 0)),
						Arrays.asList(81, 95, 75, 50, 45)));
		System.out.println("professor1 = " + professor1.compileStatistics());
	}
}
