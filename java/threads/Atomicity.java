import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Atomicity {
    private AtomicBoolean atomicBoolean;

    public static void main(String[] args) {
        Atomicity atomicity = new Atomicity();
        atomicity.logicOnAtomicInParralel();
    }

    private void logicOnAtomicInParralel() {
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.stream().parallel().forEach(n -> {
            atomicBoolean.set(false);   //all points to same point
        });
    }
}
