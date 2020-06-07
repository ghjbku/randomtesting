import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static String home;
    static List<Character> drives = new ArrayList<>();

    private static String getPathToSetFile() {
        System.out.println("\ngetpath function:");
        //this will get the users home, for example(C:/users/"UsersName"/)
        home = System.getProperty("user.home");
        File file = new File(System.getProperty("user.home"));
        System.out.println(file.getParent());
        File fil4 = new File(file.getParentFile().getParent());
        System.out.println("fil4 " + fil4.toString());
        return home; // returns the string that we just got(the path)
    }

    private static void check_op_system() {
        System.out.println(getPathToSetFile() + "\n\ncheck_op_system method:");
        String home_temp = System.getProperty("os.name");
        if (home_temp.startsWith("W")) {
            System.out.println("system name: " + home_temp);
            use_Drive();
            what_drives();
        } else {
            System.out.println("its not windows\n" + home_temp);

        }
    }

    private static File check_drive(String drive_Name) {
        File file = new File(drive_Name + ":\\");
        if (file.exists()) {
            return file;
        } else {
            System.out.println(drive_Name + " does not exist!");
            return null;
        }
    }

    private static void use_Drive() {
        if (check_drive("D") != null) {
            drives.add('D');
        }
        if (check_drive("E")!= null) {
            drives.add('E');
        }
        if (check_drive("F")!= null) {
            drives.add('F');
        }
        if (check_drive("H")!= null) {
            drives.add('H');
        }
        if (check_drive("I")!= null) {
            drives.add('I');
        }
    }

    private static void what_drives() {
        int iterator=0;
        System.out.println("\nDrives:");
        for (char i : drives) {
            System.out.println(iterator+". "+i);
            iterator++;
        }
    }

    private static void look_up_files(char drive_name){
        File file = new File(drive_name + ":\\");
        File[] files = file.listFiles();

        assert files != null;
        for (File file_ : files) {
            System.out.println(file_.getName());
        }
    }

    public static void main(String[] args) {
        check_op_system();

        for (char i:drives) {
            System.out.println("\nDrive "+i+":\n");
            look_up_files(i);
        }
    }
}
