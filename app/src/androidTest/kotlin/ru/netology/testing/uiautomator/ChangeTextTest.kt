package ru.netology.testing.uiautomator

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

const val MODEL_PACKAGE = "ru.netology.testing.uiautomator"
const val TIMEOUT = 5000L

@RunWith(AndroidJUnit4::class)
class ChangeTextTest {

    private lateinit var device: UiDevice
    private val textToSet = "Netology"

//    @Test
//    fun testInternetSettings() {
//        // Press home
//        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
//        device.pressHome()
//
//        // Wait for launcher
//        val launcherPackage = device.launcherPackageName
//        device.wait(Until.hasObject(By.pkg(launcherPackage)), TIMEOUT)
//        waitForPackage(SETTINGS_PACKAGE)
//
//        val context = ApplicationProvider.getApplicationContext<Context>()
//        val intent = context.packageManager.getLaunchIntentForPackage(SETTINGS_PACKAGE)
//        context.startActivity(intent)
//        device.wait(Until.hasObject(By.pkg(SETTINGS_PACKAGE)), TIMEOUT)
//
//        device.findObject(
//            UiSelector().resourceId("android:id/title").instance(0)
//        ).click()
//    }

//    @Test
//    fun testChangeText() {
//        // Press home
//        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
//        device.pressHome()
//
//        // Wait for launcher
//        val launcherPackage = device.launcherPackageName
//        device.wait(Until.hasObject(By.pkg(launcherPackage)), TIMEOUT)
//        waitForPackage(SETTINGS_PACKAGE)
//
//        val context = ApplicationProvider.getApplicationContext<Context>()
//        val packageName = context.packageName
//        val intent = context.packageManager.getLaunchIntentForPackage(packageName)
//        context.startActivity(intent)
//        device.wait(Until.hasObject(By.pkg(packageName)), TIMEOUT)
//
//
//        device.findObject(By.res(packageName, "userInput")).text = textToSet
//        device.findObject(By.res(packageName, "buttonChange")).click()
//
//        val result = device.findObject(By.res(packageName, "textToBeChanged")).text
//        assertEquals(result, textToSet)
//    }

    private fun waitForPackage(packageName: String) {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val intent = context.packageManager.getLaunchIntentForPackage(packageName)
        context.startActivity(intent)
        device.wait(Until.hasObject(By.pkg(packageName)), TIMEOUT)
    }

    @Before
    fun beforeEachTest() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        device.pressHome()

        // Wait for launcher
        val launcherPackage = device.launcherPackageName
        device.wait(Until.hasObject(By.pkg(launcherPackage)), TIMEOUT)
        val packageName = MODEL_PACKAGE
        waitForPackage(packageName)
    }

    val packageName = MODEL_PACKAGE
    @Test
    fun testChangeText() {
        //val packageName = MODEL_PACKAGE
        //waitForPackage(packageName)

        device.findObject(By.res(packageName, "userInput")).text = textToSet
        device.findObject(By.res(packageName, "buttonChange")).click()

        val result = device.findObject(By.res(packageName, "textToBeChanged")).text
        assertEquals(result, textToSet)
    }
    @Test
    fun testChangeText1() {
        val before = device.findObject(By.res(packageName, "textToBeChanged")).text

        device.findObject(By.res(packageName, "userInput")).text = ""
        device.findObject(By.res(packageName, "buttonChange")).click()

        val result = device.findObject(By.res(packageName, "textToBeChanged")).text
        assertEquals(result, before)
    }
    @Test
    fun testChangeText2() {
        val before = device.findObject(By.res(packageName, "textToBeChanged")).text

        device.findObject(By.res(packageName, "userInput")).text = ""
        device.findObject(By.res(packageName, "buttonChange")).click()

        val result = device.findObject(By.res(packageName, "textToBeChanged")).text
        assertEquals(result, before)
    }
    @Test
    fun testChangeText3() {
        device.findObject(By.res(packageName, "userInput")).text = textToSet
        device.findObject(By.res(packageName, "buttonActivity")).click()
        device.wait(Until.hasObject(By.pkg(packageName)), TIMEOUT)

        val result = device.findObject(By.res(packageName, "text")).text
        assertEquals(result, textToSet)
    }
}



