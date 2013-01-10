(ns tutorial.template1
  (:require [net.cgrand.enlive-html :as html])
  (:use [net.cgrand.moustache :only [app]]
        [tutorial.utils :only [render-to-response maybe-content]]))

(html/deftemplate index "tutorial/template1.html"
  [ctxt]
  [:p#message] (maybe-content (:message ctxt)))

;; ========================================
;; The App
;; ========================================

(def routes
  (app
   [""]       (fn [req] (render-to-response
                         (index {})))
   ["change"] (fn [req] (render-to-response
                         (index {:message "We changed the message!"})))
   [&]        {:status 404
               :body "Page Not Found"}))
 