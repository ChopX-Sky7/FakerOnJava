import java.util.Scanner;

public class QueryBuilder {
    private final String CREATE_DATABASE = "CREATE DATABASE";
    private final String INSERT_INTO = "INSERT INTO";
    //private int ID = 0;
    private String fName = "";
    private String Surname = "";
    private String Secname = "";
    private String queryInfo = "";

    private String query = "";

    private Generator gen = new Generator();
    private Scanner in = new Scanner(System.in);

    private String getTableName() {
        System.out.println("Введите название таблицы");
        String tname = in.nextLine();
        return tname;
    }

    private String getColumns() {
        System.out.println("Введите количество столбцов");
        int count = in.nextInt();
        String cols = "";
        String s = "";
        for (int i = 0; i < count; i++) {
            System.out.println("Введите название столбца");
            s = in.nextLine();
            cols = cols + s;
        }
        return cols;
    }

    private String getQueryInfo() {
        System.out.println("Введите пол пользователя");
        String gender = "";
        gender = in.nextLine();
        switch (gender) {
            case "M":
                this.fName = gen.pickMaleFirstName();
                this.Secname = gen.pickMaleSecname();
                this.Surname = gen.pickMaleSurname();
                this.queryInfo = "(" + this.fName + "," + this.Surname + "," + this.Secname + ")";
                break;
            case "F":
                this.fName = gen.pickMaleFirstName();
                this.Secname = gen.pickMaleSecname();
                this.Surname = gen.pickMaleSurname();
                this.queryInfo = "(" + this.fName + "," + this.Surname + "," + this.Secname + "," + ")";
                break;
            default:
                queryInfo = "";
                System.out.println("Введен неверный символ");
        }
        return queryInfo;
    }

    protected String getInsertQuery() {
        String tname = getTableName();
        String cols = getColumns();
        getQueryInfo();
        query = INSERT_INTO + "`" + tname + "`" + "(" + cols + ")" + "VALUES" + queryInfo + ";";
        return query;
    }


    //INSERT INTO `test` (`id`, `first_name`, `last_name`, `sec_name`) VALUES ('1', 'qwe', 'qwe', 'qwe');
}
