package Controller;

import Model.Contract;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContractTestGetter_DBMS {
    private final Database_Controller dbManager;
    private final String QUERY_CONTRACT_GOOD = "SELECT * FROM Contract_Test_GOOD";
    private final String QUERY_CONTRACT_PENDANT = "SELECT * FROM Contract_Test_BAD_Bill";
    private final String QUERY_CONTRACT_CLOSED = "SELECT * FROM Contract_Test_BAD_Closed";
    
    public ContractTestGetter_DBMS() throws SQLException{
        dbManager = Database_Controller.getDbManager();
    }
    public Contract getValidContract() throws SQLException{
        PreparedStatement statement = dbManager.getStatement(QUERY_CONTRACT_GOOD);
        ResultSet rs = dbManager.doQuery(statement);
        rs.first();
        return new Contract(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getInt(20));
    }
    public Contract getClosedContract() throws SQLException{
        PreparedStatement statement = dbManager.getStatement(QUERY_CONTRACT_CLOSED);
        ResultSet rs = dbManager.doQuery(statement);
        rs.first();
        return new Contract(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getInt(20));
    }
    public Contract getPendantContract() throws SQLException{
        PreparedStatement statement = dbManager.getStatement(QUERY_CONTRACT_PENDANT);
        ResultSet rs = dbManager.doQuery(statement);
        rs.first();
        return new Contract(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getInt(20));
    }
}
