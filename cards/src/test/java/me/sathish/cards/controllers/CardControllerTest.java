package me.sathish.cards.controllers;

import static me.sathish.cards.utils.CardMSConstants.PROFILE_TEST;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;

@WebMvcTest(controllers = CardController.class)
@ActiveProfiles(PROFILE_TEST)
class CardControllerTest {

    //    @Autowired private MockMvc mockMvc;
    //
    //    @MockBean private CardService cardService;
    //
    //    @Autowired private ObjectMapper objectMapper;
    //
    //    private List<Card> cardList;
    //
    //    @BeforeEach
    //    void setUp() {
    //        this.cardList = new ArrayList<>();
    //        this.cardList.add(new Card(1L, "text 1"));
    //        this.cardList.add(new Card(2L, "text 2"));
    //        this.cardList.add(new Card(3L, "text 3"));
    //    }
    //
    //    @Test
    //    void shouldFetchAllCards() throws Exception {
    //        Page<Card> page = new PageImpl<>(cardList);
    //        PagedResult<Card> cardPagedResult = new PagedResult<>(page);
    //        given(cardService.findAllCards(0, 10, "id", "asc")).willReturn(cardPagedResult);
    //
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
    //        Long cardId = 1L;
    //        Card card = new Card(cardId, "text 1");
    //        given(cardService.findCardById(cardId)).willReturn(Optional.of(card));
    //
    //        this.mockMvc
    //                .perform(get("/api/cards/{id}", cardId))
    //                .andExpect(status().isOk())
    //                .andExpect(jsonPath("$.text", is(card.getText())));
    //    }
    //
    //    @Test
    //    void shouldReturn404WhenFetchingNonExistingCard() throws Exception {
    //        Long cardId = 1L;
    //        given(cardService.findCardById(cardId)).willReturn(Optional.empty());
    //
    //        this.mockMvc.perform(get("/api/cards/{id}", cardId)).andExpect(status().isNotFound());
    //    }
    //
    //    @Test
    //    void shouldCreateNewCard() throws Exception {
    //        given(cardService.saveCard(any(Card.class)))
    //                .willAnswer((invocation) -> invocation.getArgument(0));
    //
    //        Card card = new Card(1L, "some text");
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
    //        Long cardId = 1L;
    //        Card card = new Card(cardId, "Updated text");
    //        given(cardService.findCardById(cardId)).willReturn(Optional.of(card));
    //        given(cardService.saveCard(any(Card.class)))
    //                .willAnswer((invocation) -> invocation.getArgument(0));
    //
    //        this.mockMvc
    //                .perform(
    //                        put("/api/cards/{id}", card.getId())
    //                                .contentType(MediaType.APPLICATION_JSON)
    //                                .content(objectMapper.writeValueAsString(card)))
    //                .andExpect(status().isOk())
    //                .andExpect(jsonPath("$.text", is(card.getText())));
    //    }
    //
    //    @Test
    //    void shouldReturn404WhenUpdatingNonExistingCard() throws Exception {
    //        Long cardId = 1L;
    //        given(cardService.findCardById(cardId)).willReturn(Optional.empty());
    //        Card card = new Card(cardId, "Updated text");
    //
    //        this.mockMvc
    //                .perform(
    //                        put("/api/cards/{id}", cardId)
    //                                .contentType(MediaType.APPLICATION_JSON)
    //                                .content(objectMapper.writeValueAsString(card)))
    //                .andExpect(status().isNotFound());
    //    }
    //
    //    @Test
    //    void shouldDeleteCard() throws Exception {
    //        Long cardId = 1L;
    //        Card card = new Card(cardId, "Some text");
    //        given(cardService.findCardById(cardId)).willReturn(Optional.of(card));
    //        doNothing().when(cardService).deleteCardById(card.getId());
    //
    //        this.mockMvc
    //                .perform(delete("/api/cards/{id}", card.getId()))
    //                .andExpect(status().isOk())
    //                .andExpect(jsonPath("$.text", is(card.getText())));
    //    }
    //
    //    @Test
    //    void shouldReturn404WhenDeletingNonExistingCard() throws Exception {
    //        Long cardId = 1L;
    //        given(cardService.findCardById(cardId)).willReturn(Optional.empty());
    //
    //        this.mockMvc.perform(delete("/api/cards/{id}",
    // cardId)).andExpect(status().isNotFound());
    //    }
}
