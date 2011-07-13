public class AppV2 implements Callback2 {

    public static final int MINIMUM_MINISTRO_VERSION = 2;

    public static final int MINIMUM_LOADER_VERSION = 1;

    public static void main(String... args) throws Exception {
        // faked service look-up
        MinistroService service = MinistroService.INSTANCE;

        if (service.isCompatible(MINIMUM_MINISTRO_VERSION)) {
            // Would cause a NoSuchMethodError if called without
            // the above check.
    	    service.serve(new AppV2());
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

        Loader1 loader = createLoaderInstance(r);

        loader.doEverythingThatIsNecessaryForMe(r);
    }
  
    private static Loader1 createLoaderInstance(Result r) {
       try {
        // skipping the part where we create a new classloader. It would look like the following
        // ClassLoader cl = new UrlClassLoader(r.getLoaderPath());
        // and instead of the single-argument version of forName() one would use the one with the
        // classloader argument.
        System.out.println("class: " + r.getLoaderClassName());
        Class<Loader1> bl_class = (Class<Loader1>) Class.forName(r.getLoaderClassName());

        return bl_class.newInstance();
       } catch (Exception e) {
        e.printStackTrace();
        return null;
       }
    }

    public String getApplicationName() { return "App Version 2"; }

    public int getRequiredLoaderLevel() { return MINIMUM_LOADER_VERSION; }

}

