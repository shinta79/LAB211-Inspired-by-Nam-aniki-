
import BLL.CD_BUS;
import DTO.CD_DTO;
import GUI.main.MainWindow;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author giahu
 */
public class NewClass {

    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        CD_BUS bus = new CD_BUS();
        String connectionUrl = "jdbc:sqlserver://localhost;"
                + "databaseName=dbCDHouse;"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "user=sa;"
                + "password=112358";

        fileChooser.setCurrentDirectory(new File("."));
        int response = fileChooser.showOpenDialog(null);

        if (response == JFileChooser.APPROVE_OPTION) {
            try {
                String pathOpen = fileChooser.getSelectedFile().getAbsolutePath();
                bus.loadData(pathOpen);
//                bus.getList().get(17).setID("18");
//                bus.saveData(pathOpen);

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
                    for (CD_DTO dto : bus.getList()) {
                        SQL = "insert into CD(Collection,Type,Title,Price,ID,Year)\n"
                                + "values('" + dto.toEntity().getCollName() + "','"
                                + dto.toEntity().isType() + "','"
                                + dto.toEntity().getTitle() + "',"
                                + dto.toEntity().getPrice() + ",'"
                                + dto.toEntity().getID() + "',"
                                + dto.toEntity().getYear() + ")";
                        stmt.executeUpdate(SQL);
                    }
                    // Iterate through the data in the result set and display it.
                    {

                    }
                } // Handle any errors that may have occurred.
                catch (SQLException e) {
                    e.printStackTrace();
                }

//                for (CD_DTO dto : bus.getList()) {
//                    System.out.println("insert into CD(Collection,Type,Title,Price,ID,Year)\n"
//                            + "values('" + dto.toEntity().getCollName() + "','"
//                            + dto.toEntity().isType() + "','"
//                            + dto.toEntity().getTitle() + "',"
//                            + dto.toEntity().getPrice() + ",'"
//                            + dto.toEntity().getID() + "',"
//                            + dto.toEntity().getYear() + ")");
//                }
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
