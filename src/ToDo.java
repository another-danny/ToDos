public class ToDo {
    String task;
    Status status;

    ToDo(Status stat){
        this.status = stat;
    }

    enum Status {
        New,
        Ongoing,
        Done
    }

}
