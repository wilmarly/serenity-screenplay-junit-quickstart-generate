package starter;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.ui.InputField;
import net.serenitybdd.screenplay.ui.PageElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Keys;

@DisplayName("Searching On Wikipedia")
@ExtendWith(SerenityJUnit5Extension.class)
class SampleTest {

   @CastMember
   Actor wendy;

   @Test
   void whenSearchingByKeyword() {
      wendy.attemptsTo(
              Open.url("https://en.wikipedia.org/wiki/Main_Page"),

              Enter.theValue("Cucumber").into(InputField.called("search")).thenHit(Keys.ENTER),

              Ensure.that(PageElement.called("firstHeading")).text().contains("Cucumber")
      );
   }
}
