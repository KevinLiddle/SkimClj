(ns SkimClj.views.answer
  (:use [hiccup.core]
        [SkimClj.Models.Question]))

(defn reaction [image-source image-alt audio-source message]
  (html
    [:img {:src image-source :alt image-alt}]
    [:h2 message]
    [:embed {:src audio-source :autostart "true" :hidden "true" :loop "false"}]))

(defn yes []
  (reaction "http://dl.dropbox.com/u/16607608/Skim_yes.png" "Yessss" "http://dl.dropbox.com/u/16607608/SkimYes.mp3" "Skim is satisfied."))

(defn sigh []
  (reaction "http://dl.dropbox.com/u/16607608/Skim_sigh.png" "Ugh..." "http://dl.dropbox.com/u/16607608/Skim_sigh.mp3" "Skim is disappointed."))

(defn next-question [next-question-id]
  (html
    [:a {:href (str "/question/" next-question-id)} "Next Question"]))

(defn end []
  (html
    [:a {:href "/end"} "Results"]))

(defn answer [next-question-id correct]
  (html
    [:html
     [:head
      [:link {:rel "stylesheet" :type "text/css" :href "/application.css"}]
      [:title "SkimBot 3000"]]
     [:body
      (if correct
        (yes)
        (sigh))
      (if (<= next-question-id (- (count questions) 1))
        (next-question next-question-id)
        (end))]]))
