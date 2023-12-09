package util;

public class SessionManagerUtil {
    private static long authenticatedUserId = -1;

    public static void authenticateUser(long userId) {
        authenticatedUserId = userId;
    }

    public static long getAuthenticatedUserId() {
        return authenticatedUserId;
    }

    public static void clearSession() {
        authenticatedUserId = -1;
    }
}
