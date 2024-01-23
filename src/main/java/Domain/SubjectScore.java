package Domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
Create Table Subject_Score
(
	student_id VARCHAR(20),
    subject_name VARCHAR(20),
    subject_grade ENUM('A+', 'A0', 'B+', 'B0', 'C+', 'C0', 'D+', 'D0', 'F') NOT NULL,
    subject_score INT NOT NULL,
    subject_retake VARCHAR(1) NOT NULL,
    PRIMARY KEY (student_id, subject_name),
    FOREIGN KEY (student_id) references Student(student_id),
    FOREIGN KEY (subject_name) references Subject(subject_name)
);
*/

// 이 부분의 PK 두 가지도 INT 형으로 할 수 있는지 한 번 찾아보도록 하겠습니다
@NoArgsConstructor
@Getter
@Entity // JPA 사용 시 CRUD 작업 수행 가능
@Table(name = "Subject_Score")
public class SubjectScore {
    @Id
    @Column(name = "student_id", length = 20)
    private String studentId;

    @Id
    @Column(name = "subject_name", length = 20)
    private String subjectName;

    @Enumerated(EnumType.STRING)
    @Column(name = "subject_grade", nullable = false)
    private SubjectScoreEnum subjectScoreEnum;

    @Column(name = "subject_score", nullable = false)
    private int subjectScore;

    @Column(name = "subject_retake", nullable = false)
    private String subjectRetake;

    @Builder
    public SubjectScore(String studentId, String subjectName, SubjectScoreEnum subjectScoreEnum,
                        int subjectScore, String subjectRetake)
    {
        this.studentId = studentId;
        this.subjectName = subjectName;
        this.subjectScoreEnum = subjectScoreEnum;
        this.subjectScore = subjectScore;
        this.subjectRetake = subjectRetake;
    }
}