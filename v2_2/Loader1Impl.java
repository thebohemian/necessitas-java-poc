import java.util.List;

public class Loader1Impl implements Loader1 {

    public void doEverythingThatIsNecessaryForMe(Result r) {
        System.out.println("Loader1Impl is in charge!");

        for (String sl : r.getSharedLibraries()) {
            System.out.println("loading shared library: " + sl);
        }

        System.out.println("loading bridge: " + r.getBridgeLocation());
    }
}
