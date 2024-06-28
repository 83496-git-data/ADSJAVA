package dependent;

import dependency.Coach;
import dependency.Teacher;

public class PublicSchool implements School {
	private Teacher subjectTeacher;
	private Coach coachTeacher;

	public PublicSchool() {
		// TODO Auto-generated constructor stub
	}

	public PublicSchool(Teacher subjectTeacher) {
		this.subjectTeacher = subjectTeacher;
		System.out.println("In constructor - " + getClass());
	}

	@Override
	public void manageAcademics() {
		System.out.println("Managing academics here -");
		subjectTeacher.teach();
	}

	public void setCoachTeacher(Coach coachTeacher) {
		this.coachTeacher = coachTeacher;
		System.out.println("in setCoachTeacher in Public School ");
	}

	public Coach getCoachTeacher() {
		return coachTeacher;
	}
}
