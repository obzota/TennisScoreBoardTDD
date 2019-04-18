import org.junit.*;

public class TennisGameTest {

    @Test
    public void when_a_game_is_beginning_the_score_is_love_love () {
        /*
            The signature of a test will almost always be "public void ... () {...}"
            That is for the test framework (junit here) to pick up and run easily.
         */
        /*
            The name of the test function can be very long and descriptive.
            When a test fail, you want to understand from the name what has failed.
         */
        TennisGame startingGame = new TennisGame();

        String testedScore = startingGame.Score();

        Assert.assertEquals("love - love", testedScore);
    }

    @Test
    public void after_a_couple_points_the_score_has_changed () {
        /*
            A typical test follows the BUILD-OPERATE-CHECK structure.
            That way it is easy for other developers to see the code you are testing
         */

        // Build
        TennisGame game = new TennisGame();
        game.PlayerOneScores();
        game.PlayerTwoScores();
        game.PlayerOneScores();

        // Operate
        String testedScore = game.Score();

        // Check
        Assert.assertEquals("thirty - fifteen", testedScore);
    }

    @Test
    public void when_a_player_is_close_to_winning_the_score_displays_forty () {
        // Build
        TennisGame game = new TennisGame();
        game.PlayerTwoScores();
        game.PlayerOneScores();
        game.PlayerOneScores();
        game.PlayerOneScores();

        // Operate
        String testedScore = game.Score();

        // Check
        Assert.assertEquals(testedScore, "forty - fifteen");
    }

    @Test
    public void if_player_one_reaches_4_points_he_wins () {
        // Build
        TennisGame game = AGameWonByPlayerOne();

        // Operate
        String testedScore = game.Score();

        // Check
        Assert.assertEquals("Player 1 wins!", testedScore);
    }

    @Test
    public void if_player_two_reaches_4_points_he_wins () {
        // Build
        TennisGame game = AGameWonByPlayerTwo();

        // Operate
        String testedScore = game.Score();

        // Check
        Assert.assertEquals("Player 2 wins!", testedScore);
    }

    @Test
    public void after_playing_a_long_time_equality_means_deuce () {
        // Build
        TennisGame game = ALongGame();

        // Operate
        String testedScore = game.Score();

        // Check
        Assert.assertEquals("deuce", testedScore);
    }

    @Test
    public void after_playing_a_long_time_if_p1_score_he_takes_advantage () {
        // Build
        TennisGame game = ALongGame();
        game.PlayerOneScores();

        // Operate
        String testedScore = game.Score();

        // Check
        Assert.assertEquals("advantage - ", testedScore);
    }

    @Test
    public void after_playing_a_long_time_if_p2_score_he_takes_advantage () {
        // Build
        TennisGame game = ALongGame();
        game.PlayerTwoScores();

        // Operate
        String testedScore = game.Score();

        // Check
        Assert.assertEquals("- advantage", testedScore);
    }

    /*
        Helper functions
     */

    public TennisGame AGameWonByPlayerOne () {
        TennisGame p1Victory = new TennisGame();
        p1Victory.PlayerOneScores();
        p1Victory.PlayerOneScores();
        p1Victory.PlayerTwoScores();
        p1Victory.PlayerOneScores();
        p1Victory.PlayerOneScores();
        return p1Victory;
    }

    public TennisGame AGameWonByPlayerTwo () {
        TennisGame p1Victory = new TennisGame();
        p1Victory.PlayerOneScores();
        p1Victory.PlayerOneScores();
        p1Victory.PlayerTwoScores();
        p1Victory.PlayerTwoScores();
        p1Victory.PlayerTwoScores();
        p1Victory.PlayerTwoScores();
        return p1Victory;
    }


    public TennisGame ALongGame() {
        TennisGame game = new TennisGame();
        game.PlayerOneScores();
        game.PlayerTwoScores();
        game.PlayerOneScores();
        game.PlayerTwoScores();
        game.PlayerOneScores();
        game.PlayerTwoScores();
        game.PlayerOneScores();
        game.PlayerTwoScores();
        game.PlayerOneScores();
        game.PlayerTwoScores();
        game.PlayerOneScores();
        game.PlayerTwoScores();
        return game;
    }

}
