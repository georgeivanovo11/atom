package hello;


import org.junit.Test;
import org.junit.Ignore;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class Tests {
    @Test
    public void shouldCalculateCowsAndBulls1() {
        HashMap<String,Integer> result = Engine.calculate("atom","java");

        assertThat(result.get("cows"), is(equalTo(1)));
        assertThat(result.get("bulls"), is(equalTo(0)));
    }

    @Test
    public void shouldCalculateCowsAndBulls2() {
        HashMap<String,Integer> result = Engine.calculate("lava","java");

        assertThat(result.get("cows"), is(equalTo(0)));
        assertThat(result.get("bulls"), is(equalTo(3)));
    }

    @Test
    public void shouldCalculateCowsAndBulls3() {
        HashMap<String,Integer> result = Engine.calculate("oooo","java");

        assertThat(result.get("cows"), is(equalTo(0)));
        assertThat(result.get("bulls"), is(equalTo(0)));
    }

}