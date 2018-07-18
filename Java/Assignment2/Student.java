public class Student{
    private String name;
    private String major;
    private Double gpa;

    public Student(){

    }

    public Student(String iName, String iMajor, Double iGPA){
        name = iName;
        major = iMajor;
        setGPA(iGPA);
    }

    public void setName(String setName){
        name = setName;
    }
    public String getName(){
        return name;
    }

    public void setMajor(String setMajor){
        major = setMajor;
    }
    public String getMajor(){
        return major;
    }

    public void setGPA(Double setGPA){
        try{
            if (0.0 <= setGPA && setGPA <= 4.0){
                gpa = setGPA;
            }
            else {
                throw new GPAOutOfBoundsException("Invalid input for GPA." + "\n" + "Double-type input != 0.0 <= GPA && GPA <= 4.0");
            }
        }
        catch(GPAOutOfBoundsException gpaException){
            System.out.println(name + " " + gpaException);
            System.exit(0);
        }
    }
    public Double getGPA(){
        return gpa;
    }

    public boolean equals(Student inputObject){
        if (inputObject.name.equals(name) && inputObject.major.equals(major) && inputObject.gpa.equals(gpa)){
            return true;
        }
        else{
            return false;
        }
    }

    public String toString(){
        String gpaString = Double.toString(gpa);

        return "Name: " + name + "\n" + "Major: " + major + "\n" + "GPA: " + gpaString;
    }

    protected static class GPAOutOfBoundsException extends Exception {
        private static final long serialVersionUID = 000001;

        public GPAOutOfBoundsException () {

        }

        public GPAOutOfBoundsException (String message) {
            super ("Invalid input for GPA." + "\n" + "Double-type input != 0.0 <= GPA <= 4.0");
        }

        public GPAOutOfBoundsException (Throwable cause) {
            super (cause);
        }

        public GPAOutOfBoundsException (String message, Throwable cause) {
            super (message, cause);
        }
    }

    public static void main(String[] args){
        Student Jacob = new Student("Jacob Sanders", "Computer Science", 3.9);
        Student Jess = new Student("Jessica Sanders", "Art", 3.1);
        Student Ryan = new Student("Jacob Sanders", "Computer Science", 2.9);
        Student Bill = Jacob;
        System.out.println(Jacob.toString());
        System.out.println(Jacob.equals(Bill));
    }
}
