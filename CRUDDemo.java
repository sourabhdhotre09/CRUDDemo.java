import java.util.*;

class Student {
    private int s_id;
    private String s_name;
    private String s_address;

    Student(int s_id, String s_name, String s_address){
        this.s_id = s_id;
        this.s_name = s_name;
        this.s_address = s_address;
    }

    public int getSId(){
        return s_id;
    }
    public String getAddress(){
        return s_address;
    }
    public String getSName(){
        return s_name;
    }

    public String toString(){
        return s_id+"  "+s_name+"  "+s_address;
    }

}
class  CRUDDemo{
    public static void main(String[] args) {
        List<Student> c= new ArrayList<Student>();
        Scanner s = new Scanner(System.in);
        Scanner s1= new Scanner(System.in);
        int ch;
        do{
            System.out.println("1.INSERT");
            System.out.println("2.DISPLAY");
            System.out.println("3.SEARCH");
            System.out.println("4.DELETE");
            System.out.println("5.UPDATE");
            System.out.print("Enter Your choice: ");
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("\nEnter Student Id: ");
                    int id= s.nextInt();
                    System.out.print("Enter Student name: ");
                    String sname= s1.nextLine();
                    System.out.print("Enter Student Address: ");
                    String address= s1.nextLine();

                    c.add(new Student(id, sname, address));
                break;

                case 2:
                    System.out.println("-------------------------------------------");
                    java.util.Iterator<Student> i= c.iterator();
                    while (i.hasNext()) {
                        Student e = i.next();
                        System.out.println(e);
                    }
                    
                    System.out.println("-------------------------------------------");
                break;

                case 3:
                    Boolean found = false;
                    System.out.print("\nEnter Student No. to Search: ");
                    id = s.nextInt();
                    System.out.println("-------------------------------------------");
                    i= c.iterator();
                    while (i.hasNext()) {
                        Student e = i.next();
                        if(e.getSId()==id){
                            System.out.println(e);
                            found= true;
                        
                        }
                    }

                    if (!found) {
                        System.out.println("Record not found");
                    }
                
                    System.out.println("-------------------------------------------");
                break;

                case 4:
                    found = false;
                    System.out.print("\nEnter Student No. to Delete: ");
                    id = s.nextInt();
                    System.out.println("-------------------------------------------");
                    i= c.iterator();
                    while (i.hasNext()) {
                        Student e = i.next();
                        if(e.getSId()==id){
                            i.remove();
                            found= true;          
                        }
                    }

                    if (!found) {
                        System.out.println("Record not found");
                    }else{
                        System.out.println("Record is deleted Successfully");
                    }
                
                    System.out.println("-------------------------------------------");
                break;

                case 5:
                    found = false;
                    System.out.print("\nEnter Student No. to Update: ");
                    id = s.nextInt();
                    ListIterator<Student> li = c.listIterator();
                    while (li.hasNext()) {
                        Student e = li.next();
                        if(e.getSId()==id){
                            System.out.print("Enter new name: ");
                            sname = s1.nextLine();

                            System.out.print("Enter the Address: ");
                            address = s1.nextLine();
                            li.set(new Student(id, sname, address));
                            found= true;          
                        }
                    }
                    System.out.println("-------------------------------------------");
                    if (!found) {
                        System.out.println("Record not found");
                    }else{
                        System.out.println("Record is updated Successfully");
                    }
                
                    System.out.println("-------------------------------------------");
                break;

            }
        }while(ch!=0);

        s.close();
        s1.close();
    }
}
