public interface MinistroService {

  public static final MinistroService INSTANCE = new Ministro2();

  boolean isCompatible(int ministroLevel);

  void serve(Callback1 cb);

  void serve(Callback2 cb);

}
