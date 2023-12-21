package me.sathish.bank.utils;

public final class AppConstants {
    private AppConstants() {}

    public static final String PROFILE_PROD = "prod";
    public static final String PROFILE_NOT_PROD = "!" + PROFILE_PROD;
    public static final String PROFILE_TEST = "test";
    public static final String PROFILE_NOT_TEST = "!" + PROFILE_TEST;
    public static final String DEFAULT_PAGE_NUMBER = "0";
    public static final String DEFAULT_PAGE_SIZE = "10";
    public static final String DEFAULT_SORT_BY = "id";
    public static final String DEFAULT_SORT_DIRECTION = "asc";
    public static final String SAVINGS = "SathishBankSavingsAccount";
    public static final String ADDRESS = "6000 American Pkwy, Madison WI 53590";
    public static final String STATUS_201 = "201";
    public static final String MESSAGE_201 = "SB- Account created successfully";
    public static final String STATUS_200 = "200";
    public static final String MESSAGE_200 = "SB- Request processed successfully";
    public static final String STATUS_417 = "417";
    public static final String MESSAGE_417_UPDATE =
            "SB- Update failed. Please try again or contact support";
    public static final String MESSAGE_417_DELETE =
            "SB- Delete failed. Please try again or contact support";
}
