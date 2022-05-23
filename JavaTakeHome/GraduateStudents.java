package JavaTakeHome;
import java.util.Scanner;


/**
 * Created by Simay on 13.4.2019.
 */
public class GraduateStudents extends Students {

    public GraduateStudents(String name, String sname, int id, double cgpa) {
        super.setName(name);
        super.setSname(sname);
        super.setId(id);
        super.setCgpa(cgpa);
        
        
        Scanner sc= new Scanner(System.in);
        name = sc.nextLine();
        sname = sc.nextLine();
        id = sc.nextInt();
        cgpa = sc.nextFloat();

}

    @Override
    public void display() {
        System.out.println("\nType : Graduate Student");
        super.display();
    }
}
