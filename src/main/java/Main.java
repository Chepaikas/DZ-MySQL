import db.MySQLConnector;
import objects.Curator;
import objects.GroupStudent;
import objects.Student;
import tables.CuratorTable;
import tables.GroupTable;
import tables.StudentTable;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        StudentTable studentTable = new StudentTable();
        GroupTable groupTable = new GroupTable();
        CuratorTable curatorTable = new CuratorTable();

        try {
            System.out.println("Студенты");
            ArrayList<Student> students = studentTable.selectAll();
            if (students.isEmpty()) {
                studentTable.insert(new Student(1, "Ахматова Анна Андреевна", "woman", 1));
                studentTable.insert(new Student(2, "Чайковский Петр Ильич", "man", 2));
                studentTable.insert(new Student(3, "Гиппиус Зинаида Николаевна", "woman", 3));
                studentTable.insert(new Student(1, "Лермонтов Михаил Юрьевич", "man", 4));
                studentTable.insert(new Student(2, "Высоцкий Владимир Семёнович", "man", 5));
                studentTable.insert(new Student(3, "Лохвицкая Надежда Александровна", "woman", 6));
                studentTable.insert(new Student(1, "Пушкин Александр Сергеевич", "man", 7));
                studentTable.insert(new Student(2, "Герман Анна Евгеньевна", "woman", 8));
                studentTable.insert(new Student(3, "Достоевский Федор Михайлович", "man", 9));
                studentTable.insert(new Student(1, "Цветаева Марина ивановна", "woman", 10));
                studentTable.insert(new Student(2, "Шаляпин Фёдор Иванович", "man", 11));
                studentTable.insert(new Student(3, "Блаватская Елена Петровна", "woman", 12));
                studentTable.insert(new Student(1, "Тютчев Федор Иванович", "man", 13));
                studentTable.insert(new Student(2, "Гвердцители Тамара Михайловна", "woman", 14));
                studentTable.insert(new Student(3, "Гоголь Николай Васильевич", "man", 15));
                students = studentTable.selectAll();
            }

            for (Student tmp : students) {
                System.out.println(tmp.toString());
            }
            System.out.println();
            System.out.println("Группы студентов");

            ArrayList<GroupStudent> groupStudents = groupTable.selectAllGroup();
            if (groupStudents.isEmpty()) {
                groupTable.insertGroup(new GroupStudent(1, "A", 3));
                groupTable.insertGroup(new GroupStudent(2, "B", 2));
                groupTable.insertGroup(new GroupStudent(3, "C", 1));
                groupStudents = groupTable.selectAllGroup();
            }
            for (GroupStudent tmp : groupStudents){
                System.out.println(tmp.toString());
            }
            System.out.println();
            System.out.println("Кураторы");

            ArrayList<Curator> curators = curatorTable.selectAll();
            if (curators.isEmpty()) {
                curatorTable.insertCurator(new Curator(1, "Ленин Владимир Ильич"));
                curatorTable.insertCurator(new Curator(2, "Сталин Иосиф Виссарионович"));
                curatorTable.insertCurator(new Curator(3, "Брежнев Леонид Ильич"));
                curatorTable.insertCurator(new Curator(4, "Горбачёв Михаил Сергеевич"));
                curators = curatorTable.selectAll();
            }
            for (Curator tmp : curators) {
                System.out.println(tmp.toString());
            }
            System.out.println();
            System.out.println("Вывод только студенток");
            System.out.println();

            ArrayList<Student> womenStudent = studentTable.selectAllWomen();

            for (Student student : womenStudent){
                    System.out.println("" + student.getFio());
            }
            System.out.println();
            System.out.println("Вывод количества студентов");
            System.out.println();

            int count= studentTable.selectCountStudent();
            System.out.println("Количество студентов:" + count);

            System.out.println();
            System.out.println("Вывод информации о всех студентах с названиями групп и фио кураторов");
            System.out.println();

            studentTable.printStudentGroupNameCuratorFio();

            System.out.println();
            System.out.println("Обновить данные по группе C, сменив куратора на Горбачёва Михаила Сергеевича");
            System.out.println("Вывод результата замены: группы и их кураторы после смены куратора");
            System.out.println();

            curatorTable.updateCuratorInGroupC();
            groupTable.printRezultExchang();

            System.out.println();
            System.out.println("Вывод студентов из группы В");
            System.out.println();

            studentTable.printStudentGroupB();

        } finally {
            MySQLConnector.close();
        }
    }
}

