
package school;
import java.util.ArrayList;
public class Course {
    enum Type {
        Math,Science,English,History,Language,Elective,PE
    }
    private static ArrayList<Course> courses = new ArrayList<Course>();
    private String name;
    private Type type;
    private int period;
    public final static int numPeriods = 4;
    private boolean honors = false;
    
    private ArrayList<Student> students = new ArrayList<Student>();
  //  private Student theStudent;
    private Teacher theTeacher;
   // public double grade;

    public static Course addCourse(String _name, Type _type, int _period, boolean _honors)
    {
        Course temp = new Course(_name,_type,_period,_honors);
        courses.add(temp);
        return(temp);
    }
    
    
    
    Course()
    {
        name = "None";
        type = Type.Elective;
        period = 1;
        honors = false;
    }
    Course(String _name,Type _type, int _period, boolean _honors)
    {
        name = _name;
        type = _type;
        period = _period;
        honors = _honors;
    }   


    public boolean addStudent(Student _student, double _grade)
    {
        if (!setStudentOK(_student))
            return(false);
        if (!_student.setCourseOK(this))
            return(false);
        _student.setCourseDoIt(this, _grade);
        setStudentDoIt(_student);
        return(true);
    }  

    public boolean setStudentOK(Student _student)
    {
        if (_student == null)
            return(false);
        if (students.contains(_student))
            return(false);
        return(true);
    }
    public void setStudentDoIt(Student _student)
    {
        students.add(_student);
    }    
    
        /////////////////////    
    
    
    public boolean addTeacher(Teacher _teacher)
    {
        if (!setTeacherOK(_teacher))
            return(false);
        if (!_teacher.setCourseOK(this))
            return(false);
        _teacher.setCourseDoIt(this);
        setTeacherDoIt(_teacher);
        return(true);
    }  
    public boolean setTeacherOK(Teacher _teacher)
    {
        if (_teacher == null)
            return(false);
        if (theTeacher != null)
            return(false);
        return(true);
    }
    public void setTeacherDoIt(Teacher _teacher)
    {
        theTeacher = _teacher;
    }    
    public Teacher getTeacher()
    {
        return(theTeacher);
    }
        
    public void setPeriod(int _period)
    {
        period = _period;
    }
    public int getPeriod()
    {
        return(period);
    }       
     public void setHonors(boolean _honors)
    {
        honors = _honors;
    }
    public boolean getHonors()
    {
        return(honors);
    }  
    public void setName(String _name)
    {
        name = _name;
    }
    public String getName()
    {
        return(name);
    }    
    public void setType(Type _type)
    {
        type = _type;
    }
    public Type getType()
    {
        return(type);
    }  
    
    public Student getStudent(int _index)
    {
        return(students.get(_index));
    }
    public int getNumStudents()
    {
        return(students.size());
    }
    public int getStudents()
    {
        return(students.size());
    }
    public static void printNames()
    {
        System.out.println("===printNames===");
        for (Course temp : courses)
        {
            if(temp != null)
            {
                System.out.println(temp.getName());
            }
        }        
    }    
    public void printStudentGrades()
    {
        System.out.println("===printGradesOfStudents===");
        for (Student temp : students)
        {
                System.out.println(temp.getName() + " has a " + temp.grade);
        }        
    }
    public String toString()
    {
        return(name + " " + type + " " + period + " " + theTeacher.getName());
    }    
}
