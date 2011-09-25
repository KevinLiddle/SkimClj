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
      [:h2 {:class "question"} (prompt question-id)]
      [:table {:class "answers"}
       (for [i (range 0 (count (options question-id)))]
         [:tr
          [:td
           [:a {:href (str "/question/" question-id "/answer/" i)} (nth (options question-id) i)]]])]]]))
