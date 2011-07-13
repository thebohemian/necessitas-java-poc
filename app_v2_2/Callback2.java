/* This interface is exactly the same as the one in the 'v2' folder. It
   will be part of the App because that is the way the Android IPC stuff
   works.
*/
public interface Callback2 {

  String getApplicationName();

  int getRequiredLoaderLevel();

  void finished(Result result);

}
