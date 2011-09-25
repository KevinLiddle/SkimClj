(ns SkimClj.Handlers.QuestionHandlerSpec
  (:use [speclj.core] [SkimClj.Handlers.QuestionHandler])
  (:import (Tests.Handlers HandlerTestHelpers)))

(describe "Question Handler"
  (it "calls the question method"
    (should (HandlerTestHelpers/mockExecute "/question/0")))
  (it "renders the question page"
    (should (HandlerTestHelpers/page (the-question (new Handlers.QuestionHandler) "/question/0") "answers")))
  (it "calls the result method"
    (should (HandlerTestHelpers/mockExecute "/question/0/answer/0")))
  (it "renders a disappointed skim when answering wrong"
    (should (HandlerTestHelpers/page (the-result (new Handlers.QuestionHandler) "/question/0/answer/1") "sigh")))
  (it "renders a satisfied skim when answering correctly"
    (should (HandlerTestHelpers/page (the-result (new Handlers.QuestionHandler) "/question/0/answer/0") "yes")))
  (it "links to the next question"
    (should (HandlerTestHelpers/page (the-result (new Handlers.QuestionHandler) "/question/2/answer/5") "/question/3")))
  (it "links to the end after last question is answered"
    (should (HandlerTestHelpers/page (the-result (new Handlers.QuestionHandler) "/question/9/answer/0") "/end")))
  (it "calls end method"
    (should (HandlerTestHelpers/mockExecute "/end"))))
