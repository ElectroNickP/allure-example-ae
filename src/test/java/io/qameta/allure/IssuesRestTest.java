package io.qameta.allure;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.parameter;

@Layer("rest")
@Owner("baev")
@Feature("Issues")
public class IssuesRestTest {

    private static final String OWNER = "allure-framework";
    private static final String REPO = "allure2";

    private final RestSteps steps = new RestSteps();

    @TM4J("AE-T1")
    @Story("!"№;%:EDRTYUJIK< MVCFXEXDCFTGYHUJIKOrdtyimyuintiumiUTINUY)876*&%^TFUYTD$#Q%dr64w53w65rd754w64edtf8675e75rcy009-kij98uj0ijniut&%E^$AS%EX&TF(YUI()JOJUT*^%E$%SCV6eq43215wst4es543qes4%Q$s54es65rc97yt97yh09i=0u9t78d8t8f65sw7tyc7rd3ytvuytr8g
")
    @Microservice("Billing")
    @JiraIssues({@JiraIssue("AE-1")})
    @Tags({@Tag("api"), @Tag("smoke")})
    @ParameterizedTest(name = "Create issue via api")
    @ValueSource(strings = {"First Note", "Second Note"})
    public void shouldCreateUserNote(String title) {
        parameter("owner", OWNER);
        parameter("repo", REPO);
        parameter("title", title);

        steps.createIssueWithTitle(OWNER, REPO, title);
        steps.shouldSeeIssueWithTitle(OWNER, REPO, title);
    }

    @TM4J("AE-T2")
    @Story("Close existing issue")
    @Microservice("Repository")
    @Tags({@Tag("api"), @Tag("regress")})
    @JiraIssues({@JiraIssue("AE-1")})
    @ParameterizedTest(name = "Close issue via api")
    @ValueSource(strings = {"First Note", "Second Note"})
    public void shouldDeleteUserNote(String title) {
        parameter("owner", OWNER);
        parameter("repo", REPO);
        parameter("title", title);

        steps.createIssueWithTitle(OWNER, REPO, title);
        steps.closeIssueWithTitle(OWNER, REPO, title);
    }


}
