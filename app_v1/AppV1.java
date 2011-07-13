/**
 * This is a version 1 app. It is willingly written in a way that it does not support
 * different loader versions (This will be introduced by an incompatible change in version 2 apps).
 * Nevertheless the example will show that newer Ministros can handle older applications.
 * 
 * This program should successfully start.
*/
public class AppV1 {

  public static void main(String... args) throws Exception {

    // faked service look-up
    MinistroService service = MinistroService.INSTANCE;

    if (service.isCompatible(1)) {
        service.serve(new Callback1Impl());
    } else {
	    System.out.println("go and update Ministro!");
    }
  }

  static void succeed(Result r) {
    System.out.println("AppV1's start was successful ...");

    BasicLoader loader = createLoaderInstance(r);
    if (loader == null) {
        // Super-epic fail. The classname information *must* always lead to success
        System.out.println("Unable to create BasicLoader instance");
        System.exit(-1);
    }

    // placeholder method that normally would do complicated things for the app.
    loader.doStuffForMe();
  }

  private static BasicLoader createLoaderInstance(Result r) {
   try {
    // skipping the part where we create a new classloader. It would look like the following
    // ClassLoader cl = new UrlClassLoader(r.getLoaderPath());
    // and instead of the single-argument version of forName() one would use the one with the
    // classloader argument.
    System.out.println("class: " + r.getLoaderClassName());
    Class<BasicLoader> bl_class = (Class<BasicLoader>) Class.forName(r.getLoaderClassName());

    return bl_class.newInstance();
   } catch (Exception e) {
    e.printStackTrace();
    return null;
   }
  }

  private static class Callback1Impl implements Callback1 {
    Result result;

    public String getAppName() { return "App Version 1"; }

    public void setResult(Result result) { this.result = result; }

    public void succeed() { AppV1.succeed(result); };

    public void fail() { System.out.println("AppV1's start was an epic fail :( ..."); };

  }

}
