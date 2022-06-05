package blackjack.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class DealerTest : FreeSpec({

    "참가자가 카드 추가를 요청하는 경우 카드를 추가한다" {
        val player = createPlayer(
            Card(Suite.HEARTS, Denomination.FOUR),
        )

        createDealer().giveCard(player)

        player.hand.count shouldBe 2
    }

    "참가자 이름을 받아 카드 2장을 가진 참가자를 생성한다" {
        val player = createDealer().makePlayer("user")

        player.name shouldBe "user"
        player.hand shouldBe Hand(
            listOf(
                Card(Suite.SPADES, Denomination.FIVE),
                Card(Suite.SPADES, Denomination.FOUR),
            )
        )
    }
})

fun createDealer(): Dealer = Dealer(
    Deck(
        listOf(
            Card(Suite.SPADES, Denomination.FIVE),
            Card(Suite.SPADES, Denomination.FOUR),
        )
    )
)

fun createPlayer(vararg cards: Card): Player = Player("player", Hand(cards.toList()))