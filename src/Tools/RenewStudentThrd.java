package Tools;
public class RenewStudentThrd implements Runnable {
    public void run() {
        synchronized (this) {
            try {
                RenewStudent renewStudent = new RenewStudent();
                renewStudent.reloadJtable1();
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}