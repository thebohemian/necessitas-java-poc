import java.util.List;

public interface Loader2 {

    void loadSharedLibs(List<String> sharedLibraries);
    void loadBridge(String bridgeLocation);
}
