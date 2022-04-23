package tests.app;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class AndroidTests extends tests.app.TestBase {
    @Owner("QA.GURU")
    @DisplayName("Looking for Johnny")
    @Test
    void newSearchTest() {
        step("Go ahead without welcome window", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click());
        step("Start to search", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("Johnny Depp");
        });
        step("Glad to see my favorite actor", () ->
                $$(byClassName("android.widget.TextView")).shouldHave(sizeGreaterThan(1)));
    }
}
