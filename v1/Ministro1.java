/** Ministro1 implementation. It can only handle Application of Version1 however
 *  the call most basic call interface is compatible so that higher version applications
 *  can always minimally interact with Ministro1.
 *
 * The only method that is guaranteed to exist is 'isCompatible' and Apps must call it first.
 */
public class Ministro1 implements MinistroService {

  public Ministro1() {
    System.out.println("Ministro 1 - started");
  }

  public boolean isCompatible(int ministroLevel) {
    return ministroLevel == 1;
  }

  public void serve(Callback1 cb) {
    System.out.println("appname:" + cb.getAppName());
    // In this fictious example the Callback for version 1 apps does not
    // have support for different versions of the loader, hence no check.
    Result r = new Result();
    r.loaderPath = "n/a";
    r.loaderClassName = "BasicLoaderImpl";
    cb.setResult(r);
    cb.succeed();
  }
  

}
