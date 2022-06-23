package Tools;
public class RenewClubsThrd implements Runnable{
    @Override
    public void run() {
        synchronized (this){
            try {
                RenewClubs renewClubs = new RenewClubs();
                renewClubs.reloadJTable();
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
