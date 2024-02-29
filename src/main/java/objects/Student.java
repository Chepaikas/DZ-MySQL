package objects;

public class Student {
    private long studentId, groupId;
    private String studentFio, sex;

    public Student(long groupId, String studentFio, String sex, long studentId) {
        this.groupId = groupId;
        this.studentFio = studentFio;
        this.sex = sex;
        this.studentId = studentId;

    }

    public long getStudentId() {

        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getFio() {
        return studentFio;
    }

    public void setFio(String fio) {
        this.studentFio = fio;
    }
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }
    public String toString() {
        return "Student | " + "studentId = " + studentId + " | studentFio - "
                + studentFio + ' ' + "| sex - " + sex + ' '
                + "| groupId = " + groupId + ' ';

        }

    }

