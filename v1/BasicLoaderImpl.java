/* Implementation of a BasicLoader. The actual class can lie within the Ministro jar
 * or separately. The app should not care. We hand it over a path that it must process.
 *
 * The 'doStuffForMe' method is a placeholder for all kinds of things a Loader implementation
 * needs to do for a Version1 app.
 */
public class BasicLoaderImpl implements BasicLoader {

    public BasicLoaderImpl() {
        // The existance of a public no-arg constructor is a *MUST* for every loader implementation
        // because then we can use 'Class<BasicLoader.newInstance()'.
    }

    public void doStuffForMe() {
        System.out.println("BasicLoaderImpl: doing complicated stuff in the App's process");
    }

}
