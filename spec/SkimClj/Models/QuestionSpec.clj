(ns SkimClj.Models.QuestionSpec
  (:use [speclj.core] [SkimClj.Models.Question]))

(describe "Question Model"
  (it "checks the answer of question 0"
    (should (check-answer 0 0)))
  (it "checks a wrong answer"
    (should-not (check-answer 4 1))))
