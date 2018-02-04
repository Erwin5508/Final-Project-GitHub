import android.content.Context;
import android.util.Pair;

import com.example.JokeSmith;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertEquals;

/**
 * Created by ErwinF on 2/4/2018.
 */

public class BackendTest {

    private String string;
    private void getString(String string) {
        this.string = string;
    }

    @Test
    public void verifyBackendWorks() {
        EndpointsAsyncTask task = new EndpointsAsyncTask() {
            @Override
            protected void onPostExecute(String result) {
                getString(result);
            }
        };
        task.execute(new Pair<Context, String>(null, "Manfred"));
        try {
            new CountDownLatch(1).await(5, TimeUnit.SECONDS);
        } catch (Exception e) {
            //do nothing
        }
        String currentJoke = new JokeSmith().getCurrentJoke();

        assertEquals(string.equals(currentJoke), true);
    }
}
