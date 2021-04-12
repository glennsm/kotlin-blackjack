package blackjack.model

import blackjack.model.score.Score
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class JudgeTest {
    @ParameterizedTest
    @MethodSource("gamerOpponentProvider")
    fun `조건에 따라 승리 여부를 판단한다`(gamerScore: Score, opponentScore: Score, isWin: Boolean) {
        assertThat(Judge.isWin(gamerScore, opponentScore)).isEqualTo(isWin)
    }

    companion object {
        @JvmStatic
        private fun gamerOpponentProvider(): List<Arguments> {
            return listOf(
                Arguments {
                    arrayOf(
                        Score(15),
                        Score(13),
                        true
                    )
                },
                Arguments {
                    arrayOf(
                        Score(12),
                        Score(18),
                        false
                    )
                },
                Arguments {
                    arrayOf(
                        Score(23),
                        Score(18),
                        false
                    )
                },
                Arguments {
                    arrayOf(
                        Score(12),
                        Score(25),
                        true
                    )
                },
                Arguments {
                    arrayOf(
                        Score(21, true),
                        Score(21, false),
                        true
                    )
                },
                Arguments {
                    arrayOf(
                        Score(21, false),
                        Score(21, true),
                        false
                    )
                }
            )
        }
    }
}