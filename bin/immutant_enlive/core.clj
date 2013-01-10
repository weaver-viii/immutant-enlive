(ns immutant_enlive.core 
  (:use compojure.core)
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [compojure.response :as response]
            [noir.util.middleware :as noirmw]
            [hiccup.middleware :only [wrap-base-url]]
            [immutant.web.session :as immutant-session]
            [tutorial.template1]
            [tutorial.template2]
            [tutorial.template3]))

(defn ring-handler [request]
  {:status 200
    :headers {"Content-Type" "text/html"}
    :body "Hello from Immutant!" })

(defn another-ring-handler [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "Pssst! Over here!"})

(defroutes main-routes
  (GET "/" [] ring-handler)
  (context "/tutorial1" [] tutorial.template1/routes)
  (context "/tutorial2" [] tutorial.template2/routes)
  (context "/tutorial3" [] tutorial.template3/routes)
  (route/resources "/")
  (route/not-found "Page not found"))

(def app
  (-> (handler/site main-routes {:session {:store (immutant-session/servlet-store)}})
      (hiccup.middleware/wrap-base-url)))