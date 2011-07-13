import java.util.List;

public class Loader2Impl implements Loader2 {

    public void loadSharedLibs(List<String> sharedLibraries) {
        for (String sl : sharedLibraries) {
            System.out.println("loading shared library: " + sl);
        }
    }

    public void loadBridge(String bridgeLocation) {
        System.out.println("loading bridge: " + bridgeLocation);
    }

}
