(ns internet-of-plants.server
  (:gen-class)
  (:use [compojure.route :only [not-found]]
        [compojure.core :only [defroutes POST]]
        org.httpkit.server))

(defn publish-reading
  [req]
  "cool stuff bro")

; compojure example: http://www.http-kit.org/server.html#routing
(defroutes routes
  (POST "/plants" [] publish-reading)
  (not-found "<p>Page not found.</p>"))

(defn -main [& args]
  (run-server routes {:port 8080}))