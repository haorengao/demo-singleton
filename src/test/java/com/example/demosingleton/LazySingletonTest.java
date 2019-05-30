package com.example.demosingleton;

import java.lang.reflect.Constructor;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoSingletonApplication.class)
public class LazySingletonTest {

    @Test
    public void testReflectSuccess() throws Exception {
        Constructor<?> constructor = LazySingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        LazySingleton singleton1 = (LazySingleton) constructor.newInstance();
        LazySingleton singleton2 = LazySingleton.getInstance();
        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());
        Assert.assertNotSame(singleton1, singleton2);
    }

    @Test
    public void testReflectFailure() throws Exception {
        LazySingleton singleton1 = LazySingleton.getInstance();
        Constructor<?> constructor = LazySingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        try {
            LazySingleton singleton2 = (LazySingleton) constructor.newInstance();
            Assert.fail();
        } catch (Exception e) {
            // Do nothing, test pass
        }
    }
}