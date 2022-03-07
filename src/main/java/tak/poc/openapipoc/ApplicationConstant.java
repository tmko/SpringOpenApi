package tak.poc.openapipoc;

public interface ApplicationConstant {
    String CSRF = "csrf";
    String GSK = "gsk";
    String GSK_NOT_FOUND = "GskNoFound";

    String API_NAME = "poc";
    String API_VERSION = "v1";

    String CONTEXT_PATH     = "/" + API_NAME + "/" + API_VERSION;
    String CONTEXT_PATH_ANY = "/" + API_NAME + "/" + API_VERSION + "/*";
}
