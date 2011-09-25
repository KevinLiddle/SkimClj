(ns SkimClj.views.question
  (:use [hiccup.core]
        [SkimClj.Models.Question]))

(defn question [question-id]
  (html
    [:html
     [:head
      [:link {:rel "stylesheet" :type "type/css" :href "/application.css"}]
      [:title "SkimBot 3000"]]
     [:body
      [:h2 {:class "question"} (get (nth questions question-id) :prompt)]
      [:table {:class "answers"}
       (for [i (range 0 (count (get (nth questions question-id) :options)))]
         [:tr
          [:td
           [:a {:href (str "/question/" question-id "/answer/" i)} (nth (get (nth questions question-id) :options) i)]]])]]]))
