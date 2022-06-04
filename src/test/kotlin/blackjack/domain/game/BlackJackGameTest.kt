package blackjack.domain.game

import blackjack.domain.FixtureBuilder.Companion.TakeMoreFixture
import blackjack.domain.card.CardDeck
import blackjack.domain.player.PlayerMaker
import blackjack.view.ResultView
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class BlackJackGameTest {

    @Test
    fun `블랙잭 게임을 2인이 조인했을 때 인원 수 체크`() {
        val resultView = ResultView()
        val cardDeck = CardDeck()
        val takeMore = TakeMoreFixture(false)
        val playerMaker = PlayerMaker()
        val players = playerMaker.createPlayerByName(listOf("A", "B"))

        val blackJackGame = BlackJackGame(cardDeck, players, takeMore, resultView)

        blackJackGame.start()

        Assertions.assertThat(blackJackGame.players).hasSize(2)
    }

    @Test
    fun `블랙잭 게임을 2인이 조인했을 때 초기 카드 갯수 체크`() {
        val resultView = ResultView()
        val cardDeck = CardDeck()
        val takeMore = TakeMoreFixture(false)
        val playerMaker = PlayerMaker()
        val players = playerMaker.createPlayerByName(listOf("A", "B"))

        val blackJackGame = BlackJackGame(cardDeck, players, takeMore, resultView)

        blackJackGame.start()

        Assertions.assertThat(blackJackGame.players[0].receivedCards).hasSize(2)
        Assertions.assertThat(blackJackGame.players[1].receivedCards).hasSize(2)
    }
}