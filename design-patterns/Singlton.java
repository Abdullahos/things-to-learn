public class Singlton {
    private static volatile Singlton singlton;
    private String data;

    private Singlton(String data) {
        this.data = data;
    }

    public Singlton getSingltonInstance(String data) {
        if (singlton == null)   //to prevent unnecessary locking
            synchronized (Singlton.class) { //to prevent more than one thread to access this block at the same time
            if (singlton == null) {
                return new Singlton(data);
            }
        }
        return singlton;
    }

    public String getData() {
        return data;
    }
}
