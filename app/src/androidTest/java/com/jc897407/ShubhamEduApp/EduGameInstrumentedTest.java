package com.jc897407.ShubhamEduApp;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.jc897407.ShubhamEduApp.helper.DBHelper;
import com.jc897407.ShubhamEduApp.helper.QuestionImageManager;
import com.jc897407.ShubhamEduApp.helper.Utility;

import java.util.Arrays;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class EduGameInstrumentedTest {
    Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
    @Test
    public void useAppContext() {
        // Context of the app under test.
        //assertEquals("com.jc897407.sameduapp", appContext.getPackageName());
//        testQuestionImageManager();
        testDB();
//        testLoadUsers();
        test_shuffle_array();
    }

    private void test_shuffle_array() {
        int[] intArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Utility.shuffleIntArray(intArray);
        Log.i("testArray", Arrays.toString(intArray));
    }


    private void testDB() {
        DBHelper dbHelper = new DBHelper(appContext);
        // Clear DB Table
        dbHelper.getWritableDatabase().execSQL("delete from " + DBHelper.TABLE_NAME);
        dbHelper.insertPlayer("Sam", 120, "1", 20);
        Cursor cursor = dbHelper.getAllPlayers();
        if (cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            String username = cursor.getString(cursor.getColumnIndex(DBHelper.USERNAME_COL));
            String score = cursor.getString(cursor.getColumnIndex(DBHelper.SCORE_COL));
            String duration = cursor.getString(cursor.getColumnIndex(DBHelper.DURATION_COL));
            String level = cursor.getString(cursor.getColumnIndex(DBHelper.LEVEL_COL));
            assertEquals("Sam", username);
            assertEquals("20", score);
            assertEquals("120", duration);
            assertEquals("1", level);
        }
    }

    private void testQuestionImageManager() {
        String levelStr = "1";
        QuestionImageManager questionImageManager = new QuestionImageManager(levelStr, appContext.getAssets());
        assertEquals("55", questionImageManager.getAnswer(3));
    }
}