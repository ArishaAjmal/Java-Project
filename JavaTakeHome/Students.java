package JavaTakeHome;



/**
 * Created by Simay on 13.4.2019.
 */
public class Students {
    public String name, sname;
    public int id;
    public double cgpa;

    public void setName(String name) {
        this.name = name;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public String getName() {
        return name;
    }

    public String getSname() {
        return sname;
    }

    public int getId() {
        return id;
    }

    public double getCgpa() {
        return cgpa;
    }


    Students(String _name, String _sname, int _id, double _cgpa){
        this.name=_name;
        this.sname=_sname;
        this.id=_id;
        this.cgpa=_cgpa;


    }
    Students(){}

    public  void display(){
        System.out.println("Name: "+getName()+ " Surname: " + getSname()+" ID: " + getId()+" CGPA: "+ getCgpa());


    }
}
