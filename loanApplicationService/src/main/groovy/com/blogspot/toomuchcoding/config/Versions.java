package com.blogspot.toomuchcoding.config;

public final class Versions {
    private Versions() {
        throw new UnsupportedOperationException("Can't instantiate a utility class");
    }

    private static final String APP_NAME = "loanApplicationService";
    private static final String VND_PREFIX = "application/vnd";
    private static final String JSON_TYPE_SUFFIX = "+json";

    private static final String VERSION_1 = "v1";
    public static final String LOAN_APPLICATION_SERVICE_JSON_VERSION_1 = VND_PREFIX + "." + APP_NAME + "." + VERSION_1 + JSON_TYPE_SUFFIX;

    private static final String FRAUD_APP_NAME = "fraudDetectionService";
    public static final String FRAUD_SERVICE_JSON_VERSION_1 = VND_PREFIX + "." + FRAUD_APP_NAME + "." + VERSION_1 + JSON_TYPE_SUFFIX;
}
