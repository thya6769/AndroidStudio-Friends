package com.caqmei.friends;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by user on 15/12/26.
 */
public class FriendsContract {
    interface FriendsColumns {
        String FRIENDS_ID = "_id";
        String FRIENDS_NAME = "friends_name";
        String FRIENDS_EMAIL = "friends_email";
        String FRIENDS_PHONE = "friends_phone";

    }

    public static final String CONTENT_AUTHORITY = "org.example.android.friends.provider";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    private static final String PATH_FRIENDS = "friends";

    public static final String[] TOP_LEVEL_PATH ={
        PATH_FRIENDS
    };
    public static final Uri URI_TABLE = Uri.parse(BASE_CONTENT_URI.toString() + "/" + PATH_FRIENDS);

    public static class Friends implements FriendsColumns, BaseColumns{
        // content uri becomes BASE_CONTENT_URI + PATH_FRIENDS
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendEncodedPath(PATH_FRIENDS).build();
        public static final String CONTENT_TYPE = "vnd.anroid.cursor.dir/vnd." + CONTENT_AUTHORITY + ".friends";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd." + CONTENT_AUTHORITY + ".friends";
         //think of this as group of data, we are defining type of data

        public static Uri buildFriendUri(String friendID){
            return CONTENT_URI.buildUpon().appendEncodedPath(friendID).build();

        }
        public static String getFriendID(Uri uri){
            return uri.getPathSegments().get(1);
        }
    }
}
