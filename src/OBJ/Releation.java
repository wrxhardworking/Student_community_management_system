package OBJ;

public class Releation {
    public int getClub_Id() {
        return Club_Id;
    }

    public int getMember_Id() {
        return Member_Id;
    }

    int Club_Id;
    int Member_Id;

    public Releation(int club_Id, int member_Id) {
        Club_Id = club_Id;
        Member_Id = member_Id;
    }

    public void setClub_Id(int club_Id) {
        Club_Id = club_Id;
    }

    public void setMember_Id(int member_Id) {
        Member_Id = member_Id;
    }
}
