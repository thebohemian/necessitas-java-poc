/** The public interface of Ministro. Here we actually see the Ministro1 version.
 *
 * This interface *MUST* evolve in a binary compatible way (=> adding methods)
 * throughout the different Ministro implementations.
 */
public interface MinistroService {

  public static final MinistroService INSTANCE = new Ministro1();

  boolean isCompatible(int ministroLevel);

  void serve(Callback1 cb);

}
