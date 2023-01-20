package edu.ucsd.cse110.lab2;

import static org.junit.Assert.assertEquals;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class BetterMainActivityTest {
    //@Rule
    //public ActivityScenarioRule rule = new ActivityScenarioRule<>(MainActivity.class);
    @Test
    public void test_one_plus_one_equals_two() {
        var rule = ActivityScenario.launch(MainActivity.class);
        rule.moveToState(Lifecycle.State.CREATED);
        rule.moveToState(Lifecycle.State.STARTED);

        rule.onActivity(a -> {
            Button one = a.findViewById(R.id.btn_one);
            Button plus = a.findViewById(R.id.btn_plus);
            Button equals = a.findViewById(R.id.btn_equals);
            one.performClick();
            plus.performClick();
            one.performClick();
            equals.performClick();
            TextView display = a.findViewById(R.id.display);
            int numOfDisplay = Integer.parseInt((String) display.getText());
            assertEquals(numOfDisplay, 2);
        });
    }

}
