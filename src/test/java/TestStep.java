import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class TestStep {
    @Test
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });
        step("Вводим в поле поиска 'Allure'", () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys("Allure");
            $(".header-search-input").submit();
        });
        step("Переход по ссылке 'allure-framework/allure-java'", () -> {
            $(linkText("allure-framework/allure-java")).click();
        });
        step("Кликаем по таб 'Issues'", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issue с хэштегом 904", () -> {
            $(withText("#904")).should(Condition.exist);
        });
    }

    @Test
    public void annotatedStep() {
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepo();
        steps.followLink();
        steps.clickIssues();
        steps.checkHashtag();
    }
}