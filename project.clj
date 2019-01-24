(defproject internet-of-plants "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [com.novemberain/langohr "5.1.0"]
                 [http-kit "2.3.0"]
                 [compojure "1.6.1"]]
  :main "internet-of-plants.server"
  :target-path "target/%s"
  :profiles {:publisher {:main internet-of-plants.publisher}
             :subscriber {:main internet-of-plants.subscriber}
             :uberjar {:aot :all}}
  :aliases {"publisher" ["with-profile" "publisher" "run"]
            "subscriber" ["with-profile" "subscriber" "run"]})
