import android.content.Context;
import android.util.Log;
import android.util.Pair;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertEquals;

/**
 * Created by ErwinF on 2/2/2018.
 */

public class AsynctaskTest {

    private String string;
    private void getString(String string) {
        this.string = string;
    }

    @Test
    public void verifyAsyncResponse() {
        try {
            EndpointsAsyncTask task = new EndpointsAsyncTask() {
                @Override
                protected void onPostExecute(String result) {
                    getString(result);
                }
            };
            task.execute(new Pair<Context, String>(null, "Manfred"));
            new CountDownLatch(1).await(5, TimeUnit.SECONDS);
            assertEquals(string.isEmpty(), false);

        } catch (Exception e) {
            Log.e("AsynctaskTest", "*******" + e.toString() + "*******");
            assertEquals(false, true);
        }

    }
}
