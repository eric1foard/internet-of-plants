(ns internet-of-plants.subscriber
  (:gen-class)
  (:require [langohr.core      :as rmq]
            [langohr.channel   :as lch]
            [langohr.queue     :as lq]
            [langohr.consumers :as lc]
            [langohr.basic     :as lb]))

(def ^{:const true}
  default-exchange-name "")

(defn message-handler
  [ch {:keys [content-type delivery-tag type] :as meta} ^bytes payload]
  (println (format "[consumer] Received a message: %s, delivery tag: %d, content type: %s, type: %s"
                   (String. payload "UTF-8") delivery-tag content-type type)))

(defn -main
  [& args]
(Thread/sleep 15000)
  (let [conn  (rmq/connect {:username "guest", :password "guest", :vhost "/", :host "rabbitmq", :port 5672})
        ch    (lch/open conn)
        qname "langohr.examples.hello-world"]
    (println (format "subscriber Connected. Channel id: %d" (.getChannelNumber ch)))
    (lc/subscribe ch qname message-handler {:auto-ack true})
    (Thread/sleep 2000)
    (println "subscriber Disconnecting...")
    (rmq/close ch)
    (rmq/close conn)))