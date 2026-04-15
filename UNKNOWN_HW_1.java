import java.security.SecureRandom;
import java.time.ZonedDateTime;
import java.time.ZoneId;

public class University {

    // Данный код делали:
    // Толя и Марта

    public static void main(String[] args) {
        System.out.println("Преподаватель №1");
        String[][] Students1 = new String[][] {{"28", "Давид", "+6-923-174-24-24", "UTC"}, {"22", "Вика", "+7-958-893-81-99", "Europe/Moscow"}, {"19", "Иван", "+7-928-833-84-92", "Europe/Moscow"}};
        Lecturers lecturer1 = new Lecturers("Дмитрий", "Java", Students1);
        System.out.println(lecturer1.getLecturer());
        System.out.println("__________________________________________________");
        System.out.println(lecturer1.getStudents());
        System.out.println("Преподаватель №2");
        String[][] Students2 = new String[][] {{"28", "Давид", "+6-923-174-24-24", "UTC"}, {"22", "Вика", "+7-958-893-81-99", "Europe/Moscow"}, {"19", "Иван", "+7-928-833-84-92", "Europe/Moscow"}};
        Lecturers lecturer2 = new Lecturers("Дмитрий", "Java", Students2);
        System.out.println(lecturer2.getLecturer());
        System.out.println("__________________________________________________");
        System.out.println(lecturer2.getStudents());
        System.out.println("Преподаватель №3");
        String[][] Students3 = new String[][] {{"28", "Давид", "+6-923-174-24-24", "UTC"}, {"22", "Вика", "+7-958-893-81-99", "Europe/Moscow"}, {"19", "Иван", "+7-928-833-84-92", "Europe/Moscow"}};
        Lecturers lecturer3 = new Lecturers("Дмитрий", "Java", Students3);
        System.out.println(lecturer3.getLecturer());
        System.out.println("__________________________________________________");
        System.out.println(lecturer3.getStudents());
    }
}

class Students {
    private Integer age;
    private String name;
    private String number;
    private String timezone;

    public Students(String age, String name, String number, String timezone) {
        this.age = Integer.valueOf(age);
        this.name = name;
        this.number = number;
        this.timezone = timezone;
    }

    public String genPassword() {
        Integer pass = Math.abs(new SecureRandom().nextInt());
        String password = String.valueOf(pass);
        return "Пароль от личного кабинета: " + password;
    }

    public String getStudentInfo() {
        return "Имя преподавателя: " + name + " , Возраст: " + age + " , Номер: " + number;
    }

    public String getTimeFromAStudent () {
        ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of(timezone));
        String h = String.valueOf(zdt.getHour());
        String m = String.valueOf(zdt.getMinute());
        return "Текущее время у студента: " + h + ":" + m;
    }
}

class Lecturers {
    private String name;
    private String course;
    private String[][] students;
    public Lecturers(String name, String course, String[][] students) {
        this.name = name;
        this.course = course;
        this.students = students;
    }

    public String getLecturer() {
        return "Имя: " + name + ", Преподаёт курсы по: " + course + ", Всего студентов в группе: " + students.length;
    }
    public String getStudents() {
        for (int i = 0; i < students.length;) {
            Students student = new Students(students[i][0], students[i][1], students[i][2], students[i][3]);
            int a = i + 1;
            System.out.println("Студент №" + a);
            System.out.println(student.getStudentInfo() + "\n" + student.genPassword() + "\n" + student.getTimeFromAStudent());
            i++;
        }
        return "";
    }
}
