import java.util.List;
import java.util.ArrayList;

public class Ministro2 implements MinistroService {

  public Ministro2() {
    System.out.println("Ministro 2 - started");
  }

  public boolean isCompatible(int ministroLevel) {
    return ministroLevel <= 2;
  }

  public void serve(Callback1 cb) {
    System.out.println("serving a version 1 App");
    System.out.println("appname:" + cb.getAppName());

    // In this fictious example the Callback for version 1 apps does not
    // have support for different versions of the loader, hence no check.
    Result r = new Result();
    r.loaderPath = "n/a";
    r.loaderClassName = "BasicLoaderImplOfMinistro2";
    cb.setResult(r);
    cb.succeed();
  }

  public void serve(Callback2 cb) {
    System.out.println("serving a version 2 App");
    System.out.println("applicationName:" + cb.getApplicationName());
    System.out.println("requiredLoaderLevel:" + cb.getRequiredLoaderLevel());

    // Fictious example where we changed the working of the Callback2 interface
    // in a completely incompatible way.
    // * getAppName -> getApplicationName
    // * introduction of loader level
    // * sucess state is transmitted through Result object
    Result r = new Result();

    switch (cb.getRequiredLoaderLevel()) {
        case 1:
            r.loaderPath = "version-1-loader.jar";
            r.loaderClassName = "Loader1Impl";
            r.sharedLibraries = makeList(new String[] { "libFoo.so", "libBar.so", "libBaz.so" });
            r.bridgeLocation = "to/be/found/in/the/forest/bridge-4.8.jar";
            r.success = true;
            break;
        case 2:
            r.loaderPath = "version-2-loader.jar";
            r.loaderClassName = "Loader2Impl";
            r.sharedLibraries = makeList(new String[] { "libFoo2.so", "libBar3.so", "libBaz2.so" });
            r.bridgeLocation = "put/somewhere/completely/else/bridge-4.8-revised2.jar";
            r.success = true;
            break;
        default:
            r.success = false;
            break;
    }

    cb.finished(r);
  }
  
  static List<String> makeList(String... entries) {
    List<String> l = new ArrayList<String>();
    for (String e : entries) { l.add(e); }
    return l;
  }

}
