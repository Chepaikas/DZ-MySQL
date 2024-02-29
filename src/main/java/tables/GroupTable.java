package tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import db.MySQLConnector;
import objects.GroupStudent;
import java.util.ArrayList;


public class GroupTable extends AbsTable {
    MySQLConnector connector = new MySQLConnector();
    private final static String TABLE_NAME = "GroupStudent";

    public GroupTable() {
        super(TABLE_NAME);
        columns = new HashMap<>();
        columns.put("groupId", "bigint");
        columns.put("groupName", "varchar(25)");
        columns.put("curatorId", "bigint");
        create();
    }

    public ArrayList<GroupStudent> selectAllGroup() {
        String sqlQuery = String.format("SELECT * FROM %s", tableName);
        return selectByQuery(sqlQuery);
    }

    private ArrayList<GroupStudent> selectByQuery(String sqlQuery) {
        ArrayList<GroupStudent> groupStudents = new ArrayList<>();
        ResultSet rs = db.executeRequestWithAnswer(sqlQuery);
        try {
            while (rs.next()) {
                groupStudents.add(new GroupStudent(
                        rs.getLong("groupId"),
                        rs.getString("groupName"),
                        rs.getLong("curatorId")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return groupStudents;
    }

    public void insertGroup(GroupStudent groupStudent) {
        String sqlQuery = String.format("INSERT INTO %s (groupId, groupName, curatorId) VALUES (%d, '%s', %d)",
                tableName, groupStudent.getGroupID(), groupStudent.getName(), groupStudent.getCuratorID());
        db.executeRequest(sqlQuery);
    }

    public void printRezultExchang(){
        try {
            ResultSet updateResultSet = connector.executeRequestWithAnswer("SELECT groupStudent.groupName, " +
                    "curator.curatorFio FROM groupStudent JOIN curator ON groupStudent.curatorId = curator.curatorId;");
            while (updateResultSet.next()) {
                String groupName = updateResultSet.getString("groupName");
                String curatorFio = updateResultSet.getString("curatorFio");

                System.out.println("Группа " + groupName + "  ФИО куратора  " + curatorFio);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}


