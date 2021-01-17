package org.jesperancinha.java11.crums.crum1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.AccessControlContext;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.security.SecurityPermission;
import java.util.function.Function;

import static org.jesperancinha.console.consolerizer.ConColor.BLUE;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGeneric;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedThrowableAndExit;

public class Crum1 {
    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Crum 1 - File permissions");

        final Function<String, String> f1 = (file) -> file;
        final Function<String, String> f2 = (file) -> {
            try (final var fos = new FileOutputStream(new File(file))) {
                final var oos = new ObjectOutputStream(fos);
                oos.writeUTF("You spin me round round baby round round like a record");
                oos.flush();
            } catch (IOException e) {
                printRedThrowableAndExit(e);
            } catch (AccessControlException e) {
                printRedGenericLn("This is expected! We are not allowing to write to file -> %s", e);
            }
            return "Ok!";
        };
        final String pathname = "/tmp/Crum31.txt";
        File f = new File(pathname);

        final SecurityManager securityManager = System.getSecurityManager();
        SecurityManager setSecurityManager = new SecurityManager() {
            @Override
            public void checkSecurityAccess(String target) {
                printGreenGenericLn(
                    "We are allowing the creation of an Access Control Context - createAccessControlContext");

            }
        };
        System.setSecurityManager(setSecurityManager);
        final Permission perm1 = new SecurityPermission("createAccessControlContext");
        final PermissionCollection permissionCollection = perm1.newPermissionCollection();
        permissionCollection.add(perm1);

        final Permission perm = new java.io.FilePermission(f.getPath(), "read");
        final PermissionCollection perms = perm.newPermissionCollection();
        perms.add(perm);
        perms.implies(perm);
        perms.setReadOnly();

        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                printOrangeGenericLn(f1.apply(pathname));
                printOrangeGenericLn(f2.apply(pathname));
                return null;
            }
        }, new AccessControlContext(new ProtectionDomain[] { new ProtectionDomain(null, perms),
            new ProtectionDomain(null, permissionCollection) }));

        try {
            System.setSecurityManager(securityManager);
        } catch (AccessControlException e) {
            printRedGeneric(
                "This is expected! We have changed permissions in such a way that we can no longer change the SecurityManqger during runtime. Safe! -> %s",
                e);
        }
        printGreenGenericLn(
            "Make sure to study this code. This is how you make sure to reduce privileges from a high privileged user on demand");
    }
}
