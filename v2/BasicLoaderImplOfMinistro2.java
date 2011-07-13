/** This is a slightly modified version of Ministro1' BasicLoaderImpl. The reason is to show
 * how a change of Ministro can also affect old applications even though they have absolutely
 * no version choice capabilities.
 */
public class BasicLoaderImplOfMinistro2 implements BasicLoader {

    public BasicLoaderImplOfMinistro2() {
        // The existance of a public no-arg constructor is a *MUST* for every loader implementation.
    }

    public void doStuffForMe() {
        System.out.println("BasicLoaderImplOfMinistro2: doing complicated stuff in the App's process");
        System.out.println("BasicLoaderImplOfMinistro2: but hence it was Ministro2 who served me the app\n got a better BasicLoader implementation this time.");
    }

}
