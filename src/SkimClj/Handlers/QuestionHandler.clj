(ns SkimClj.Handlers.QuestionHandler
  (:use [SkimClj.views.question]
        [SkimClj.views.answer]
        [SkimClj.Models.Question])
  (:import (Handlers Handler))
  (:gen-class
    :name Handlers.QuestionHandler
    :extends Handlers.Handler
    :methods [[question [String] java.io.BufferedReader]
              [result [String] java.io.BufferedReader]
              [end [String] java.io.BufferedReader]]
    :prefix "the-"))

(defn the-question [this request]
  (#(.renderHTMLString %1 %2)
      this
      (question
        (.get (#(.getIDs %1 %2) this request) 0))))

(defn the-result [this request]
  (#(.renderHTMLString %1 %2)
      this
      (answer
        (+ 1 (.get (#(.getIDs %1 %2) this request) 0))
        (check-answer (.get (#(.getIDs %1 %2) this request) 0) (.get (#(.getIDs %1 %2) this request) 1)))))

(defn the-end [this request]
  (#(.renderFile %1 %2)
      this
      "Disappointed.html"))
