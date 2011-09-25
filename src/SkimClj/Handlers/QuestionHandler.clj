(ns SkimClj.Handlers.QuestionHandler
  (:use [SkimClj.views.question])
  (:import (Handlers Handler))
  (:gen-class
    :name Handlers.QuestionHandler
    :extends Handlers.Handler
    :methods [[question [String] java.io.BufferedReader]]
    :prefix "the-"))

(defn the-question [this request]
  (#(.renderHTMLString %1 %2)
      this
      (question
        (.get (#(.getIDs %1 %2) this request) 0))))
