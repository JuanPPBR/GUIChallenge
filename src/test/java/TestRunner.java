import Pages.*;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TestRunner extends Hooks{

    @Test
    public void SuccessfulLogin(){

        Data data = null;

        String username = Data.getUsername();
        String password = Data.getPassword();

        HomePage homePage = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        homePage.clickLoginButton()
                .typingUsername(username)
                .typingPassword(password)
                .clickLoginButton();

        assertEquals(profilePage.getContentWrapper(), username);

    }

    @Test
    public void FailedLogin(){

        Data data = null;
        String username = Data.getUsername();
        String invalidPassword = Data.getInvalidPassword();

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.clickLoginButton()
                .typingUsername(username)
                .typingPassword(invalidPassword)
                .clickLoginButton();

        loginPage.waitThereWasAProblem()
                .typingPassword(invalidPassword)
                .clickLoginButton();

        loginPage.waitThereWasAProblem()
                .typingPassword(invalidPassword)
                .clickLoginButton();

        assertEquals("You have 7 remaining login attempts.",loginPage.getTextRedBox());

    }

    @Test
    public void SuccessfulSearch(){

        String titleMovie = "Fight Club";
        HomePage homePage = new HomePage(driver);
        SearchQueryPage searchQueryPage = new SearchQueryPage(driver);

        homePage.typingInSearchBar(titleMovie)
                .clickSearchButton();

        assertEquals(searchQueryPage.titleFirstMove(), titleMovie);
    }

    @Test
    public void VerifyMovieGenreFilter(){

        String genre = "Action";
        int sixthMovie = 6;

        HomePage homePage = new HomePage(driver);
        MoviePage moviePage = new MoviePage(driver);

        homePage.clickMovieButton()
                .clickTopRatedInDropMenu()
                .clickFilterButton()
                .clickActionButton()
                .clickFilterButton()
                .clickSearchButton()
                .clickSearchButtonByAction()
                .selectMovie(sixthMovie);

        assertTrue(moviePage.getGenres(genre));
    }

    @Test
    public void ValidateActingTimeline(){

        int movieNumber = 2;

        HomePage homePage = new HomePage(driver);
        MoviePage moviePage = new MoviePage(driver);
        ActorPage actorPage = new ActorPage(driver);

        homePage.clickMovieButton()
                .clickTopRatedInDropMenu()
                .selectMovie(movieNumber);

        String titleMovie = moviePage.getTitleMovie();

        MoviePage.clickActor();

        assertTrue(actorPage.checkTimeline(titleMovie));
    }

    @Test
    public void SortByDatesOnAscendingOrder(){

        HomePage homePage = new HomePage(driver);
        MovieTopRatedPage movieTopRatedPage = new MovieTopRatedPage(driver);

        homePage.clickMovieButton()
                .clickTopRatedInDropMenu()
                .clickInDropdownMenuSort()
                .selectReleaseDateAscending()
                .clickSearchButton();

        assertTrue(movieTopRatedPage.checkReleaseDateAscending());
    }


}
