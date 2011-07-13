/**
 * 2nd generation App (implements Callback2) exactly
 * like in 'app_v2' however it requires a Loader2 implementation.
 *
 * For this reason neither Ministro1 nor Ministro2 from the 'v2' folder
 * can satisfy the App start. For Ministro1 it will be the app knowing
 * that Ministro is too old.
 * In the second case the older Ministro2 will notice that it cannot satisfy
 * the request for the 2nd generation Loader and it will notice the application
 * through the Result object that it cannot let it start.
 *
 * However with the newer Ministro2 the 2nd generation Loader is supported
 * and will allow its instantiation.
 *
 * Notice how the Loader2 interface allows for more flexibility from the Applications
 * side when starting.
 */
import java.util.List;
import java.util.ArrayList;

public class AppV2_2 implements Callback2 {

    public static final int MINIMUM_MINISTRO_VERSION = 2;

    public static final int MINIMUM_LOADER_VERSION = 2;

    public static void main(String... args) throws Exception {
        // faked service look-up
        MinistroService service = MinistroService.INSTANCE;

        if (service.isCompatible(MINIMUM_MINISTRO_VERSION)) {
            // Would cause a NoSuchMethodError if called without
            // the above check.
    	    service.serve(new AppV2_2());
        } else {
    	    System.out.println("go and update Ministro!");
        }
    }

    public void finished(Result r) {
        if (!r.isSuccess()) {
            System.out.println("Ministro said we cannot start. :(");
            System.exit(-1);
        }
        System.out.println("Ministro said we're ready to rock'n'roll.");

        Loader2 loader = createLoaderInstance(r);

        // New Loader interface gives more flexibility:
        loader.loadSharedLibs(r.getSharedLibraries());
        // App adds own list of shared libs to load.
        List<String> moreSL = new ArrayList<String>();
        moreSL.add("libMySecretOwnStuff.so");
        loader.loadSharedLibs(moreSL);

        loader.loadBridge(r.getBridgeLocation());
    }
  
    private static Loader2 createLoaderInstance(Result r) {
       try {
        // skipping the part where we create a new classloader. It would look like the following
        // ClassLoader cl = new UrlClassLoader(r.getLoaderPath());
        // and instead of the single-argument version of forName() one would use the one with the
        // classloader argument.
        System.out.println("class: " + r.getLoaderClassName());
        Class<Loader2> bl_class = (Class<Loader2>) Class.forName(r.getLoaderClassName());

        return bl_class.newInstance();
       } catch (Exception e) {
        e.printStackTrace();
        return null;
       }
    }

    public String getApplicationName() { return "App Version 2"; }

    public int getRequiredLoaderLevel() { return MINIMUM_LOADER_VERSION; }

}

