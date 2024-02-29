package objects;


public class GroupStudent {
    private long groupID, curatorID;
    private String name;

    public GroupStudent(long groupID, String name, long curatorID) {
        this.groupID = groupID;
        this.name = name;
        this.curatorID = curatorID;

    }

    public long getGroupID() {
        return groupID;
    }

    public void setGroupID(long groupID) {
        this.groupID = groupID;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCuratorID() {
        return curatorID;
    }

    public void setCuratorID(long curatorID) {
        this.curatorID = curatorID;
    }

    public String toString() {
        return "Group | " + "groupID = " + groupID + " | name - "
                + name  + " | curatorID = " + curatorID + ' ';

    }
}
