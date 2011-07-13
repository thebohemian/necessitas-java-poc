/** This is the interface for a Loader in Ministro1. It is called basic
 * because I want to show an extreme example where we have no versioning
 * support in this early implementation.
 * 
 * The real implementation will have versioning from the beginning! This example just
 * shows that we can still be quite flexible.
 *
 * This interface will be known to Version1 applications.
 */
public interface BasicLoader {

    void doStuffForMe();

}
