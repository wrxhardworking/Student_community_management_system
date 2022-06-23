package OBJ;

public class Members {
     int id;
     String name;


    String sex;

     int age;
     String profesion;

     String hobby;

    @Override
    public String toString() {
        return "Members{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", profesion='" + profesion + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }





    public Members(int id,String name,String sex,int age,String profesion,String hobby)
    {
        this.id=id;
        this.name=name;
        this.sex=sex;
        this.age=age;
        this.profesion=profesion;
        this.hobby=hobby;
    }
    public int getId(){
        return  id;}

    public int getAge(){
        return age;}

    public String getName() {
        return name;
    }

    public String getHobby() {
        return hobby;
    }

    public String getProfesion() {
        return profesion;
    }
    public String getSex() {return sex;}


}
