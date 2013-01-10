(ns immutant.init
  (:use immutant_enlive.core)
  (:require [immutant.web :as web]
            [immutant.util :as util]
            [immutant.messaging :as msg]
            [tutorial.template1 :as tut]
            [tutorial.template2 :as tut2]))
;; This file will be loaded when the application is deployed to Immutant, and
;; can be used to start services your app needs. Examples:


;; Web endpoints need a context-path and ring handler function. The context
;; path given here is a sub-path to the global context-path for the app
;; if any.

; (web/start "/" my-ring-handler)
; (web/start "/foo" a-different-ring-handler)
(web/start #'app :reload true)
(web/start "/tut" tut/routes)
(web/start "/tut2" tut2/routes)
;; To start a Noir app:
; (server/load-views (util/app-relative "src/immutant_enlive/views"))
; (web/start "/" (server/gen-handler {:mode :dev :ns 'immutant-enlive}))


;; Messaging allows for starting (and stopping) destinations (queues & topics)
;; and listening for messages on a destination.

; (messaging/start "/queue/a-queue")
; (messaging/listen "/queue/a-queue" #(println "received: " %))
(msg/start "queue.work")   ; to start a queue
(msg/start "topic.news")   ; to start a topic

