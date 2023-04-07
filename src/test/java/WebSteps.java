import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com/");
    }
    @Step("Вводим в поле поиска 'Allure'")
    public void searchForRepo() {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("Allure");
        $(".header-search-input").submit();
    }
    @Step("Переход по ссылке 'allure-framework/allure-java'")
    public void followLink() {
        $(linkText("allure-framework/allure-java")).click();
    }
    @Step("Кликаем по таб 'Issues'")
    public void clickIssues() {
        $("#issues-tab").click();
    }
    @Step("Проверяем наличие Issue с хэштегом 904")
    public void checkHashtag() {
        $(withText("#904")).should(Condition.exist);
    }
}