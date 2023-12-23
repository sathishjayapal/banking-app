package me.sathish.cards.controllers;

import me.sathish.cards.common.AbstractIntegrationTest;

class CardControllerIT extends AbstractIntegrationTest {

    //    @Autowired private CardRepository cardRepository;
    //
    //    private List<Card> cardList = null;
    //
    //    @BeforeEach
    //    void setUp() {
    //        cardRepository.deleteAllInBatch();
    //
    //        cardList = new ArrayList<>();
    //        cardList.add(new Card(null, "First Card"));
    //        cardList.add(new Card(null, "Second Card"));
    //        cardList.add(new Card(null, "Third Card"));
    //        cardList = cardRepository.saveAll(cardList);
    //    }
    //
    //    @Test
    //    void shouldFetchAllCards() throws Exception {
    //        this.mockMvc
    //                .perform(get("/api/cards"))
    //                .andExpect(status().isOk())
    //                .andExpect(jsonPath("$.data.size()", is(cardList.size())))
    //                .andExpect(jsonPath("$.totalElements", is(3)))
    //                .andExpect(jsonPath("$.pageNumber", is(1)))
    //                .andExpect(jsonPath("$.totalPages", is(1)))
    //                .andExpect(jsonPath("$.isFirst", is(true)))
    //                .andExpect(jsonPath("$.isLast", is(true)))
    //                .andExpect(jsonPath("$.hasNext", is(false)))
    //                .andExpect(jsonPath("$.hasPrevious", is(false)));
    //    }
    //
    //    @Test
    //    void shouldFindCardById() throws Exception {
    //        Card card = cardList.get(0);
    //        Long cardId = card.getId();
    //
    //        this.mockMvc
    //                .perform(get("/api/cards/{id}", cardId))
    //                .andExpect(status().isOk())
    //                .andExpect(jsonPath("$.id", is(card.getId()), Long.class))
    //                .andExpect(jsonPath("$.text", is(card.getText())));
    //    }
    //
    //    @Test
    //    void shouldCreateNewCard() throws Exception {
    //        Card card = new Card(null, "New Card");
    //        this.mockMvc
    //                .perform(
    //                        post("/api/cards")
    //                                .contentType(MediaType.APPLICATION_JSON)
    //                                .content(objectMapper.writeValueAsString(card)))
    //                .andExpect(status().isCreated())
    //                .andExpect(jsonPath("$.id", notNullValue()))
    //                .andExpect(jsonPath("$.text", is(card.getText())));
    //    }
    //
    //    @Test
    //    void shouldReturn400WhenCreateNewCardWithoutText() throws Exception {
    //        Card card = new Card(null, null);
    //
    //        this.mockMvc
    //                .perform(
    //                        post("/api/cards")
    //                                .contentType(MediaType.APPLICATION_JSON)
    //                                .content(objectMapper.writeValueAsString(card)))
    //                .andExpect(status().isBadRequest())
    //                .andExpect(header().string("Content-Type", is("application/problem+json")))
    //                .andExpect(jsonPath("$.type", is("about:blank")))
    //                .andExpect(jsonPath("$.title", is("Constraint Violation")))
    //                .andExpect(jsonPath("$.status", is(400)))
    //                .andExpect(jsonPath("$.detail", is("Invalid request content.")))
    //                .andExpect(jsonPath("$.instance", is("/api/cards")))
    //                .andExpect(jsonPath("$.violations", hasSize(1)))
    //                .andExpect(jsonPath("$.violations[0].field", is("text")))
    //                .andExpect(jsonPath("$.violations[0].message", is("Text cannot be empty")))
    //                .andReturn();
    //    }
    //
    //    @Test
    //    void shouldUpdateCard() throws Exception {
    //        Card card = cardList.get(0);
    //        card.setText("Updated Card");
    //
    //        this.mockMvc
    //                .perform(
    //                        put("/api/cards/{id}", card.getId())
    //                                .contentType(MediaType.APPLICATION_JSON)
    //                                .content(objectMapper.writeValueAsString(card)))
    //                .andExpect(status().isOk())
    //                .andExpect(jsonPath("$.id", is(card.getId()), Long.class))
    //                .andExpect(jsonPath("$.text", is(card.getText())));
    //    }
    //
    //    @Test
    //    void shouldDeleteCard() throws Exception {
    //        Card card = cardList.get(0);
    //
    //        this.mockMvc
    //                .perform(delete("/api/cards/{id}", card.getId()))
    //                .andExpect(status().isOk())
    //                .andExpect(jsonPath("$.id", is(card.getId()), Long.class))
    //                .andExpect(jsonPath("$.text", is(card.getText())));
    //    }
}
