package com.tish.utils;

import com.tish.models.TableRecord;
import com.tish.models.User;

public class CurrentDataUtils {

    private static User currentUser;
    private static TableRecord currentRecord;

    public static void setCurrentUser(User user) {
        currentUser = user;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static TableRecord getCurrentRecord() {
        return currentRecord;
    }

    public static void setCurrentRecord(TableRecord currentRecord) {
        CurrentDataUtils.currentRecord = currentRecord;
    }
}
