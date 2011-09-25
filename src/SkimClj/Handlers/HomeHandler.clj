(ns SkimClj.Handlers.HomeHandler
  (:import (Handlers Handler))
  (:gen-class
    :name Handlers.HomeHandler
    :extends Handlers.Handler
    :methods [[home [String] java.io.BufferedReader]]
    :prefix "the-"))

(defn the-home [this request]
  (#(.renderFile %1 %2) this "home.html"))
