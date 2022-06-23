package OBJ;

public class Clubs {

    int id;
    String club;
    String clubMesg;
    public int getId() {
        return id;
    }

    public String getClub() {
        return club;
    }

    public String getClubMesg() {
        return clubMesg;
    }

    @Override
    public String toString() {
        return "Clubs{" +
                "id=" + id +
                ", club='" + club + '\'' +
                ", clubMesg='" + clubMesg + '\'' +
                '}';
    }



    public Clubs(int id,String club,String clubMesg)
    {
        this.id=id;
        this.club=club;
        this.clubMesg=clubMesg;
    }
}
