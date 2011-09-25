(ns SkimClj.Handlers.QuestionHandlerSpec
  (:use [speclj.core] [SkimClj.Handlers.QuestionHandler])
  (:import (Tests.Handlers HandlerTestHelpers)))

(describe "Question Handler"
  (it "calls the question method"
    (should (HandlerTestHelpers/mockExecute "/question/0")))
  (it "renders the question page"
    (should (HandlerTestHelpers/page (the-question (new Handlers.QuestionHandler) "/question/0") "answers"))))
