package DAL;

import DTO.CD_DTO;
import Entity.CD;
import MyUtils.FileUtils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author giahu
 */
public final class CD_DAO {

    FileUtils u = new FileUtils();
    private final String connectionUrl = "jdbc:sqlserver://localhost;"
            + "databaseName=dbCDHouse;"
            + "encrypt=true;"
            + "trustServerCertificate=true;"
            + "user=sa;"
            + "password=112358";

    public CD_DAO() {
    }

    public ArrayList<CD_DTO> loadCD(String path) throws IOException, ClassNotFoundException {
        ArrayList<CD_DTO> temp = new ArrayList();
        ArrayList<CD> list = u.load(path);

        for (CD obj : list) {
            temp.add(obj.toDTO());
        }

        return temp;
    }

    public void saveCD(String path, ArrayList<CD_DTO> list) throws IOException {
        ArrayList temp = new ArrayList();
        for (CD_DTO obj : list) {
            temp.add(obj.toEntity());
        }
        u.save(path, temp);
    }

    public ArrayList<CD_DTO> loadFromSQL() throws NumberFormatException, SQLException {
        ArrayList<CD_DTO> temp = new ArrayList();
        ArrayList<CD> list = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(connectionUrl);
                Statement stmt = con.createStatement();) {
            String SQL = "SELECT * FROM CD";
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                list.add(new CD(rs.getString("Collection"),
                        Boolean.parseBoolean(rs.getString("Type")),
                        rs.getString("Title"),
                        Float.parseFloat(rs.getString("Price")),
                        rs.getString("ID"),
                        Integer.parseInt(rs.getString("Year")))
                );
            }

            for (CD obj : list) {
                temp.add(obj.toDTO());
            }

            return temp;
        }
    }

    public void writeToSQL(ArrayList<CD_DTO> list) {
        try (Connection con = DriverManager.getConnection(connectionUrl);
                Statement stmt = con.createStatement();) {
            String SQL = "drop table CD\n"
                    + "create table CD(\n"
                    + "	Collection nvarchar(10),\n"
                    + "	Type nvarchar(10),\n"
                    + "	Title nvarchar(100),\n"
                    + "	Price float,\n"
                    + "	ID nvarchar(10),\n"
                    + "	Year decimal,\n"
                    + "	primary key(ID))";
            stmt.executeUpdate(SQL);
            for (CD_DTO dto : list) {
                SQL = "insert into CD(Collection,Type,Title,Price,ID,Year)\n"
                        + "values('" + dto.toEntity().getCollName() + "','"
                        + dto.toEntity().isType() + "','"
                        + dto.toEntity().getTitle() + "',"
                        + dto.toEntity().getPrice() + ",'"
                        + dto.toEntity().getID() + "',"
                        + dto.toEntity().getYear() + ")";
                stmt.executeUpdate(SQL);
            }
        } // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
