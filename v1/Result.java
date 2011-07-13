/** Early version of the Result object which are give to Applications by Ministro.
 *
 * Keeping binary compatibility is not strictly necessary but simplifies everyones life.
 */
public class Result {

    String loaderPath;

    String loaderClassName;

    public String getLoaderPath() {
        return loaderPath;
    }

    public String getLoaderClassName() {
        return loaderClassName;
    }

}
