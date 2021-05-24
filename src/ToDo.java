public class ToDo {
    String task;
    Status status;

    ToDo(Status stat){
        this.status = stat;
    }

    public enum Status {
        New,
        Ongoing,
        Done
    }

}
