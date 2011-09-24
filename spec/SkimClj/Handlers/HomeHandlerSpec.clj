(ns SkimClj.Handlers.HomeHandlerSpec
  (:use [speclj.core] [SkimClj.Handlers.HomeHandler])
  (:import (Tests.Handlers HandlerTestHelpers)))

(describe "Home Handling"
  (it "returns a Buffered Reader for the home page"
    (should (HandlerTestHelpers/page (the-home (new Handlers.HomeHandler) "/") "SkimBot 3000"))))

(run-specs)

