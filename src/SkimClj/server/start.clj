(ns SkimClj.server.start
  (:import (HTTPServer Server)
           (HTTPServer SocketCommunication)))

(defn -main []
  (. (new Server 3000 (new SocketCommunication)) (start)))
