package com.solvd.hospital;
import com.solvd.hospital.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.plaf.nimbus.State;
import javax.xml.transform.Result;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    private static final Logger LOG = LogManager.getLogger(App.class);

    public static void main(String[] args) {

            try (Connection connection = ConnectionPool.getInstance().getConnection()){
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from users");

                if (connection != null) {
                    LOG.info("You are inside now");
                } else {
                    LOG.info("You did not Connect to the server");
                }
                while (rs.next()) {
                    LOG.info(rs.getString("name"));
                }
                rs.close();
                st.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ConnectException e) {
                e.printStackTrace();
            } finally {
    }
    }


}





