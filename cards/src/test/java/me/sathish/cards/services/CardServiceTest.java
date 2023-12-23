package me.sathish.cards.services;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CardServiceTest {
    //
    //    @Mock private CardRepository cardRepository;
    //
    //    @InjectMocks private CardService cardService;
    //
    //    @Test
    //    void findAllCards() {
    //        // given
    //        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC, "id"));
    //        Page<Card> cardPage = new PageImpl<>(List.of(getCard()));
    //        given(cardRepository.findAll(pageable)).willReturn(cardPage);
    //
    //        // when
    //        PagedResult<Card> pagedResult = cardService.findAllCards(0, 10, "id", "asc");
    //
    //        // then
    //        assertThat(pagedResult).isNotNull();
    //        assertThat(pagedResult.data()).isNotEmpty().hasSize(1);
    //        assertThat(pagedResult.hasNext()).isFalse();
    //        assertThat(pagedResult.pageNumber()).isEqualTo(1);
    //        assertThat(pagedResult.totalPages()).isEqualTo(1);
    //        assertThat(pagedResult.isFirst()).isTrue();
    //        assertThat(pagedResult.isLast()).isTrue();
    //        assertThat(pagedResult.hasPrevious()).isFalse();
    //        assertThat(pagedResult.totalElements()).isEqualTo(1);
    //    }
    //
    //    @Test
    //    void findCardById() {
    //        // given
    //        given(cardRepository.findById(1L)).willReturn(Optional.of(getCard()));
    //        // when
    //        Optional<Card> optionalCard = cardService.findCardById(1L);
    //        // then
    //        assertThat(optionalCard).isPresent();
    //        Card card = optionalCard.get();
    //        assertThat(card.getId()).isEqualTo(1L);
    //        assertThat(card.getText()).isEqualTo("junitTest");
    //    }
    //
    //    @Test
    //    void saveCard() {
    //        // given
    //        given(cardRepository.save(getCard())).willReturn(getCard());
    //        // when
    //        Card persistedCard = cardService.saveCard(getCard());
    //        // then
    //        assertThat(persistedCard).isNotNull();
    //        assertThat(persistedCard.getId()).isEqualTo(1L);
    //        assertThat(persistedCard.getText()).isEqualTo("junitTest");
    //    }
    //
    //    @Test
    //    void deleteCardById() {
    //        // given
    //        willDoNothing().given(cardRepository).deleteById(1L);
    //        // when
    //        cardService.deleteCardById(1L);
    //        // then
    //        verify(cardRepository, times(1)).deleteById(1L);
    //    }
    //
    //    private Card getCard() {
    //        Card card = new Card();
    //        card.setId(1L);
    //        card.setText("junitTest");
    //        return card;
    //    }
}
