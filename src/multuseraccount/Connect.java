
package multuseraccount;

import java.sql.Connection;
import java.sql.DriverManager;


public class Connect {

    // FOR THE DATABASE
    public static Connection connectDB() {
// FIRST, LETS CREATE OUR DATABASE
        try {

            Class.forName("com.mysql.jdbc.Driver");

            Connection connect
                    = DriverManager.getConnection("jdbc:mysql://localhost/multiuser", "root", ""); 

            return connect;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
