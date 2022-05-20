
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class CardTest {

    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @Test
    void cardOrderMeetingDate() {
        String firstMeetingDay = DataGenerator.generateDate(4);
        String secondMeetingDay = DataGenerator.generateDate(6);
        $("[data-test-id='city'] input").setValue(DataGenerator.generateCity("ru"));
        $("[data-test-id='date'] input").sendKeys(Keys.CONTROL + "a");
        $("[data-test-id='date'] input").sendKeys(Keys.DELETE);
        $("[data-test-id='date'] input").setValue(firstMeetingDay);
        $(By.name("name")).setValue(DataGenerator.generateName("ru"));
        $(By.name("phone")).setValue(DataGenerator.generatePhone("ru"));
        $("[data-test-id='agreement']").click();
        $("div .button").click();
        $(".notification__title").should(visible);
        $(withText("Встреча успешно запланирована на " + firstMeetingDay));

        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(secondMeetingDay);
        $("div .button").click();
        $(withText("У вас уже запланирована встреча на другую дату.Перепланировать?"));
        $("[data-test-id='replan-notification'] .button").click();
        $(withText("Встреча успешно запланирована на " + secondMeetingDay));
    }


}


