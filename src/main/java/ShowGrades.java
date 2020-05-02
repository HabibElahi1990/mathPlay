public class ShowGrades {
    public static void showGrades(String name){
        FileAction fileAction=new FileAction();
        fileAction.getFile(name);
    }
}
