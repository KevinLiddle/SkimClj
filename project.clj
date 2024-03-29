(defproject SkimClj "1.0.0-SNAPSHOT"
  :description "Skimmin it up with Clojure"
  :dependencies [[org.clojure/clojure "1.2.1"]]
  :dev-dependencies [[speclj "1.4.0"] [hiccup "0.3.6"]]
  :test-path "spec/"
  :aot [SkimClj.server.start
        SkimClj.Handlers.HomeHandler
        SkimClj.Handlers.HomeHandlerSpec
        SkimClj.Handlers.QuestionHandler
        SkimClj.Handlers.QuestionHandlerSpec]
  :main SkimClj.server.start)

