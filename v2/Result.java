/** The Result object carries information from Ministro to the application.
 *
 * This variant of the class is binary compatible to Ministro1. This is good
 * practice but can be violated if absolutely necessary.
 */
import java.util.List;

public class Result {

    String loaderPath;

    String loaderClassName;

    // Every field below is new in Ministro2
    boolean success;
    
    List<String> sharedLibraries;

    String bridgeLocation;

    public String getLoaderPath() {
        return loaderPath;
    }

    public String getLoaderClassName() {
        return loaderClassName;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<String> getSharedLibraries() {
        return sharedLibraries;
    }

    public String getBridgeLocation() {
        return bridgeLocation;
    }

}
