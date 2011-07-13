/** This is the interface of an application to Ministro1. Calls will go
 * through Android's IPC mechanism.
 *
 * Each application implements this once.
 *
 * Throughout the Proof-Of-Concept we will break the compatibility of
 * this interface willingly.
 */ 
public interface Callback1 {

  String getAppName();

  void setResult(Result result);

  void fail();

  void succeed();

}
