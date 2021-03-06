package org.jesperancinha.java11.jdbc.commit;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;

/**
 * Remember that autocommit is always true by default
 */
public class JDBCCommitRunner {
    public static void main(String[] args) {
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.
                    getConnection("jdbc:h2:mem:", "sa", "");
            System.out.printf("Connection: %s / %s\n", conn.getMetaData().getDatabaseProductName(), conn.getCatalog());
            System.out.printf("Current auto-commit setting: %s\n", conn.getAutoCommit());
            conn.close();
        } catch (Exception e) {
            RED.printThrowableAndExit(e);
        }
    }
}
