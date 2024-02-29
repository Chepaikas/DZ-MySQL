package objects;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Curator {
    private long curatorID;
    private String curatorFio;

    public Curator(long curatorID, String curatorFio) {
        this.curatorID = curatorID;
        this.curatorFio = curatorFio;
    }

    public long getCuratorID() {
        return curatorID;
    }

    public void setCuratorID(long curatorID) {

        this.curatorID = curatorID;
    }

    public String getCuratorFio() {
        return curatorFio;
    }

    public void setCuratorFio(String curatorFio) {
        this.curatorFio = curatorFio;
    }
    public String toString() {
        return "Curator | " +  "curatorID = " + curatorID +
                " | curatorFio - " + curatorFio + ' ';
    }

}
