package sqlparsing;
public class StartApplication {
    public static void main(String[] args) {
        String fileWay = "/home/rustymattok/MyGit/lesson7/src/main/java/sqlparsing/files/app.properties";
        QuartzJob quartzJob = new QuartzJob(new DBPropereties(fileWay));
        quartzJob.startApplication();
    }
}
